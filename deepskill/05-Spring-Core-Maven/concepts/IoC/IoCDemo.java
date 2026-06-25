// IoC = Inversion of Control
// Instead of creating objects yourself, Spring creates & manages them (IoC Container)
// You just ask for what you need

// Without IoC (Traditional way):
class MyAppWithoutIoC {
    EmailService email = new EmailService();  // You create it
}

// With IoC (Spring way):
// @Component tells Spring: "Hey, manage this object for me!"
// Spring creates it, you just use it

// @Component would go here with Spring
class EmailService {
    public void sendEmail(String msg) {
        System.out.println("Email sent: " + msg);
    }
}

// @Component with Spring
class MyApp {
    // No 'new' keyword needed - Spring injects it!
    EmailService email;  // Spring gives us the object

    public MyApp(EmailService email) {
        this.email = email;
    }

    void run() {
        email.sendEmail("Hello via IoC!");
    }
}

// Key point: CONTROL is INVERTED
// Before: You control object creation (new keyword)
// After: Spring controls object creation (IoC Container)
public class IoCDemo {
    public static void main(String[] args) {
        System.out.println("=== IoC (Inversion of Control) ===");
        System.out.println("Before IoC: You write 'new' to create objects");
        System.out.println("After IoC:  Spring creates & manages objects");
        System.out.println("            You just ask @Autowired / constructor");
        System.out.println();
        System.out.println("Container = Spring's ApplicationContext");
        System.out.println("It holds all @Component, @Service, @Repository beans");
    }
}
