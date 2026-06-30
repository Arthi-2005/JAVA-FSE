// DTO = Data Transfer Object
// Carries data between client and server

public class DTODemo {
    public static void main(String[] args) {
        System.out.println("=== DTO (Data Transfer Object) ===");
        System.out.println();
        System.out.println("Why DTO?");
        System.out.println("  Entity = Database representation (has passwords, IDs)");
        System.out.println("  DTO    = What client sees (safe fields only)");
        System.out.println();
        System.out.println("Example:");
        System.out.println("  Product Entity: id, name, price, createdAt, updatedAt");
        System.out.println("  ProductDTO:     name, price  (only what client needs)");
        System.out.println();
        System.out.println("Benefits:");
        System.out.println("  - Hide sensitive data");
        System.out.println("  - Control what client sees");
        System.out.println("  - Decouple API from DB schema");
    }
}