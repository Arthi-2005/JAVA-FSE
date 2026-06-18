package Behavioral.Strategy;

public class PayPalStrategy implements PaymentStrategy {
    private String email;
    public PayPalStrategy(String email) { this.email = email; }
    public void pay(int amount) {
        System.out.println("Paid $" + amount + " via PayPal (" + email + ")");
    }
}
