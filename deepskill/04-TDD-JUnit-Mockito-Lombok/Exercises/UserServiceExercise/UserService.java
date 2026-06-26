package com.deepskilling.exercises.user;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

/**
 * PROBLEM STATEMENT:
 * Implement a UserService with dependency on UserRepository.
 * Methods: getUserById, createUser, deleteUser, getAllUsers.
 * Use Lombok @Slf4j for logging.
 * In a real project, constructor injection would be used with @RequiredArgsConstructor.
 */
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getUserById(long id) {
        log.info("Fetching user by id: {}", id);
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        log.info("Creating user: {}", user.getName());
        return userRepository.save(user);
    }

    public boolean deleteUser(long id) {
        log.info("Deleting user with id: {}", id);
        Optional<User> existing = userRepository.findById(id);
        if (existing.isPresent()) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<User> getAllUsers() {
        log.info("Fetching all users");
        return userRepository.findAll();
    }
}
