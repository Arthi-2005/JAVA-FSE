// SonarQube = Code quality checker
// Finds bugs, vulnerabilities, code smells automatically

public class SonarQubeDemo {
    public static void main(String[] args) {
        System.out.println("=== SonarQube Code Quality ===");
        System.out.println();
        System.out.println("What SonarQube checks:");
        System.out.println("  Bugs           - Runtime errors");
        System.out.println("  Vulnerabilities - Security issues");
        System.out.println("  Code Smells    - Maintainability problems");
        System.out.println("  Duplications   - Repeated code");
        System.out.println("  Coverage       - Test coverage %");
        System.out.println();
        System.out.println("How to use:");
        System.out.println("  1. docker run -d -p 9000:9000 sonarqube");
        System.out.println("  2. mvn sonar:sonar -Dsonar.projectKey=myapp");
        System.out.println("  3. Open http://localhost:9000");
        System.out.println();
        System.out.println("Quality Gate: PASSED = No critical issues");
    }
}