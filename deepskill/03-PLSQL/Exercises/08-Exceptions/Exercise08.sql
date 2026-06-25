SET SERVEROUTPUT ON;

/*
  Problem: Write a PL/SQL block that divides two numbers and
  handles ZERO_DIVIDE exception. Also add a user-defined
  exception for negative input.
*/

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
