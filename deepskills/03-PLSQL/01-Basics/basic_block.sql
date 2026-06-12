SET SERVEROUTPUT ON;

DECLARE
    v_name VARCHAR2(50) := 'John Doe';
    v_age NUMBER := 25;
BEGIN
    DBMS_OUTPUT.PUT_LINE('Hello, ' || v_name || '!');
    DBMS_OUTPUT.PUT_LINE('You are ' || v_age || ' years old.');
END;
/
