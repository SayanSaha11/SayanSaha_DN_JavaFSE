SET SERVEROUTPUT ON;

DECLARE
  v_age NUMBER;
  v_count INTEGER := 0;
BEGIN
  FOR rec IN (SELECT c.CustomerID, l.LoanID, l.InterestRate, c.DOB
              FROM Customers c
              JOIN Loans l ON c.CustomerID = l.CustomerID) LOOP
    v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, rec.DOB) / 12);
    IF v_age > 60 THEN
      UPDATE Loans
      SET InterestRate = InterestRate - 1
      WHERE LoanID = rec.LoanID;
      v_count := v_count + 1;
    END IF;
  END LOOP;

  DBMS_OUTPUT.PUT_LINE(v_count || ' loan(s) updated with 1% interest discount.');
  COMMIT;
END;
/
