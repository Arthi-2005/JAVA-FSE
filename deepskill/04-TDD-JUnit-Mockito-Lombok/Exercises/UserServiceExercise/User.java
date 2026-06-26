package com.deepskilling.exercises.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * PROBLEM STATEMENT:
 * Create a User model class to be used with UserRepository and UserService.
 * Use Lombok annotations to reduce boilerplate.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private long id;
    private String name;
    private String email;
    private int age;
}
