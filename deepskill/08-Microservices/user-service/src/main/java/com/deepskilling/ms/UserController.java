package com.deepskilling.ms;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final Map<Long, Map<String, Object>> users = new HashMap<>();
    private long nextId = 1;

    public UserController() {
        createUser("Alice", "alice@test.com");
        createUser("Bob", "bob@test.com");
    }

    @GetMapping
    public List<Map<String, Object>> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    @GetMapping("/{id}")
    public Map<String, Object> getUser(@PathVariable Long id) {
        return users.get(id);
    }

    @PostMapping
    public Map<String, Object> createUser(@RequestParam String name, @RequestParam String email) {
        Map<String, Object> user = new HashMap<>();
        user.put("id", nextId++);
        user.put("name", name);
        user.put("email", email);
        users.put((Long) user.get("id"), user);
        return user;
    }

    @GetMapping("/feign-test")
    public String feignTest() {
        return "User Service is reachable!";
    }
}
