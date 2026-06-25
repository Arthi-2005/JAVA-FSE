SET SERVEROUTPUT ON;

/*
  Problem: Create a FUNCTION calculate_bonus(p_salary NUMBER, p_percent NUMBER)
  RETURN NUMBER that returns bonus amount. Call it from a PL/SQL block.
*/

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
