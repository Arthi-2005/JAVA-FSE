package Behavioral.Strategy;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<String> items = new ArrayList<>();

    public void addItem(String item) { items.add(item); }

    public void checkout(PaymentStrategy strategy) {
        int total = items.size() * 10;
        strategy.pay(total);
    }
}
