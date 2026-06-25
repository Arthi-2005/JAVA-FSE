// Maven = Build tool & dependency manager
// pom.xml = Project Object Model - heart of Maven

public class MavenDemo {
    public static void main(String[] args) {
        System.out.println("=== Maven Basics ===");
        System.out.println();
        System.out.println("pom.xml contains:");
        System.out.println("  <groupId>    = Your org (com.deepskilling)");
        System.out.println("  <artifactId> = Project name (spring-core-maven)");
        System.out.println("  <version>    = 1.0");
        System.out.println("  <dependencies> = External libraries to download");
        System.out.println();
        System.out.println("Common Maven commands:");
        System.out.println("  mvn compile     → Compile Java files");
        System.out.println("  mvn test        → Run tests");
        System.out.println("  mvn package     → Create JAR file");
        System.out.println("  mvn clean       → Delete target/ folder");
        System.out.println("  mvn install     → Install to local repo");
        System.out.println();
        System.out.println("Maven lifecycle:");
        System.out.println("  validate → compile → test → package → verify → install → deploy");
        System.out.println();
        System.out.println("Spring dependencies in pom.xml:");
        System.out.println("  spring-context  → Core Spring container");
        System.out.println("  spring-aop      → AOP support");
        System.out.println("  aspectjweaver   → AspectJ integration");
    }
}
