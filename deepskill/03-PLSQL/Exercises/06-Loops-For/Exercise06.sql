SET SERVEROUTPUT ON;

/*
  Problem: Write a PL/SQL block using FOR loop to calculate
  factorial of a number (e.g., 5! = 120).
*/

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
