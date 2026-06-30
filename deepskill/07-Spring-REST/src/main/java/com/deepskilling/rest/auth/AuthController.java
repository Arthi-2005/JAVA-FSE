package com.deepskilling.rest.auth;

import com.deepskilling.rest.security.JwtUtil;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String token = JwtUtil.generateToken(username);
        return Map.of("token", token);
    }
}
