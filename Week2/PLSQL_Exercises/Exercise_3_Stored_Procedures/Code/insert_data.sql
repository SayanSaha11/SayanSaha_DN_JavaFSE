INSERT INTO Customers VALUES (1, 'John Doe', TO_DATE('1960-05-15', 'YYYY-MM-DD'), 5000, SYSDATE);
INSERT INTO Customers VALUES (2, 'Jane Smith', TO_DATE('1985-07-20', 'YYYY-MM-DD'), 15000, SYSDATE);


INSERT INTO Accounts VALUES (1, 1, 'Savings', 2000, SYSDATE);
INSERT INTO Accounts VALUES (2, 2, 'Savings', 10000, SYSDATE);
INSERT INTO Accounts VALUES (3, 2, 'Checking', 500, SYSDATE); -- For fund transfer


INSERT INTO Transactions VALUES (1, 1, SYSDATE, 500, 'Deposit');
INSERT INTO Transactions VALUES (2, 2, SYSDATE, 1000, 'Withdrawal');


INSERT INTO Loans VALUES (1, 1, 10000, 6.5, SYSDATE, ADD_MONTHS(SYSDATE, 60));
INSERT INTO Loans VALUES (2, 2, 8000, 5.0, SYSDATE, ADD_MONTHS(SYSDATE, 20));


INSERT INTO Employees VALUES (1, 'Alice Johnson', 'Manager', 70000, 'HR', TO_DATE('2015-06-15', 'YYYY-MM-DD'));
INSERT INTO Employees VALUES (2, 'Bob Brown', 'Developer', 60000, 'IT', TO_DATE('2017-03-20', 'YYYY-MM-DD'));

COMMIT;