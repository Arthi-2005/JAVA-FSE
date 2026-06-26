package com.deepskilling.exercises.mockito;

/**
 * PROBLEM STATEMENT:
 * Define the PaymentGateway interface that OrderService depends on.
 * In a real-world scenario this would connect to Stripe, PayPal, etc.
 * Methods: processPayment(orderId, amount) -> boolean, refund(orderId) -> boolean
 */
public interface PaymentGateway {

    boolean processPayment(String orderId, double amount);

    boolean refund(String orderId);
}
