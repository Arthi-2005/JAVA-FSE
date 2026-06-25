SET SERVEROUTPUT ON;

/*
  Problem: Declare variables of types NUMBER, VARCHAR2, DATE, BOOLEAN.
  Assign values and print them. Demonstrate %TYPE attribute by declaring
  a variable based on emp.ename%TYPE.
*/

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

  -- %TYPE example: v_empname inherits type from emp.ename
  SELECT ename INTO v_empname FROM emp WHERE empno = 7369;
  DBMS_OUTPUT.PUT_LINE('Employee name from emp: ' || v_empname);
END;
/
