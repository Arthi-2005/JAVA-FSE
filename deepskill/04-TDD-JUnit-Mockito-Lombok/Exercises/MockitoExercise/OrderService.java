package com.deepskilling.exercises.mockito;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * PROBLEM STATEMENT:
 * Implement OrderService that depends on PaymentGateway.
 * placeOrder() processes payment and records the order.
 * cancelOrder() refunds the payment if the order exists.
 * Use Lombok @Slf4j for logging.
 */
@Slf4j
public class OrderService {

    private final PaymentGateway paymentGateway;
    private final Map<String, Double> orders = new HashMap<>();

    public OrderService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public boolean placeOrder(String orderId, double amount) {
        log.info("Placing order: {} for ${}", orderId, amount);
        boolean success = paymentGateway.processPayment(orderId, amount);
        if (success) {
            orders.put(orderId, amount);
            log.info("Order {} placed successfully", orderId);
        } else {
            log.warn("Payment failed for order {}", orderId);
        }
        return success;
    }

    public boolean cancelOrder(String orderId) {
        log.info("Cancelling order: {}", orderId);
        if (!orders.containsKey(orderId)) {
            log.warn("Order {} not found", orderId);
            return false;
        }
        boolean refunded = paymentGateway.refund(orderId);
        if (refunded) {
            orders.remove(orderId);
            log.info("Order {} cancelled and refunded", orderId);
        } else {
            log.warn("Refund failed for order {}", orderId);
        }
        return refunded;
    }

    public boolean orderExists(String orderId) {
        return orders.containsKey(orderId);
    }
}
