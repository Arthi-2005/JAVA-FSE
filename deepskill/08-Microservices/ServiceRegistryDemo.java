// Service Registry = Eureka - All services register here
// So they find each other without hardcoded URLs

public class ServiceRegistryDemo {
    public static void main(String[] args) {
        System.out.println("=== Service Registry (Eureka) ===");
        System.out.println();
        System.out.println("Problem: Services have dynamic IPs/ports");
        System.out.println("Solution: Each service registers with Eureka");
        System.out.println();
        System.out.println("How it works:");
        System.out.println("  1. OrderService starts -> registers at Eureka");
        System.out.println("  2. PaymentService starts -> registers at Eureka");
        System.out.println("  3. OrderService calls PaymentService:");
        System.out.println("     -> Asks Eureka: 'Where is PaymentService?'");
        System.out.println("     -> Eureka: 'It's at 192.168.1.5:8082'");
        System.out.println("     -> Direct call, no hardcoded URL!");
        System.out.println();
        System.out.println("Spring annotations:");
        System.out.println("  @EnableEurekaServer  (on Eureka app)");
        System.out.println("  @EnableEurekaClient  (on each microservice)");
    }
}