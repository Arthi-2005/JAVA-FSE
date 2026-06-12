package Behavioral.Observer;

import java.util.ArrayList;
import java.util.List;

public class NewsChannel {
    private List<Observer> observers = new ArrayList<>();

    public void subscribe(Observer o) { observers.add(o); }
    public void unsubscribe(Observer o) { observers.remove(o); }

    public void publishNews(String news) {
        for (Observer o : observers) {
            o.update(news);
        }
    }
}
