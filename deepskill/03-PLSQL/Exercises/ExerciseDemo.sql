SET SERVEROUTPUT ON;

-- ============================================================
-- PL/SQL Exercise Demo
-- This script runs ALL 13 exercises sequentially.
-- Each section has a comment indicating the exercise number.
-- ============================================================

-- ============================================================
-- Exercise 01 - Basic Block
-- ============================================================
PROMPT '>>> Running Exercise 01 - Basic Block';
DECLARE
  v_name VARCHAR2(30);
BEGIN
  v_name := 'John Doe';
  DBMS_OUTPUT.PUT_LINE('Hello, ' || v_name || '!');
END;
/

-- ============================================================
-- Exercise 02 - Variables
-- ============================================================
PROMPT '>>> Running Exercise 02 - Variables';
DECLARE
  v_num     NUMBER := 100;
  v_text    VARCHAR2(50) := 'PL/SQL is fun';
  v_today   DATE := SYSDATE;
  v_flag    BOOLEAN := TRUE;
  v_empname emp.ename%TYPE;
BEGIN
  DBMS_OUTPUT.PUT_LINE('Number: ' || v_num);
  DBMS_OUTPUT.PUT_LINE('Text: ' || v_text);
  DBMS_OUTPUT.PUT_LINE('Date: ' || v_today);
  DBMS_OUTPUT.PUT_LINE('Boolean: ' || CASE WHEN v_flag THEN 'TRUE' ELSE 'FALSE' END);
  SELECT ename INTO v_empname FROM emp WHERE empno = 7369;
  DBMS_OUTPUT.PUT_LINE('Employee name from emp: ' || v_empname);
END;
/

-- ============================================================
-- Exercise 03 - Control IF
-- ============================================================
PROMPT '>>> Running Exercise 03 - Control IF';
DECLARE
  v_score NUMBER := 85;
  v_grade CHAR(1);
BEGIN
  IF v_score >= 90 THEN
    v_grade := 'A';
  ELSIF v_score >= 80 THEN
    v_grade := 'B';
  ELSIF v_score >= 70 THEN
    v_grade := 'C';
  ELSIF v_score >= 60 THEN
    v_grade := 'D';
  ELSE
    v_grade := 'F';
  END IF;
  DBMS_OUTPUT.PUT_LINE('Score: ' || v_score || ' Grade: ' || v_grade);
END;
/

-- ============================================================
-- Exercise 04 - Control CASE
-- ============================================================
PROMPT '>>> Running Exercise 04 - Control CASE';
DECLARE
  v_day_num NUMBER := 3;
  v_day_name VARCHAR2(10);
BEGIN
  v_day_name := CASE v_day_num
                  WHEN 1 THEN 'Monday'
                  WHEN 2 THEN 'Tuesday'
                  WHEN 3 THEN 'Wednesday'
                  WHEN 4 THEN 'Thursday'
                  WHEN 5 THEN 'Friday'
                  WHEN 6 THEN 'Saturday'
                  WHEN 7 THEN 'Sunday'
                  ELSE 'Invalid day'
                END;
  DBMS_OUTPUT.PUT_LINE('Day number ' || v_day_num || ' is ' || v_day_name);
END;
/

-- ============================================================
-- Exercise 05 - Loops Basic
-- ============================================================
PROMPT '>>> Running Exercise 05 - Loops Basic';
DECLARE
  v_counter NUMBER := 1;
BEGIN
  LOOP
    DBMS_OUTPUT.PUT_LINE('Number: ' || v_counter);
    v_counter := v_counter + 1;
    EXIT WHEN v_counter > 10;
  END LOOP;
END;
/

-- ============================================================
-- Exercise 06 - Loops For
-- ============================================================
PROMPT '>>> Running Exercise 06 - Loops For';
DECLARE
  v_num     NUMBER := 5;
  v_fact    NUMBER := 1;
BEGIN
  FOR i IN 1..v_num LOOP
    v_fact := v_fact * i;
  END LOOP;
  DBMS_OUTPUT.PUT_LINE(v_num || '! = ' || v_fact);
END;
/

-- ============================================================
-- Exercise 07 - Loops While
-- ============================================================
PROMPT '>>> Running Exercise 07 - Loops While';
DECLARE
  v_num NUMBER := 2;
BEGIN
  WHILE v_num <= 20 LOOP
    DBMS_OUTPUT.PUT_LINE('Even number: ' || v_num);
    v_num := v_num + 2;
  END LOOP;
END;
/

-- ============================================================
-- Exercise 08 - Exceptions
-- ============================================================
PROMPT '>>> Running Exercise 08 - Exceptions';
DECLARE
  v_dividend NUMBER := 10;
  v_divisor  NUMBER := 0;
  v_result   NUMBER;
  e_negative_input EXCEPTION;
  PRAGMA EXCEPTION_INIT(e_negative_input, -20001);
