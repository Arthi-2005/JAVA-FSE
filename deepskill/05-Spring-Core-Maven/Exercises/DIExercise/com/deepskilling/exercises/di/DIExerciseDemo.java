package com.deepskilling.exercises.di;

/*
 * Demo: Creates OrderProcessor with different injected PaymentService implementations.
 * OrderProcessor code never changes — we just swap what's injected.
 */
public class DIExerciseDemo {
    public static void main(String[] args) {
        System.out.println("=== Dependency Injection (DI) Demonstration ===\n");

        PaymentService creditCard = new CreditCardPayment();
        PaymentService payPal = new PayPalPayment();

        // --- Constructor injection ---
        System.out.println("1. Constructor Injection:");
        OrderProcessor processor1 = new OrderProcessor(creditCard);
        processor1.processWithConstructor(100.00);

        processor1 = new OrderProcessor(payPal);
        processor1.processWithConstructor(200.00);

        // --- Setter injection ---
        System.out.println("\n2. Setter Injection:");
        OrderProcessor processor2 = new OrderProcessor(creditCard); // dummy ctor arg
        processor2.setPaymentService(creditCard);
        processor2.processWithSetter(150.00);

        processor2.setPaymentService(payPal);
        processor2.processWithSetter(250.00);

        // --- Field injection ---
        System.out.println("\n3. Field Injection:");
        OrderProcessor processor3 = new OrderProcessor(creditCard);
        processor3.injectField(creditCard);
        processor3.processWithField(300.00);

        processor3.injectField(payPal);
        processor3.processWithField(400.00);

        System.out.println("\nSame OrderProcessor class — different behavior based on injected dependency.");
        System.out.println("OrderProcessor never changed; only the injected PaymentService swapped.");
    }
}
