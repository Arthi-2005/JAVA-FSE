package Behavioral.Observer;

public class ObserverDemo {
    public static void main(String[] args) {
        NewsChannel channel = new NewsChannel();
        User alice = new User("Alice");
        User bob = new User("Bob");
        channel.subscribe(alice);
        channel.subscribe(bob);
        channel.publishNews("Java 21 Released!");
    }
}
