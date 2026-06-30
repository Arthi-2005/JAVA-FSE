package com.deepskilling.rest.controller;

import org.springframework.web.bind.annotation.*;
import jakarta.annotation.PostConstruct;
import java.util.*;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    private Map<String, String> countries = new HashMap<>();

    @PostConstruct
    public void init() {
        countries.put("IN", "India");
        countries.put("US", "United States");
        countries.put("UK", "United Kingdom");
    }

    @GetMapping
    public Map<String, String> getAll() {
        return countries;
    }

    @GetMapping("/{code}")
    public String getByCode(@PathVariable String code) {
        String name = countries.get(code.toUpperCase());
        if (name == null) throw new NoSuchElementException("Country not found: " + code);
        return name;
    }

    @PostMapping
    public String add(@RequestParam String code, @RequestParam String name) {
        countries.put(code.toUpperCase(), name);
        return "Added " + name;
    }
}
