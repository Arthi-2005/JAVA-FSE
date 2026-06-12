SET SERVEROUTPUT ON;

-- System exception
DECLARE
    v_result NUMBER;
    v_dividend NUMBER := 10;
    v_divisor NUMBER := 0;
BEGIN
    v_result := v_dividend / v_divisor;
    DBMS_OUTPUT.PUT_LINE('Result: ' || v_result);
EXCEPTION
    WHEN ZERO_DIVIDE THEN
        DBMS_OUTPUT.PUT_LINE('Error: Cannot divide by zero!');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/

-- User-defined exception
DECLARE
    e_salary_too_low EXCEPTION;
    v_salary NUMBER := 1000;
BEGIN
    IF v_salary < 5000 THEN
        RAISE e_salary_too_low;
    END IF;
EXCEPTION
    WHEN e_salary_too_low THEN
        DBMS_OUTPUT.PUT_LINE('Error: Salary ' || v_salary || ' is below minimum!');
END;
/
