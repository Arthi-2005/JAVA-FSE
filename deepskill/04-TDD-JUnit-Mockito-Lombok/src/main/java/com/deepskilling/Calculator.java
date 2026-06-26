package com.deepskilling;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Calculator {

    public int add(int a, int b) {
        log.debug("Adding {} + {}", a, b);
        return a + b;
    }

    public int subtract(int a, int b) {
        log.debug("Subtracting {} - {}", a, b);
        return a - b;
    }

    public int multiply(int a, int b) {
        log.debug("Multiplying {} * {}", a, b);
        return a * b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            log.error("Division by zero attempted");
            throw new ArithmeticException("Cannot divide by zero");
        }
        log.debug("Dividing {} / {}", a, b);
        return a / b;
    }

    public boolean isEven(int number) {
        return number % 2 == 0;
    }
}
