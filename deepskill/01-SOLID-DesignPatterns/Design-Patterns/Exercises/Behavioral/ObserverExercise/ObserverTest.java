package Exercises.Behavioral.ObserverExercise;

public class ObserverTest {
    public static void main(String[] args) {
        StockMarket market = new StockMarket();

        Observer mobile = new MobileApp("Alice");
        Observer web = new WebApp("Bob");

        market.registerObserver(mobile);
        market.registerObserver(web);

        market.setPrice(150.00);
        market.setPrice(155.50);
    }
}
