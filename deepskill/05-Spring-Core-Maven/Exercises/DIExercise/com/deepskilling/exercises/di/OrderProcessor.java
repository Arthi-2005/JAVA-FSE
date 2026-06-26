package com.deepskilling.exercises.di;

/*
 * OrderProcessor depends on PaymentService.
 * Demonstrates three DI styles used in Spring:
 *   a) Constructor injection
 *   b) Setter injection
 *   c) Field injection (direct assignment)
 */
public class OrderProcessor {

    // Field injection — dependency set directly on the field
    private PaymentService fieldPaymentService;

    // Constructor injection — dependency provided via constructor
    private final PaymentService constructorPaymentService;

    // Setter injection — dependency provided via setter
    private PaymentService setterPaymentService;

    // Constructor injection
    public OrderProcessor(PaymentService paymentService) {
        this.constructorPaymentService = paymentService;
    }

    // Setter injection
    public void setPaymentService(PaymentService paymentService) {
        this.setterPaymentService = paymentService;
    }

    // Field injection (simulates @Autowired on a field)
    public void injectField(PaymentService paymentService) {
        this.fieldPaymentService = paymentService;
    }

    public void processWithConstructor(double amount) {
        System.out.print("  [Constructor Injection] ");
        constructorPaymentService.processPayment(amount);
    }

    public void processWithSetter(double amount) {
        System.out.print("  [Setter Injection] ");
        setterPaymentService.processPayment(amount);
    }

    public void processWithField(double amount) {
        System.out.print("  [Field Injection] ");
        fieldPaymentService.processPayment(amount);
    }
}
