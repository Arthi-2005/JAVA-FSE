SET SERVEROUTPUT ON;

/*
  Problem: Write a PL/SQL block using an explicit CURSOR to fetch
  and display all employees from emp table (use %ROWTYPE).
  Also demonstrate a parameterized cursor.
*/

DECLARE
  -- Simple cursor to fetch all employees
  CURSOR c_emp IS
    SELECT * FROM emp;

  -- Parameterized cursor to fetch employees by department
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

  DBMS_OUTPUT.PUT_LINE('');
  DBMS_OUTPUT.PUT_LINE('--- Employees in Dept 10 (Parameterized Cursor) ---');
  OPEN c_emp_dept(10);
  LOOP
    FETCH c_emp_dept INTO v_emp_dept_rec;
    EXIT WHEN c_emp_dept%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(v_emp_dept_rec.empno || ' - ' || v_emp_dept_rec.ename || ' - ' || v_emp_dept_rec.job);
  END LOOP;
  CLOSE c_emp_dept;
END;
/
