package Behavioral.Strategy;

public class StrategyDemo {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Book");
        cart.addItem("Pen");
        cart.checkout(new CreditCardStrategy("1234567890123456"));
        cart.checkout(new PayPalStrategy("user@example.com"));
    }
}
