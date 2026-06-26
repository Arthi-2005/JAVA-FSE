package com.deepskilling;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Calculator Tests - TDD Approach")
class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Adding two positive numbers")
    void testAdd() {
        assertEquals(5, calculator.add(2, 3));
        assertEquals(10, calculator.add(7, 3));
        assertEquals(0, calculator.add(-1, 1));
    }

    @Test
    @DisplayName("Subtracting two numbers")
    void testSubtract() {
        assertEquals(3, calculator.subtract(5, 2));
        assertEquals(-1, calculator.subtract(2, 3));
        assertEquals(0, calculator.subtract(5, 5));
    }

    @Test
    @DisplayName("Multiplying two numbers")
    void testMultiply() {
        assertEquals(6, calculator.multiply(2, 3));
        assertEquals(0, calculator.multiply(0, 5));
        assertEquals(-6, calculator.multiply(-2, 3));
    }

    @Test
    @DisplayName("Dividing two numbers")
    void testDivide() {
        assertEquals(2, calculator.divide(6, 3));
        assertEquals(3, calculator.divide(9, 3));
    }

    @Test
    @DisplayName("Division by zero should throw exception")
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(5, 0));
    }

    @Test
    @DisplayName("Check if number is even")
    void testIsEven() {
        assertTrue(calculator.isEven(2));
        assertTrue(calculator.isEven(0));
        assertFalse(calculator.isEven(3));
        assertFalse(calculator.isEven(-1));
    }

    @Test
    @DisplayName("Parameterized-like test for multiple cases")
    void testMultipleAdditions() {
        assertAll(
            () -> assertEquals(4, calculator.add(2, 2)),
            () -> assertEquals(0, calculator.add(-1, 1)),
            () -> assertEquals(100, calculator.add(50, 50))
        );
    }
}
