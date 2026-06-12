SET SERVEROUTPUT ON;

DECLARE
    v_score NUMBER := 85;
    v_grade VARCHAR2(2);
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
    DBMS_OUTPUT.PUT_LINE('Score: ' || v_score || ', Grade: ' || v_grade);
END;
/
