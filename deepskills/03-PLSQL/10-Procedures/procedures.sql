SET SERVEROUTPUT ON;

CREATE OR REPLACE PROCEDURE get_employee_count IS
    v_count NUMBER;
BEGIN
    SELECT COUNT(*) INTO v_count FROM employees;
    DBMS_OUTPUT.PUT_LINE('Total Employees: ' || v_count);
END get_employee_count;
/

EXEC get_employee_count;

CREATE OR REPLACE PROCEDURE update_salary(
    p_emp_id IN employees.emp_id%TYPE,
    p_increase IN NUMBER
) IS
BEGIN
    UPDATE employees SET salary = salary + p_increase WHERE emp_id = p_emp_id;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Salary updated for employee ' || p_emp_id);
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Employee not found');
END update_salary;
/

EXEC update_salary(1, 5000);
