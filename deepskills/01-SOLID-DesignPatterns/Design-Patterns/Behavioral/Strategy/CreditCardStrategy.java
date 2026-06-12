package Behavioral.Strategy;

public class CreditCardStrategy implements PaymentStrategy {
    private String cardNumber;
    public CreditCardStrategy(String cardNumber) { this.cardNumber = cardNumber; }
    public void pay(int amount) {
        System.out.println("Paid $" + amount + " with Credit Card ending " + cardNumber.substring(cardNumber.length() - 4));
    }
}
