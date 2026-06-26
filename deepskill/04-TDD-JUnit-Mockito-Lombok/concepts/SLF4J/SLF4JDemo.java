// SLF4J = Simple Logging Facade for Java
// Log levels: TRACE < DEBUG < INFO < WARN < ERROR
// @Slf4j = Lombok annotation to auto-create logger

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SLF4JDemo {

    public static void main(String[] args) {
        System.out.println("=== SLF4J Logging Demo ===\n");

        // Different log levels
        log.trace("This is TRACE - most detailed");
        log.debug("This is DEBUG - for development");
        log.info("This is INFO - general information");
        log.warn("This is WARN - something unexpected");
        log.error("This is ERROR - something failed");

        // Logging with variables ({} is placeholder)
        String user = "Alice";
        int age = 25;
        log.info("User {} is {} years old", user, age);

        // Logging exceptions
        try {
            int x = 10 / 0;
        } catch (Exception e) {
            log.error("Error occurred: {}", e.getMessage());
        }

        System.out.println("\nCheck console for log output!");
    }
}
