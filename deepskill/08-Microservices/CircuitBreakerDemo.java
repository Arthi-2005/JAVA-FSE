// Circuit Breaker = Prevents cascading failures
// If a service is down, don't keep calling it - fail fast!

public class CircuitBreakerDemo {
    public static void main(String[] args) {
        System.out.println("=== Circuit Breaker (Resilience4J) ===");
        System.out.println();
        System.out.println("States:");
        System.out.println("  CLOSED   - Normal, calls go through");
        System.out.println("  OPEN     - Failures > threshold, NO calls go through");
        System.out.println("  HALF_OPEN - After timeout, test with 1 call");
        System.out.println();
        System.out.println("Example: OrderService calls PaymentService");
        System.out.println("  PaymentService goes down...");
        System.out.println("  Circuit: CLOSED -> OPEN (after 5 failures)");
        System.out.println("  -> Immediate fallback: 'Payment unavailable'");
        System.out.println("  -> PaymentService comes back up...");
        System.out.println("  Circuit: HALF_OPEN -> CLOSED (test passes)");
        System.out.println();
        System.out.println("No cascading failures!");
    }
}