// Hibernate = Most popular JPA implementation
// JPA = Specification (WHAT to do)
// Hibernate = Implementation (HOW to do it)

public class HibernateDemo {
    public static void main(String[] args) {
        System.out.println("=== Hibernate ORM ===");
        System.out.println();
        System.out.println("JPA vs Hibernate:");
        System.out.println("  JPA       = Interface (specification)");
        System.out.println("  Hibernate = Implementation (actual code)");
        System.out.println();
        System.out.println("What Hibernate does:");
        System.out.println("  1. Reads @Entity annotations");
        System.out.println("  2. Creates tables automatically");
        System.out.println("  3. Converts Java objects to DB rows");
        System.out.println("  4. Converts DB rows back to Java objects");
        System.out.println("  5. Manages transactions");
        System.out.println();
        System.out.println("Hibernate Features:");
        System.out.println("  - Lazy Loading (fetch data only when needed)");
        System.out.println("  - Caching (speed up repeated queries)");
        System.out.println("  - Auto DDL (create/update tables)");
        System.out.println("  - HQL (Hibernate Query Language)");
        System.out.println();
        System.out.println("In application.properties:");
        System.out.println("  spring.jpa.hibernate.ddl-auto = update");
        System.out.println("  -> Hibernate auto-creates tables from entities!");
    }
}
