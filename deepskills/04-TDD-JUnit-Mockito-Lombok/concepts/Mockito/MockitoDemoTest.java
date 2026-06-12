// Mockito = Framework to create fake objects (mocks) for testing
// @Mock = create fake object
// @InjectMocks = inject fake object into real object
// when().thenReturn() = define what mock returns
// verify() = check if method was called

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

// A simple interface to mock
interface GreetingService {
    String greet(String name);
}

// Real class that uses the interface
class HelloApp {
    private GreetingService service;

    public HelloApp(GreetingService service) {
        this.service = service;
    }

    public String sayHello(String name) {
        return service.greet(name);
    }
}

@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
class MockitoDemoTest {

    @Mock
    private GreetingService mockService;

    @InjectMocks
    private HelloApp helloApp;

    @Test
    @DisplayName("Mock returns fake greeting")
    void testMockGreeting() {
        // Arrange: tell mock what to return
        when(mockService.greet("Alice")).thenReturn("Hello, Alice!");

        // Act: call the real method
        String result = helloApp.sayHello("Alice");

        // Assert: check result
        assertEquals("Hello, Alice!", result);

        // Verify: ensure mock was called
        verify(mockService, times(1)).greet("Alice");
    }

    @Test
    @DisplayName("Mock with any argument")
    void testMockAnyArgument() {
        when(mockService.greet(anyString())).thenReturn("Hi there!");

        String result = helloApp.sayHello("Bob");
        assertEquals("Hi there!", result);
    }
}
