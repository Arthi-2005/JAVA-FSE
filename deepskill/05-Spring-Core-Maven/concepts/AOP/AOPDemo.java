// AOP = Aspect Oriented Programming
// Cross-cutting concerns: Logging, Security, Transactions
// Without AOP: Code is scattered everywhere (repeated in every method)
// With AOP: Code is in ONE place (Aspect), applied automatically

// Example: Logging before every method
// Without AOP:
class UserServiceWithoutAOP {
    void saveUser() {
        System.out.println("[LOG] saveUser() started");  // Repeated!
        // business logic
        System.out.println("[LOG] saveUser() ended");    // Repeated!
    }

    void deleteUser() {
        System.out.println("[LOG] deleteUser() started"); // Repeated!
        // business logic
        System.out.println("[LOG] deleteUser() ended");   // Repeated!
    }
}

// With AOP:
// One Aspect class handles ALL logging

// @Aspect + @Component with Spring AOP
class LoggingAspect {
    // @Before("execution(* com..*(..))") with Spring
    void logBefore() {
        System.out.println("[AOP] Method started");
    }

    // @After("execution(* com..*(..))") with Spring
    void logAfter() {
        System.out.println("[AOP] Method ended");
    }
}

// Now UserService has ZERO logging code!
class UserServiceWithAOP {
    void saveUser() { /* only business logic */ }
    void deleteUser() { /* only business logic */ }
}

// AOP Terms:
// Aspect = Module (e.g., LoggingAspect)
// Advice = What to do (e.g., @Before, @After)
// Pointcut = Where to apply (e.g., every method in package)
// JoinPoint = When it runs (e.g., method execution)

public class AOPDemo {
    public static void main(String[] args) {
        System.out.println("=== AOP (Aspect Oriented Programming) ===");
        System.out.println();
        System.out.println("Problem: Logging/Security repeated in every method");
        System.out.println("Solution: AOP moves it to ONE Aspect class");
        System.out.println();
        System.out.println("@Before → Runs BEFORE matched method");
        System.out.println("@After  → Runs AFTER matched method");
        System.out.println("@Around → Runs BEFORE & AFTER (wraps method)");
        System.out.println();
        System.out.println("execution(* com..*(..))");
        System.out.println("  = all methods in com package");
    }
}
