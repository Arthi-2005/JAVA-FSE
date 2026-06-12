package OCP;

public class CreditCardPayment extends PaymentMethod {
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " via Credit Card");
    }
}
