SET SERVEROUTPUT ON;

/*
  Problem: Create a PACKAGE emp_pkg with spec and body containing
  a procedure to get employee and a function to calculate bonus.
*/

-- Package Specification
CREATE OR REPLACE PACKAGE emp_pkg IS
  PROCEDURE get_employee(p_emp_id NUMBER);
  FUNCTION calculate_bonus(p_salary NUMBER, p_percent NUMBER) RETURN NUMBER;
END emp_pkg;
/
-- Package Body
CREATE OR REPLACE PACKAGE BODY emp_pkg IS

  PROCEDURE get_employee(p_emp_id NUMBER) IS
    v_ename emp.ename%TYPE;
  BEGIN
    SELECT ename INTO v_ename FROM emp WHERE empno = p_emp_id;
    DBMS_OUTPUT.PUT_LINE('Employee: ' || v_ename);
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      DBMS_OUTPUT.PUT_LINE('Employee not found');
  END get_employee;

  FUNCTION calculate_bonus(p_salary NUMBER, p_percent NUMBER) RETURN NUMBER IS
  BEGIN
    RETURN p_salary * (p_percent / 100);
  END calculate_bonus;

END emp_pkg;
/
-- Calling the package
BEGIN
  emp_pkg.get_employee(7369);
  DBMS_OUTPUT.PUT_LINE('Bonus: ' || emp_pkg.calculate_bonus(5000, 15));
END;
/
