SET SERVEROUTPUT ON;

/*
  Problem: Write a PL/SQL block that takes a number (1-100)
  and prints the grade: >=90 A, >=80 B, >=70 C, >=60 D, else F.
*/

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
