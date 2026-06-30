package com.deepskilling.rest.controller;

import com.deepskilling.rest.dto.ProductDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductControllerTest {

    @Autowired
    private TestRestTemplate rest;

    private String baseUrl = "/api/products";

    @Test
    void getAllProducts_shouldReturnList() {
        ResponseEntity<ProductDTO[]> response = rest.getForEntity(baseUrl, ProductDTO[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().length > 0);
    }

    @Test
    void getProduct_shouldReturnProduct() {
        ResponseEntity<ProductDTO> response = rest.getForEntity(baseUrl + "/1", ProductDTO.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Laptop", response.getBody().getName());
    }

    @Test
    void getProduct_shouldReturn404() {
        ResponseEntity<String> response = rest.getForEntity(baseUrl + "/999", String.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void createProduct_shouldReturnCreated() {
        ProductDTO newProduct = ProductDTO.builder().name("Tablet").category("Electronics").price(299.99).stockQuantity(5).build();
        ResponseEntity<ProductDTO> response = rest.postForEntity(baseUrl, newProduct, ProductDTO.class);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody().getId());
    }
}
