SET SERVEROUTPUT ON;

DECLARE
    v_emp_id NUMBER := 101;
    v_emp_name VARCHAR2(100) := 'Alice Smith';
    v_salary NUMBER(8,2) := 75000.50;
    v_hire_date DATE := SYSDATE;
    v_is_active BOOLEAN := TRUE;
BEGIN
    DBMS_OUTPUT.PUT_LINE('Employee ID: ' || v_emp_id);
    DBMS_OUTPUT.PUT_LINE('Name: ' || v_emp_name);
    DBMS_OUTPUT.PUT_LINE('Salary: $' || v_salary);
    DBMS_OUTPUT.PUT_LINE('Hire Date: ' || TO_CHAR(v_hire_date, 'DD-MON-YYYY'));
    IF v_is_active THEN
        DBMS_OUTPUT.PUT_LINE('Status: Active');
    END IF;
END;
/
