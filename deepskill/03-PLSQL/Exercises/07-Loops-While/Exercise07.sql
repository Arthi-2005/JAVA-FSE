SET SERVEROUTPUT ON;

/*
  Problem: Write a PL/SQL block using WHILE loop to print
  even numbers from 2 to 20.
*/

DECLARE
  v_num NUMBER := 2;
BEGIN
  WHILE v_num <= 20 LOOP
    DBMS_OUTPUT.PUT_LINE('Even number: ' || v_num);
    v_num := v_num + 2;
  END LOOP;
END;
/
