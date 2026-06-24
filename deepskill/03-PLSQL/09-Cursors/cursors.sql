SET SERVEROUTPUT ON;

CREATE TABLE employees (
    emp_id NUMBER PRIMARY KEY,
    emp_name VARCHAR2(100),
    salary NUMBER
);

INSERT INTO employees VALUES (1, 'John', 50000);
INSERT INTO employees VALUES (2, 'Jane', 60000);
INSERT INTO employees VALUES (3, 'Bob', 55000);
COMMIT;

-- Explicit Cursor
DECLARE
    CURSOR emp_cursor IS
        SELECT emp_id, emp_name, salary FROM employees;
    v_emp employees%ROWTYPE;
BEGIN
    OPEN emp_cursor;
    LOOP
        FETCH emp_cursor INTO v_emp;
        EXIT WHEN emp_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(v_emp.emp_id || ' - ' || v_emp.emp_name || ' - $' || v_emp.salary);
    END LOOP;
    CLOSE emp_cursor;
END;
/

-- Cursor FOR loop
BEGIN
    FOR emp_rec IN (SELECT * FROM employees) LOOP
        DBMS_OUTPUT.PUT_LINE(emp_rec.emp_id || ' - ' || emp_rec.emp_name);
    END LOOP;
END;
/

-- Parameterized Cursor
DECLARE
    CURSOR emp_cursor(min_salary NUMBER) IS
        SELECT emp_name, salary FROM employees WHERE salary >= min_salary;
BEGIN
    FOR emp_rec IN emp_cursor(55000) LOOP
        DBMS_OUTPUT.PUT_LINE(emp_rec.emp_name || ' earns $' || emp_rec.salary);
    END LOOP;
END;
/
