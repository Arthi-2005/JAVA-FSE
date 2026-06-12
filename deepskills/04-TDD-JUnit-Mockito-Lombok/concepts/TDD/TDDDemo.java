// TDD = Test Driven Development
// Cycle: Write test FIRST → See it fail (RED) → Write code to pass (GREEN) → Clean up (REFACTOR)

public class TDDDemo {

    // Step 1: First we write a test (in our mind or on paper)
    // We want a method that checks if a number is positive
    // Test: isPositive(5) → true
    // Test: isPositive(-3) → false
    // Test: isPositive(0) → false

    // Step 2: Write minimal code to pass
    public static boolean isPositive(int num) {
        return num > 0;
    }

    // Step 3: Run test → passes! Now refactor if needed

    public static void main(String[] args) {
        // Manual TDD verification
        System.out.println("TDD Demo - Testing isPositive()");
        System.out.println("isPositive(5): " + (isPositive(5) == true ? "PASS" : "FAIL"));
        System.out.println("isPositive(-3): " + (isPositive(-3) == false ? "PASS" : "FAIL"));
        System.out.println("isPositive(0): " + (isPositive(0) == false ? "PASS" : "FAIL"));
    }
}