BEGIN
  IF v_dividend < 0 OR v_divisor < 0 THEN
    RAISE e_negative_input;
  END IF;
  v_result := v_dividend / v_divisor;
  DBMS_OUTPUT.PUT_LINE('Result: ' || v_result);
EXCEPTION
  WHEN ZERO_DIVIDE THEN
    DBMS_OUTPUT.PUT_LINE('Error: Cannot divide by zero!');
  WHEN e_negative_input THEN
    DBMS_OUTPUT.PUT_LINE('Error: Negative input is not allowed!');
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Unexpected error: ' || SQLERRM);
END;
/

-- ============================================================
-- Exercise 09 - Cursors
-- ============================================================
PROMPT '>>> Running Exercise 09 - Cursors';
DECLARE
  CURSOR c_emp IS
    SELECT * FROM emp;
  CURSOR c_emp_dept(p_deptno NUMBER) IS
    SELECT empno, ename, job FROM emp WHERE deptno = p_deptno;
  v_emp_rec emp%ROWTYPE;
  v_emp_dept_rec c_emp_dept%ROWTYPE;
BEGIN
  DBMS_OUTPUT.PUT_LINE('--- All Employees ---');
  OPEN c_emp;
  LOOP
    FETCH c_emp INTO v_emp_rec;
    EXIT WHEN c_emp%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(v_emp_rec.empno || ' - ' || v_emp_rec.ename || ' - ' || v_emp_rec.job);
  END LOOP;
  CLOSE c_emp;
  DBMS_OUTPUT.PUT_LINE('--- Employees in Dept 10 ---');
  OPEN c_emp_dept(10);
  LOOP
    FETCH c_emp_dept INTO v_emp_dept_rec;
    EXIT WHEN c_emp_dept%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(v_emp_dept_rec.empno || ' - ' || v_emp_dept_rec.ename || ' - ' || v_emp_dept_rec.job);
  END LOOP;
  CLOSE c_emp_dept;
END;
/

-- ============================================================
-- Exercise 10 - Procedures
-- ============================================================
PROMPT '>>> Running Exercise 10 - Procedures';
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

-- ============================================================
-- Exercise 11 - Functions
-- ============================================================
PROMPT '>>> Running Exercise 11 - Functions';
CREATE OR REPLACE FUNCTION calculate_bonus(
  p_salary   NUMBER,
  p_percent  NUMBER
) RETURN NUMBER IS
  v_bonus NUMBER;
BEGIN
  v_bonus := p_salary * (p_percent / 100);
  RETURN v_bonus;
END;
/
DECLARE
  v_sal   NUMBER := 5000;
  v_pct   NUMBER := 10;
  v_bonus NUMBER;
BEGIN
  v_bonus := calculate_bonus(v_sal, v_pct);
  DBMS_OUTPUT.PUT_LINE('Salary: ' || v_sal);
  DBMS_OUTPUT.PUT_LINE('Bonus Percent: ' || v_pct || '%');
  DBMS_OUTPUT.PUT_LINE('Calculated Bonus: ' || v_bonus);
END;
/

-- ============================================================
-- Exercise 12 - Packages
-- ============================================================
PROMPT '>>> Running Exercise 12 - Packages';
CREATE OR REPLACE PACKAGE emp_pkg IS
  PROCEDURE get_employee(p_emp_id NUMBER);
  FUNCTION calculate_bonus(p_salary NUMBER, p_percent NUMBER) RETURN NUMBER;
END emp_pkg;
/
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
BEGIN
  emp_pkg.get_employee(7369);
  DBMS_OUTPUT.PUT_LINE('Bonus: ' || emp_pkg.calculate_bonus(5000, 15));
END;
/

-- ============================================================
-- Exercise 13 - Triggers
-- ============================================================
PROMPT '>>> Running Exercise 13 - Triggers';
CREATE SEQUENCE emp_seq START WITH 1000 INCREMENT BY 1;
ALTER TABLE employees ADD (created_date DATE);
CREATE OR REPLACE TRIGGER trg_before_insert_emp
  BEFORE INSERT ON employees
  FOR EACH ROW
BEGIN
  IF :NEW.empno IS NULL THEN
    :NEW.empno := emp_seq.NEXTVAL;
  END IF;
  :NEW.created_date := SYSDATE;
  DBMS_OUTPUT.PUT_LINE('Trigger fired: Inserting employee ' || :NEW.ename);
END;
/
BEGIN
  INSERT INTO employees (ename, job, sal, deptno)
  VALUES ('TestUser', 'CLERK', 3000, 10);
  COMMIT;
  DBMS_OUTPUT.PUT_LINE('Insert successful.');
END;
/

PROMPT '>>> All 13 exercises completed!';
