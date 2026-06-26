/*
 * PROBLEM: Demonstrate Maven's build lifecycle phases and dependency management.
 * Maven standardizes builds through phases: compile → test-compile → test → package.
 * Dependency management resolves transitive JARs from remote repositories.
 * This class simulates those phases and provides a String utility that mirrors
 * what a real dependency like Apache Commons Lang would do.
 */
package com.deepskilling.exercises.maven;

import java.util.Arrays;
import java.util.List;

public class MavenBuildDemo {

    /*
     * Simulates Apache Commons Lang's StringUtils.capitalize().
     * In a real Maven project this would come from an external dependency
     * declared in pom.xml. Here we inline it to avoid needing the JAR.
     */
    public static String capitalize(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return Character.toUpperCase(input.charAt(0)) + input.substring(1);
    }

    /*
     * Simulates Apache Commons Lang's StringUtils.reverse().
     */
    public static String reverse(String input) {
        if (input == null) {
            return null;
        }
        return new StringBuilder(input).reverse().toString();
    }

    public static void simulateMavenBuild() {
        System.out.println("--- Maven Build Lifecycle Simulation ---\n");

        // Phase 1: compile
        System.out.println("Phase 1: compile");
        System.out.println("  [javac] Compiling source code from src/main/java...");
        System.out.println("  [javac] Output -> target/classes/\n");

        // Phase 2: test-compile
        System.out.println("Phase 2: test-compile");
        System.out.println("  [javac] Compiling test sources from src/test/java...");
        System.out.println("  [javac] Output -> target/test-classes/\n");

        // Phase 3: test
        System.out.println("Phase 3: test");
        System.out.println("  [surefire] Running unit tests...");
        System.out.println("  [surefire] Tests run: 12, Failures: 0, Errors: 0\n");

        // Phase 4: package
        System.out.println("Phase 4: package");
        System.out.println("  [jar] Creating JAR archive...");
        System.out.println("  [jar] Output -> target/maven-exercise-1.0.0.jar\n");
    }

    public static void simulateDependencyManagement() {
        System.out.println("--- Maven Dependency Management Simulation ---\n");

        List<String> dependencies = Arrays.asList(
            "commons-lang3:commons-lang3:3.14.0  (compile)",
            "org.junit:junit-bom:5.10.0          (test)",
            "org.apache.logging:log4j:2.20.0     (runtime)"
        );

        System.out.println("Resolved dependencies from Maven Central:");
        for (String dep : dependencies) {
            System.out.println("  " + dep);
        }

        System.out.println("\nTransitive dependencies resolved automatically.");
        System.out.println("Scope rules applied: compile, test, runtime, provided.\n");
    }

    public static void main(String[] args) {
        System.out.println("=== Maven Build & Dependency Management Demonstration ===\n");

        simulateMavenBuild();

        System.out.println("Using simulated library dependency (like Apache Commons Lang):");
        String sample = "hello maven!";
        System.out.println("  Original:   " + sample);
        System.out.println("  Capitalize: " + capitalize(sample));
        System.out.println("  Reverse:    " + reverse(sample));

        System.out.println();
        simulateDependencyManagement();

        System.out.println("Maven standardizes the build: compile -> test -> package.");
        System.out.println("Dependency management pulls transitive JARs automatically.");
    }
}
