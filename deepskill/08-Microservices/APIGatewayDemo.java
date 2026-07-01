// API Gateway = Single entry point for ALL microservices
// Routes requests to the right service

public class APIGatewayDemo {
    public static void main(String[] args) {
        System.out.println("=== API Gateway (Spring Cloud Gateway) ===");
        System.out.println();
        System.out.println("Client -> API Gateway -> Microservices");
        System.out.println();
        System.out.println("Routing config:");
        System.out.println("  /api/orders/**   -> OrderService");
        System.out.println("  /api/payments/** -> PaymentService");
        System.out.println("  /api/users/**    -> UserService");
        System.out.println();
        System.out.println("Benefits:");
        System.out.println("  - Single URL for client");
        System.out.println("  - Authentication at ONE place");
        System.out.println("  - Rate limiting");
        System.out.println("  - Load balancing");
        System.out.println("  - Logging all requests");
        System.out.println();
        System.out.println("Spring: @EnableZuulProxy (older)");
    }
}