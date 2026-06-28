// JPA = Java Persistence API
// A standard way to map Java objects to database tables
// No SQL needed - just annotations!

public class JPADemo {
    public static void main(String[] args) {
        System.out.println("=== JPA (Java Persistence API) ===");
        System.out.println();
        System.out.println("What is JPA?");
        System.out.println("  A specification to map Java objects to DB tables");
        System.out.println();
        System.out.println("Key Annotations:");
        System.out.println("  @Entity     - Marks class as a DB table");
        System.out.println("  @Table      - Specifies table name");
        System.out.println("  @Id         - Marks primary key");
        System.out.println("  @GeneratedValue - Auto-generate IDs");
        System.out.println("  @Column     - Maps field to column");
        System.out.println();
        System.out.println("Example:");
        System.out.println("  @Entity");
        System.out.println("  @Table(name = \"employees\")");
        System.out.println("  public class Employee {");
        System.out.println("      @Id @GeneratedValue");
        System.out.println("      private Long id;");
        System.out.println("      @Column(nullable = false)");
        System.out.println("      private String name;");
        System.out.println("  }");
        System.out.println();
        System.out.println("Instead of: INSERT INTO employees VALUES (...)");
        System.out.println("You write: repository.save(employee)");
    }
}
