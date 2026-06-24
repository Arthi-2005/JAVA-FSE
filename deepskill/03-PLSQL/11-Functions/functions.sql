SET SERVEROUTPUT ON;

CREATE OR REPLACE FUNCTION calculate_bonus(
    p_salary IN NUMBER,
    p_percent IN NUMBER
) RETURN NUMBER IS
    v_bonus NUMBER;
BEGIN
    v_bonus := p_salary * (p_percent / 100);
    RETURN v_bonus;
END calculate_bonus;
/

DECLARE
    v_bonus NUMBER;
BEGIN
    v_bonus := calculate_bonus(50000, 10);
    DBMS_OUTPUT.PUT_LINE('Bonus: $' || v_bonus);
END;
/

CREATE OR REPLACE FUNCTION get_dept_total RETURN NUMBER IS
    v_total NUMBER;
BEGIN
    SELECT SUM(salary) INTO v_total FROM employees;
    RETURN v_total;
END get_dept_total;
/

BEGIN
    DBMS_OUTPUT.PUT_LINE('Total salary expenditure: $' || get_dept_total);
END;
/
