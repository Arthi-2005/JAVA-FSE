package com.deepskilling.exercises.di;

public class PayPalPayment implements PaymentService {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment: $" + amount);
    }
}
