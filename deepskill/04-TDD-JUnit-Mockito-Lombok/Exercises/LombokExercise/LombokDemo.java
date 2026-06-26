package com.deepskilling.exercises.lombok;

/**
 * PROBLEM STATEMENT:
 * Demonstrate the Lombok annotations from the Product class.
 * Create Product objects using the builder, show toString, equals,
 * hashCode behavior, and print clear output.
 */
public class LombokDemo {

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("  Lombok Annotations — Demo");
        System.out.println("========================================\n");

        // Using @Builder to create Product objects
        Product product1 = Product.builder()
                .id(101L)
                .name("Wireless Mouse")
                .price(29.99)
                .category("Electronics")
                .build();

        Product product2 = Product.builder()
                .id(102L)
                .name("Mechanical Keyboard")
                .price(89.99)
                .category("Electronics")
                .build();

        // Using @AllArgsConstructor
        Product product3 = new Product(103L, "USB-C Hub", 45.50, "Accessories");

        // Using @NoArgsConstructor + setters
        Product product4 = new Product();
        product4.setId(104L);
        product4.setName("Monitor Stand");
        product4.setPrice(59.99);
        product4.setCategory("Office");

        // --- Demonstrating @ToString(exclude="price") ---
        System.out.println("▶ @ToString (price excluded):");
        System.out.println("  product1 = " + product1);
        System.out.println("  product2 = " + product2);
        System.out.println("  product3 = " + product3);
        System.out.println("  product4 = " + product4);
        System.out.println();

        // --- Demonstrating @EqualsAndHashCode ---
        System.out.println("▶ @EqualsAndHashCode:");
        Product product1Copy = Product.builder()
                .id(101L)
                .name("Wireless Mouse")
                .price(39.99)   // different price — but @EqualsAndHashCode uses all fields
                .category("Electronics")
                .build();

        System.out.println("  product1.equals(product1Copy) = " + product1.equals(product1Copy));
        System.out.println("  product1.hashCode() = " + product1.hashCode());
        System.out.println("  product1Copy.hashCode() = " + product1Copy.hashCode());
        System.out.println();

        // --- Demonstrating @Data getters/setters ---
        System.out.println("▶ @Data (getters & setters):");
        System.out.println("  product1.getName() = " + product1.getName());
        System.out.println("  product1.getCategory() = " + product1.getCategory());
        System.out.println();

        // --- @Builder with partial fields ---
        System.out.println("▶ @Builder (partial fields):");
        Product partial = Product.builder()
                .name("Partial Product")
                .price(9.99)
                .build();
        System.out.println("  partial = " + partial);   // id=0, category=null
        System.out.println("  partial.getId() = " + partial.getId());
        System.out.println("  partial.getCategory() = " + partial.getCategory());

        System.out.println("\n========================================");
        System.out.println("  Demo complete.");
        System.out.println("========================================");
    }
}
