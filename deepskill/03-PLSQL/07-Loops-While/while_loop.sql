SET SERVEROUTPUT ON;

DECLARE
    v_num NUMBER := 1;
BEGIN
    WHILE v_num <= 5 LOOP
        DBMS_OUTPUT.PUT_LINE('Number: ' || v_num);
        v_num := v_num + 1;
    END LOOP;
END;
/
