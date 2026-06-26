/*
 * PROBLEM: Demonstrate Dependency Injection (DI) — injecting dependencies rather than
 * having the class create them. Shows three injection styles: constructor, setter, and field.
 * Spring uses these patterns to wire beans together, making code testable and loosely coupled.
 */
package com.deepskilling.exercises.di;

public interface PaymentService {
    void processPayment(double amount);
}
