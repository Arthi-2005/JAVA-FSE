package OCP;

public class OCPDemo {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();
        processor.processPayment(new CreditCardPayment(), 500);
        processor.processPayment(new UpiPayment(), 300);
    }
}
