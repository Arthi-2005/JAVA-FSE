package com.deepskilling;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private User testUser;

    @BeforeEach
    void setUp() {
        testUser = User.builder()
                .id(1L)
                .name("John Doe")
                .email("john@example.com")
                .age(25)
                .build();
    }

    @Test
    @DisplayName("Get user by ID - success")
    void testGetUserById_Success() {
        when(userRepository.findById(1L)).thenReturn(testUser);

        User result = userService.getUserById(1L);

        assertNotNull(result);
        assertEquals("John Doe", result.getName());
        assertEquals("john@example.com", result.getEmail());
        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    @DisplayName("Get user by ID - not found should throw exception")
    void testGetUserById_NotFound() {
        when(userRepository.findById(99L)).thenReturn(null);

        assertThrows(NoSuchElementException.class, () -> userService.getUserById(99L));
        verify(userRepository, times(1)).findById(99L);
    }

    @Test
    @DisplayName("Create user successfully")
    void testCreateUser() {
        User newUser = User.builder()
                .name("Jane Doe")
                .email("jane@example.com")
                .age(30)
                .build();

        when(userRepository.save(any(User.class))).thenReturn(
            User.builder().id(2L).name("Jane Doe").email("jane@example.com").age(30).build()
        );

        User result = userService.createUser("Jane Doe", "jane@example.com", 30);

        assertNotNull(result);
        assertEquals(2L, result.getId());
        assertEquals("Jane Doe", result.getName());
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    @DisplayName("Delete user")
    void testDeleteUser() {
        doNothing().when(userRepository).deleteById(1L);

        userService.deleteUser(1L);

        verify(userRepository, times(1)).deleteById(1L);
    }

    @Test
    @DisplayName("Get all users")
    void testGetAllUsers() {
        List<User> users = Arrays.asList(
            testUser,
            User.builder().id(2L).name("Jane").email("jane@test.com").age(28).build()
        );

        when(userRepository.findAll()).thenReturn(users);

        List<User> result = userService.getAllUsers();

        assertEquals(2, result.size());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Mockito argument matchers demo")
    void testWithArgumentMatchers() {
        when(userRepository.findById(anyLong())).thenReturn(testUser);

        User result = userService.getUserById(100L);

        assertNotNull(result);
        assertEquals("John Doe", result.getName());
    }
}
