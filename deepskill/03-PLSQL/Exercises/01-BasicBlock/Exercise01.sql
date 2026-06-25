SET SERVEROUTPUT ON;

/*
  Problem: Write a PL/SQL block that declares a variable
  v_name VARCHAR2(30) and assigns your name.
  Print "Hello, [name]!" using DBMS_OUTPUT.
*/

DECLARE
  v_name VARCHAR2(30);
BEGIN
  v_name := 'John Doe';
  DBMS_OUTPUT.PUT_LINE('Hello, ' || v_name || '!');
END;
/
