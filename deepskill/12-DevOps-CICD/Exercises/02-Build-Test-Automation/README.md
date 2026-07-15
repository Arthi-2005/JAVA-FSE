# Exercise 02 — Build & Test Automation

## Objectives

- Set up a Jenkins job that builds a Maven project
- Run unit tests automatically
- View test reports in Jenkins

## Step-by-Step

### 1. Create a Simple Maven Project

Create a file `pom.xml`:

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.example</groupId>
    <artifactId>ci-demo</artifactId>
    <version>1.0.0</version>
    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13.2</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
</project>
```

Create `src/main/java/Calculator.java`:

```java
public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
    public int subtract(int a, int b) {
        return a - b;
    }
}
```

Create `src/test/java/CalculatorTest.java`:

```java
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {
    @Test
    public void testAdd() {
        Calculator calc = new Calculator();
        assertEquals(5, calc.add(2, 3));
    }
    @Test
    public void testSubtract() {
        Calculator calc = new Calculator();
        assertEquals(1, calc.subtract(3, 2));
    }
}
```

### 2. Create a Jenkins Job

- New Item → "Maven-Build-Demo" → Freestyle project.
- Source Code Management: None (we'll use local files).
- Build: Add build step → "Invoke top-level Maven targets".
- Goals: `clean test`
- Save.

### 3. Configure Maven in Jenkins

- If Maven is not configured: Manage Jenkins → Global Tool Configuration → Maven → Add Maven.
- Name: "MyMaven", choose "Install automatically".

### 4. Run and Check Results

- Click "Build Now".
- Check "Console Output" for test results.
- If JUnit plugin is installed, test results appear under "Test Result".

## Practice Tasks

1. Add a failing test and observe the build status.
2. Add a `package` goal after `test` to create a JAR file.
3. Configure Jenkins to send email on build failure.
