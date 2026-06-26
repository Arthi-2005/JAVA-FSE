/*
 * PROBLEM: Demonstrate Aspect-Oriented Programming (AOP) — separating cross-cutting
 * concerns (logging) from business logic. Spring AOP uses proxies to intercept method calls.
 * Here we simulate by calling the aspect manually around business methods.
 */
package com.deepskilling.exercises.aop;

public class CalculatorService {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a / b;
    }
}
