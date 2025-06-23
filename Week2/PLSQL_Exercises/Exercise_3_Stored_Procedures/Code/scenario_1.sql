CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
  FOR acc IN (SELECT AccountID, Balance 
              FROM Accounts 
              WHERE AccountType = 'Savings') LOOP

    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01),
        LastModified = SYSDATE
    WHERE AccountID = acc.AccountID;

  END LOOP;

  DBMS_OUTPUT.PUT_LINE('Monthly interest applied to all savings accounts.');
  COMMIT;
END;
/
