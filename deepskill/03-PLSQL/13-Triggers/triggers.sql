SET SERVEROUTPUT ON;

CREATE OR REPLACE TRIGGER before_emp_insert
BEFORE INSERT ON employees
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('Inserting employee: ' || :NEW.emp_name);
    :NEW.emp_name := UPPER(:NEW.emp_name);
END;
/

INSERT INTO employees VALUES (4, 'Charlie', 65000);

CREATE OR REPLACE TRIGGER after_salary_update
AFTER UPDATE OF salary ON employees
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('Salary changed from $' || :OLD.salary || ' to $' || :NEW.salary);
END;
/

UPDATE employees SET salary = 70000 WHERE emp_id = 1;

-- Clean up
DROP TABLE employees PURGE;
DROP PACKAGE emp_pkg;
DROP FUNCTION calculate_bonus;
DROP FUNCTION get_dept_total;
DROP PROCEDURE get_employee_count;
DROP PROCEDURE update_salary;
DROP TRIGGER before_emp_insert;
DROP TRIGGER after_salary_update;
