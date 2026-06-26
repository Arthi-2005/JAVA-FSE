// JUnit = Framework for writing unit tests in Java
// Annotations: @Test, @BeforeEach, @DisplayName
// Assertions: assertEquals, assertTrue, assertThrows

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("JUnit Demo - Simple Math Tests")
class JUnitDemoTest {

    @BeforeEach
    void setUp() {
        // Runs before every test (like creating objects)
        System.out.println("Setup done!");
    }

    @Test
    @DisplayName("Adding two numbers")
    void testAdd() {
        int result = 2 + 3;
        assertEquals(5, result, "2 + 3 should be 5");
    }

    @Test
    @DisplayName("Check if number is even")
    void testIsEven() {
        assertTrue(4 % 2 == 0, "4 should be even");
        assertFalse(3 % 2 == 0, "3 should not be even");
    }

    @Test
    @DisplayName("Division by zero throws exception")
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> {
            int x = 10 / 0;
        }, "Dividing by zero should throw exception");
    }

    @Test
    @DisplayName("Multiple assertions with assertAll")
    void testMultiple() {
        assertAll("Group of math checks",
            () -> assertEquals(4, 2 + 2),
            () -> assertTrue(10 > 5),
            () -> assertNotNull("Hello")
        );
    }
}
