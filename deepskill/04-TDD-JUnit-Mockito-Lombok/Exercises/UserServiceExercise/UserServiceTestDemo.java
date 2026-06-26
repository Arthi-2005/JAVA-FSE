package com.deepskilling.exercises.user;

import java.util.*;

/**
 * PROBLEM STATEMENT:
 * Simulate Mockito-style testing for UserService without the actual Mockito library.
 * Create a hand-written mock of UserRepository (using a HashMap-backed stub),
 * inject it into UserService, and verify the service methods behave correctly.
 */
public class UserServiceTestDemo {

    private static int passed = 0;
    private static int failed = 0;

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("  UserService — Manual Mock Test Demo");
        System.out.println("========================================\n");

        // --- Create the mock repository ---
        UserRepository mockRepo = new InMemoryUserRepository();
        UserService userService = new UserService(mockRepo);

        // Pre-populate with one user (as if it already existed in DB)
        User existingUser = User.builder()
                .id(1L)
                .name("Alice")
                .email("alice@example.com")
                .age(30)
                .build();
        mockRepo.save(existingUser);

        // --- testGetUserById: existing user ---
        System.out.println("▶ testGetUserById (found)");
        Optional<User> found = userService.getUserById(1L);
        assertTrue("getUserById(1) should be present", found.isPresent());
        assertEqual("user name", "Alice", found.get().getName());
        assertEqual("user email", "alice@example.com", found.get().getEmail());

        // --- testGetUserById: missing user ---
        System.out.println("▶ testGetUserById (not found)");
        Optional<User> notFound = userService.getUserById(99L);
        assertFalse("getUserById(99) should be empty", notFound.isPresent());

        // --- testCreateUser ---
        System.out.println("▶ testCreateUser");
        User newUser = User.builder()
                .id(2L)
                .name("Bob")
                .email("bob@example.com")
                .age(25)
                .build();
        User created = userService.createUser(newUser);
        assertEqual("created user name", "Bob", created.getName());
        assertEqual("created user id", 2L, created.getId());

        // Verify it was actually saved
        Optional<User> retrieved = mockRepo.findById(2L);
        assertTrue("saved user should be retrievable", retrieved.isPresent());
        assertEqual("retrieved name", "Bob", retrieved.get().getName());

        // --- testGetAllUsers ---
        System.out.println("▶ testGetAllUsers");
        List<User> allUsers = userService.getAllUsers();
        assertEqual("user count", 2, allUsers.size());

        // --- testDeleteUser: existing ---
        System.out.println("▶ testDeleteUser (existing)");
        boolean deleted = userService.deleteUser(1L);
        assertTrue("delete should return true", deleted);
        Optional<User> afterDelete = mockRepo.findById(1L);
        assertFalse("user should no longer exist", afterDelete.isPresent());

        // --- testDeleteUser: non-existing ---
        System.out.println("▶ testDeleteUser (non-existing)");
        boolean deletedMissing = userService.deleteUser(99L);
        assertFalse("delete of missing user should return false", deletedMissing);

        System.out.println("\n========================================");
        System.out.printf("  RESULTS: %d passed, %d failed%n", passed, failed);
        System.out.println("========================================");
    }

    // --- Helper assertions ---

    private static void assertEqual(String label, Object expected, Object actual) {
        if (Objects.equals(expected, actual)) {
            System.out.printf("  ✓ %s = %s%n", label, actual);
            passed++;
        } else {
            System.out.printf("  ✗ %s — expected %s but got %s%n", label, expected, actual);
            failed++;
        }
    }

    private static void assertTrue(String label, boolean condition) {
        if (condition) {
            System.out.printf("  ✓ %s%n", label);
            passed++;
        } else {
            System.out.printf("  ✗ %s — expected true%n", label);
            failed++;
        }
    }

    private static void assertFalse(String label, boolean condition) {
        if (!condition) {
            System.out.printf("  ✓ %s%n", label);
            passed++;
        } else {
            System.out.printf("  ✗ %s — expected false%n", label);
            failed++;
        }
    }

    // --- Simple in-memory repository implementation (acts as mock/stub) ---
    private static class InMemoryUserRepository implements UserRepository {
        private final Map<Long, User> store = new HashMap<>();
        private long nextId = 1;

        @Override
        public Optional<User> findById(long id) {
            return Optional.ofNullable(store.get(id));
        }

        @Override
        public List<User> findAll() {
            return new ArrayList<>(store.values());
        }

        @Override
        public User save(User user) {
            if (user.getId() == 0) {
                User built = User.builder()
                        .id(nextId++)
                        .name(user.getName())
                        .email(user.getEmail())
                        .age(user.getAge())
                        .build();
                store.put(built.getId(), built);
                return built;
            }
            store.put(user.getId(), user);
            return user;
        }

        @Override
        public void deleteById(long id) {
            store.remove(id);
        }
    }
}
