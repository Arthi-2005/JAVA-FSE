package com.deepskilling.exercises.lombok;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * PROBLEM STATEMENT:
 * Demonstrate Lombok annotations on a Product model class.
 *
 * Annotations to use:
 * - @Data        : generates getters, setters, toString, equals, hashCode, requiredArgsConstructor
 * - @Builder     : generates a builder pattern for object creation
 * - @NoArgsConstructor  : generates a no-args constructor
 * - @AllArgsConstructor : generates an all-args constructor
 * - @ToString(exclude="price") : custom toString that excludes price
 * - @EqualsAndHashCode        : custom equals/hashCode (overrides @Data defaults)
 *
 * Fields: id (long), name (String), price (double), category (String)
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "price")
@EqualsAndHashCode
public class Product {
    private long id;
    private String name;
    private double price;
    private String category;
}
