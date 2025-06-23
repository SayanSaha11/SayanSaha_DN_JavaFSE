BEGIN
  EXECUTE IMMEDIATE 'ALTER TABLE Customers ADD IsVIP CHAR(1)';
EXCEPTION
  WHEN OTHERS THEN
    IF SQLCODE = -01430 THEN NULL; 
    ELSE RAISE;
    END IF;
END;
/

BEGIN
  DECLARE
    v_count INTEGER := 0;
  BEGIN
    FOR c IN (
      SELECT CustomerID, Balance FROM Customers
    ) LOOP
      IF c.Balance > 10000 THEN
        UPDATE Customers
        SET IsVIP = 'Y'
        WHERE CustomerID = c.CustomerID;
        v_count := v_count + 1; -- increment count
      END IF;
    END LOOP;

    DBMS_OUTPUT.PUT_LINE(v_count || ' customer(s) marked as VIP.');
    COMMIT;
  END;
END;
/