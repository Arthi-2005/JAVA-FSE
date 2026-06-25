// DI = Dependency Injection
// Object's dependencies are GIVEN to it (injected), not created by it

// Problem: Tight coupling
class Engine {
    void start() { System.out.println("Engine started"); }
}

// Car CREATES its own engine - BAD!
class CarTightlyCoupled {
    private Engine engine = new Engine();  // Car depends on Engine directly
}

// Solution: Inject the dependency
// Car RECEIVES engine from outside - GOOD!
class Car {
    private Engine engine;

    // Constructor Injection - dependency passed from outside
    public Car(Engine engine) {
        this.engine = engine;
    }

    void start() {
        engine.start();
    }
}

// Three types of DI in Spring:
// 1. Constructor Injection (BEST - recommended)
// 2. Setter Injection
// 3. Field Injection (@Autowired on field)

// @Component + @Autowired with Spring
class CarWithSpringDI {
    private Engine engine;

    // @Autowired would go here with Spring
    public CarWithSpringDI(Engine engine) {
        this.engine = engine;
    }

    public void drive() {
        engine.start();
        System.out.println("Car is moving!");
    }
}

public class DIDemo {
    public static void main(String[] args) {
        System.out.println("=== Dependency Injection ===");
        System.out.println();
        System.out.println("Without DI:");
        System.out.println("  Car creates its own Engine - can't swap");
        System.out.println();
        System.out.println("With DI:");
        System.out.println("  Car receives Engine from outside");
        System.out.println("  Easy to swap Engine types");
        System.out.println("  Easy to test with mock Engine");
        System.out.println();
        System.out.println("@Autowired = Tell Spring to inject here");
    }
}
