import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SLF4JLoggingDemo {

    private static final Logger logger = LoggerFactory.getLogger(SLF4JLoggingDemo.class);

    public static void main(String[] args) {
        logger.info("Application started successfully");

        try {
            int result = divide(10, 0);
        } catch (ArithmeticException e) {
            logger.error("Division by zero occurred: {}", e.getMessage());
        }

        try {
            String data = fetchData(null);
        } catch (IllegalArgumentException e) {
            logger.warn("Invalid input provided: {}", e.getMessage());
        }

        logger.debug("Processing order #12345");
        logger.info("Order #12345 processed successfully");
        logger.warn("Order #12345 has low inventory - only 2 items left");
        logger.error("Payment failed for order #12345: Insufficient funds");

        System.out.println("Check the console above for SLF4J log output with different levels (INFO, WARN, ERROR, DEBUG)");
    }

    public static int divide(int a, int b) {
        return a / b;
    }

    public static String fetchData(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        return "Data for: " + input;
    }
}
