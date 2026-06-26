package com.deepskilling.exercises.aop;

import java.util.function.Supplier;

/*
 * Simulates Spring AOP aspects with before(), after(), and around() advice.
 * In Spring these would be interceptors applied via proxy; here they are
 * explicit utility methods the demo calls manually to show the separation.
 */
public class LoggingAspect {

    public static void before(String methodName) {
        System.out.println("  [Before] Calling: " + methodName);
    }

    public static void after(String methodName) {
        System.out.println("  [After] Completed: " + methodName);
    }

    public static <T> T around(String methodName, Supplier<T> businessLogic) {
        System.out.println("  [Around] Wrapping: " + methodName);
        System.out.println("  [Around] Before proceeding...");
        T result = businessLogic.get();
        System.out.println("  [Around] After proceeding... result = " + result);
        return result;
    }
}
