package com.deepskilling.ms;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Value("${user.service.url}")
    private String userServiceUrl;

    private final Map<Long, Map<String, Object>> orders = new HashMap<>();
    private long nextId = 1;

    @GetMapping
    public List<Map<String, Object>> getAllOrders() {
        return new ArrayList<>(orders.values());
    }

    @PostMapping
    public Map<String, Object> createOrder(@RequestParam Long userId, @RequestParam String product) {
        Map<String, Object> order = new HashMap<>();
        order.put("id", nextId++);
        order.put("userId", userId);
        order.put("product", product);
        order.put("status", "CREATED");
        orders.put((Long) order.get("id"), order);

        // Inter-service communication via RestTemplate
        RestTemplate rest = new RestTemplate();
        String response = rest.getForObject(userServiceUrl + "/api/users/feign-test", String.class);
        order.put("userServiceResponse", response);

        return order;
    }

    @GetMapping("/{id}")
    public Map<String, Object> getOrder(@PathVariable Long id) {
        return orders.get(id);
    }

    // Feign client simulation
    @GetMapping("/circuit-breaker-test")
    public String testCircuitBreaker() {
        return "Order Service with Circuit Breaker pattern - Fallback handled!";
    }

    // API Gateway routing test
    @GetMapping("/gateway-info")
    public String getGatewayInfo() {
        return "Routed through API Gateway successfully!";
    }
}
