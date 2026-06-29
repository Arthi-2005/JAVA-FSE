# Module 6b: Code Quality and SonarQube
## Student Notes & Exercise

### What is SonarQube?
- Platform for continuous code inspection
- Static code analysis (not runtime testing)
- "Clean as you code" principle

### Architecture
- Web Server - UI Dashboard
- Compute Engine - Process analysis reports
- Search Server (Elasticsearch) - Search functionality
- Database - Store results

### Integration with Maven

Add to pom.xml:
```xml
<plugin>
    <groupId>org.sonarsource.scanner.maven</groupId>
    <artifactId>sonar-maven-plugin</artifactId>
    <version>3.10.0.2594</version>
</plugin>
```

Run analysis:
```bash
mvn clean verify sonar:sonar \
  -Dsonar.host.url=http://localhost:9000 \
  -Dsonar.login=<your-token>
```

### Quality Metrics
| Metric | Description |
|--------|-------------|
| Cyclomatic Complexity | Measures code complexity |
| Duplications | Duplicate code blocks |
| Coverage | Unit test coverage % |
| Code Smells | Maintainability issues |
| Bugs | Potential runtime errors |
| Vulnerabilities | Security issues |

### Quality Gate
- Pass/Fail based on predefined thresholds
- Must pass before production deployment

### SonarQube Exercise
```java
// Run SonarQube on this code and fix all issues

public class Calculator {
    int a;  // Fix: bad variable name
    int b;
    int c;

    public void doStuff() {  // Fix: bad method name
        System.out.println("doing");
    }

    public String process(String x) {
        // Fix: Handle null
        return x.toLowerCase();
    }
}
```
