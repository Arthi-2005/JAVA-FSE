package com.deepskilling.exercises.calc;

import lombok.extern.slf4j.Slf4j;

/**
 * PROBLEM STATEMENT:
 * Implement a simple calculator with basic arithmetic operations.
 * Use TDD approach — write tests first, then implement methods.
 * Use Lombok @Slf4j for logging method invocations.
 *
 * Methods to implement:
 * - add(int a, int b) -> returns sum
 * - subtract(int a, int b) -> returns difference
 * - multiply(int a, int b) -> returns product
 * - divide(int a, int b) -> returns quotient; throws ArithmeticException if b == 0
 * - isEven(int a) -> returns true if a is even
 */
@Slf4j
public class CalculatorExercise {

    public int add(int a, int b) {
        log.info("add({}, {})", a, b);
        return a + b;
    }

    public int subtract(int a, int b) {
        log.info("subtract({}, {})", a, b);
        return a - b;
    }

    public int multiply(int a, int b) {
        log.info("multiply({}, {})", a, b);
        return a * b;
    }

    public int divide(int a, int b) {
        log.info("divide({}, {})", a, b);
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }

    public boolean isEven(int a) {
        log.info("isEven({})", a);
        return a % 2 == 0;
    }
}
