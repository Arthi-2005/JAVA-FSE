SET SERVEROUTPUT ON;

CREATE OR REPLACE PACKAGE emp_pkg IS
    FUNCTION get_salary(p_emp_id NUMBER) RETURN NUMBER;
    PROCEDURE display_emp(p_emp_id NUMBER);
    g_company_name VARCHAR2(50) := 'Cognizant';
END emp_pkg;
/

CREATE OR REPLACE PACKAGE BODY emp_pkg IS

    FUNCTION get_salary(p_emp_id NUMBER) RETURN NUMBER IS
        v_salary employees.salary%TYPE;
    BEGIN
        SELECT salary INTO v_salary FROM employees WHERE emp_id = p_emp_id;
        RETURN v_salary;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN RETURN -1;
    END get_salary;

    PROCEDURE display_emp(p_emp_id NUMBER) IS
        v_emp employees%ROWTYPE;
    BEGIN
        SELECT * INTO v_emp FROM employees WHERE emp_id = p_emp_id;
        DBMS_OUTPUT.PUT_LINE('Company: ' || g_company_name);
        DBMS_OUTPUT.PUT_LINE('ID: ' || v_emp.emp_id || ', Name: ' || v_emp.emp_name);
    END display_emp;

END emp_pkg;
/

BEGIN
    DBMS_OUTPUT.PUT_LINE('Salary: $' || emp_pkg.get_salary(1));
    emp_pkg.display_emp(2);
END;
/
