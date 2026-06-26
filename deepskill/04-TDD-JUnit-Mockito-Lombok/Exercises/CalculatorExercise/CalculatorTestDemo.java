package com.deepskilling.exercises.calc;

/**
 * PROBLEM STATEMENT:
 * Simulate JUnit test output for the CalculatorExercise class.
 * In a real JUnit environment, each method annotated with @Test would
 * use assertEquals, assertTrue, assertThrows etc.
 * Here we manually run assertions and print PASS/FAIL for each test case.
 */
public class CalculatorTestDemo {

    private static int passed = 0;
    private static int failed = 0;

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("  CalculatorExercise — Test Simulation");
        System.out.println("========================================\n");

        CalculatorExercise calc = new CalculatorExercise();

        // --- testAdd ---
        System.out.println("▶ testAdd");
        assertEqual("add(2, 3)", 5, calc.add(2, 3));
        assertEqual("add(-1, 1)", 0, calc.add(-1, 1));
        assertEqual("add(0, 0)", 0, calc.add(0, 0));

        // --- testSubtract ---
        System.out.println("▶ testSubtract");
        assertEqual("subtract(10, 3)", 7, calc.subtract(10, 3));
        assertEqual("subtract(5, 10)", -5, calc.subtract(5, 10));
        assertEqual("subtract(0, 0)", 0, calc.subtract(0, 0));

        // --- testMultiply ---
        System.out.println("▶ testMultiply");
        assertEqual("multiply(4, 5)", 20, calc.multiply(4, 5));
        assertEqual("multiply(-3, 6)", -18, calc.multiply(-3, 6));
        assertEqual("multiply(0, 99)", 0, calc.multiply(0, 99));

        // --- testDivide ---
        System.out.println("▶ testDivide");
        assertEqual("divide(10, 2)", 5, calc.divide(10, 2));
        assertEqual("divide(7, 3)", 2, calc.divide(7, 3));
        assertEqual("divide(-8, 4)", -2, calc.divide(-8, 4));

        // --- testDivideByZero ---
        System.out.println("▶ testDivideByZero");
        assertThrows("divide(5, 0)", ArithmeticException.class, () -> calc.divide(5, 0));
        assertThrows("divide(-1, 0)", ArithmeticException.class, () -> calc.divide(-1, 0));

        // --- testIsEven ---
        System.out.println("▶ testIsEven");
        assertTrue("isEven(4)", calc.isEven(4));
        assertFalse("isEven(7)", calc.isEven(7));
        assertTrue("isEven(0)", calc.isEven(0));
        assertTrue("isEven(-2)", calc.isEven(-2));

        System.out.println("\n========================================");
        System.out.printf("  RESULTS: %d passed, %d failed%n", passed, failed);
        System.out.println("========================================");
    }

    // --- Helper assertion methods ---

    private static void assertEqual(String label, int expected, int actual) {
        if (expected == actual) {
            System.out.printf("  ✓ %s = %d%n", label, actual);
            passed++;
        } else {
            System.out.printf("  ✗ %s — expected %d but got %d%n", label, expected, actual);
            failed++;
        }
    }

    private static void assertTrue(String label, boolean condition) {
        if (condition) {
            System.out.printf("  ✓ %s = true%n", label);
            passed++;
        } else {
            System.out.printf("  ✗ %s — expected true but got false%n", label);
            failed++;
        }
    }

    private static void assertFalse(String label, boolean condition) {
        if (!condition) {
            System.out.printf("  ✓ %s = false%n", label);
            passed++;
        } else {
            System.out.printf("  ✗ %s — expected false but got true%n", label);
            failed++;
        }
    }

    private static void assertThrows(String label, Class<?> exceptionClass, Runnable runnable) {
        try {
            runnable.run();
            System.out.printf("  ✗ %s — expected %s but no exception was thrown%n",
                    label, exceptionClass.getSimpleName());
            failed++;
        } catch (Exception e) {
            if (exceptionClass.isInstance(e)) {
                System.out.printf("  ✓ %s threw %s%n", label, e.getClass().getSimpleName());
                passed++;
            } else {
                System.out.printf("  ✗ %s — expected %s but got %s: %s%n",
                        label, exceptionClass.getSimpleName(), e.getClass().getSimpleName(), e.getMessage());
                failed++;
            }
        }
    }
}
