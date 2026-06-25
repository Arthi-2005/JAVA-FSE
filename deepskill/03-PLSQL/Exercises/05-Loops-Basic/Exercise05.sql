SET SERVEROUTPUT ON;

/*
  Problem: Write a PL/SQL block using a basic LOOP to print
  numbers 1 to 10 with EXIT WHEN condition.
*/

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
