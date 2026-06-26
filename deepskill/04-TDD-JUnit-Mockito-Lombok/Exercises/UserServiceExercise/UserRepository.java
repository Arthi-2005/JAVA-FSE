package com.deepskilling.exercises.user;

import java.util.List;
import java.util.Optional;

/**
 * PROBLEM STATEMENT:
 * Define the UserRepository interface that UserService depends on.
 * In a real project this would be a JPA repository or similar.
 * Methods: findById, findAll, save, deleteById
 */
public interface UserRepository {

    Optional<User> findById(long id);

    List<User> findAll();

    User save(User user);

    void deleteById(long id);
}
