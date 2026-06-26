package com.deepskilling.exercises.di;

public class CreditCardPayment implements PaymentService {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment: $" + amount);
    }
}
