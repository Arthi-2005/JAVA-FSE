// Config Server = Centralized config for ALL microservices
// Change one property -> ALL services pick it up!

public class ConfigServerDemo {
    public static void main(String[] args) {
        System.out.println("=== Config Server (Spring Cloud Config) ===");
        System.out.println();
        System.out.println("Problem: Change DB URL in 10 microservices");
        System.out.println("  -> Open each, change, restart each");
        System.out.println();
        System.out.println("Solution: Config Server");
        System.out.println("  One Git repo with all configs");
        System.out.println("  All services read from it");
        System.out.println();
        System.out.println("Config files in Git:");
        System.out.println("  order-service.yml");
        System.out.println("  payment-service.yml");
        System.out.println("  user-service.yml");
        System.out.println();
        System.out.println("Change DB URL in order-service.yml");
        System.out.println("  -> All OrderService instances refresh automatically!");
        System.out.println();
        System.out.println("@RefreshScope - beans reload at runtime");
    }
}