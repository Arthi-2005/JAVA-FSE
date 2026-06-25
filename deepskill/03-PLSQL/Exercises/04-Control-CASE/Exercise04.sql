SET SERVEROUTPUT ON;

/*
  Problem: Write a PL/SQL block using CASE expression to take
  a day number (1-7) and print the day name (Monday-Sunday).
*/

DECLARE
  v_day_num NUMBER := 3;
  v_day_name VARCHAR2(10);
BEGIN
  v_day_name := CASE v_day_num
                  WHEN 1 THEN 'Monday'
                  WHEN 2 THEN 'Tuesday'
                  WHEN 3 THEN 'Wednesday'
                  WHEN 4 THEN 'Thursday'
                  WHEN 5 THEN 'Friday'
                  WHEN 6 THEN 'Saturday'
                  WHEN 7 THEN 'Sunday'
                  ELSE 'Invalid day'
                END;

  DBMS_OUTPUT.PUT_LINE('Day number ' || v_day_num || ' is ' || v_day_name);
END;
/
