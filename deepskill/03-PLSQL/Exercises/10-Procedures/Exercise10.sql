SET SERVEROUTPUT ON;

/*
  Problem: Create a PROCEDURE get_employee_name(p_emp_id NUMBER)
  that takes employee ID and prints the employee name.
  Call it with different IDs.
*/

CREATE OR REPLACE PROCEDURE get_employee_name(p_emp_id NUMBER) IS
  v_ename emp.ename%TYPE;
BEGIN
  SELECT ename INTO v_ename FROM emp WHERE empno = p_emp_id;
  DBMS_OUTPUT.PUT_LINE('Employee ID ' || p_emp_id || ' is ' || v_ename);
EXCEPTION
  WHEN NO_DATA_FOUND THEN
    DBMS_OUTPUT.PUT_LINE('No employee found with ID ' || p_emp_id);
END;
/
BEGIN
  get_employee_name(7369);
  get_employee_name(7902);
  get_employee_name(9999);
END;
/
