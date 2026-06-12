package OCP;

public class UpiPayment extends PaymentMethod {
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " via UPI");
    }
}
