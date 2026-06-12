SET SERVEROUTPUT ON;

DECLARE
    v_day NUMBER := 3;
    v_day_name VARCHAR2(20);
BEGIN
    v_day_name := CASE v_day
        WHEN 1 THEN 'Monday'
        WHEN 2 THEN 'Tuesday'
        WHEN 3 THEN 'Wednesday'
        WHEN 4 THEN 'Thursday'
        WHEN 5 THEN 'Friday'
        WHEN 6 THEN 'Saturday'
        WHEN 7 THEN 'Sunday'
        ELSE 'Invalid'
    END;
    DBMS_OUTPUT.PUT_LINE('Day ' || v_day || ' is ' || v_day_name);
END;
/
