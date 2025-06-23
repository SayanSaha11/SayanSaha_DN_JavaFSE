CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
  p_department IN VARCHAR2,
  p_bonus_pct IN NUMBER
) IS
  v_count NUMBER := 0;
BEGIN
  FOR emp IN (SELECT EmployeeID, Salary 
              FROM Employees 
              WHERE Department = p_department) LOOP

    UPDATE Employees
    SET Salary = Salary + (Salary * p_bonus_pct / 100),
        HireDate = HireDate  -- Dummy update to trigger LastModified if needed
    WHERE EmployeeID = emp.EmployeeID;

    v_count := v_count + 1;
  END LOOP;

  DBMS_OUTPUT.PUT_LINE(v_count || ' employee(s) updated with bonus in department: ' || p_department);
  COMMIT;
END;
/
