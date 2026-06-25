SET SERVEROUTPUT ON;

/*
  Problem: Create a BEFORE INSERT trigger on employees that
  auto-generates employee ID and sets the created_date.
*/

-- Create a sequence for auto-generating employee IDs
CREATE SEQUENCE emp_seq START WITH 1000 INCREMENT BY 1;

-- Add a created_date column to employees (if not already present)
ALTER TABLE employees ADD (created_date DATE);

-- Create the trigger
CREATE OR REPLACE TRIGGER trg_before_insert_emp
  BEFORE INSERT ON employees
  FOR EACH ROW
BEGIN
  -- Auto-generate employee ID if not provided
  IF :NEW.empno IS NULL THEN
    :NEW.empno := emp_seq.NEXTVAL;
  END IF;

  -- Set the created_date to current date and time
  :NEW.created_date := SYSDATE;

  DBMS_OUTPUT.PUT_LINE('Trigger fired: Inserting employee ' || :NEW.ename);
END;
/
-- Test the trigger
BEGIN
  INSERT INTO employees (ename, job, sal, deptno)
  VALUES ('TestUser', 'CLERK', 3000, 10);
  COMMIT;
  DBMS_OUTPUT.PUT_LINE('Insert successful. Check for auto-generated ID and created_date.');
END;
/
