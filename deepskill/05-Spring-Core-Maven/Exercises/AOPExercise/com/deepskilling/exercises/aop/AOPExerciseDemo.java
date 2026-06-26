package com.deepskilling.exercises.aop;

/*
 * Demo: Simulates AOP by placing aspect calls around calculator operations.
 * Cross-cutting logging concern stays in LoggingAspect; business logic
 * (CalculatorService) is completely unaware of it.
 */
public class AOPExerciseDemo {
    public static void main(String[] args) {
        System.out.println("=== Aspect-Oriented Programming (AOP) Demonstration ===\n");

        CalculatorService calc = new CalculatorService();

        System.out.println("1. Before / After advice on add():");
        LoggingAspect.before("add(10, 5)");
        int sum = calc.add(10, 5);
        LoggingAspect.after("add(10, 5)");
        System.out.println("   Result: " + sum);

        System.out.println("\n2. Around advice on subtract():");
        int diff = LoggingAspect.around("subtract(20, 7)", () -> calc.subtract(20, 7));
        System.out.println("   Result: " + diff);

        System.out.println("\n3. Mixed advice on multiply():");
        LoggingAspect.before("multiply(6, 7)");
        int product = LoggingAspect.around("multiply(6, 7)", () -> calc.multiply(6, 7));
        LoggingAspect.after("multiply(6, 7)");
        System.out.println("   Result: " + product);

        System.out.println("\n4. Divide with exception handling aspect:");
        LoggingAspect.before("divide(15, 3)");
        int quotient = calc.divide(15, 3);
        LoggingAspect.after("divide(15, 3)");
        System.out.println("   Result: " + quotient);

        System.out.println("\nCalculatorService has zero logging code — concern is fully separated.");
    }
}
