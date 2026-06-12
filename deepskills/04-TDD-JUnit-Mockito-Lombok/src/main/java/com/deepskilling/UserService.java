package com.deepskilling;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class User {
    private Long id;
    private String name;
    private String email;
    private int age;
}

interface UserRepository {
    User findById(Long id);
    User save(User user);
    void deleteById(Long id);
    List<User> findAll();
}

@Slf4j
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Long id) {
        log.info("Fetching user with id: {}", id);
        User user = userRepository.findById(id);
        if (user == null) {
            log.warn("User not found with id: {}", id);
            throw new NoSuchElementException("User not found: " + id);
        }
        return user;
    }

    public User createUser(String name, String email, int age) {
        log.info("Creating user: {}", name);
        User user = User.builder()
                .name(name)
                .email(email)
                .age(age)
                .build();
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        log.info("Deleting user with id: {}", id);
        userRepository.deleteById(id);
    }

    public List<User> getAllUsers() {
        log.info("Fetching all users");
        return userRepository.findAll();
    }
}
