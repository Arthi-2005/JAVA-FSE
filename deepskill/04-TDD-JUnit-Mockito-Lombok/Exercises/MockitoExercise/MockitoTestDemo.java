package com.deepskilling.exercises.mockito;

import java.util.*;

/**
 * PROBLEM STATEMENT:
 * Simulate Mockito-style testing for OrderService without the actual Mockito library.
 * Create a hand-written mock of PaymentGateway using a HashMap to track expected
 * behavior (stubbing) and call records (verification).
 *
 * Demonstrate:
 * - Stubbing: configure mock to return specific values for given inputs
 * - Verification: check that certain methods were called with expected arguments
 */
public class MockitoTestDemo {

    private static int passed = 0;
    private static int failed = 0;

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("  Mockito-Style Test — Demo");
        System.out.println("========================================\n");

        // --- Create the mock gateway ---
        MockPaymentGateway mockGateway = new MockPaymentGateway();
        OrderService orderService = new OrderService(mockGateway);

        // --- STUBBING: configure mock behavior ---
        // processPayment succeeds for "ORDER-001" and "ORDER-002", fails for "ORDER-BAD"
        // refund succeeds for "ORDER-001", fails for "ORDER-002"
        mockGateway.whenProcessPayment("ORDER-001", 100.00, true);
        mockGateway.whenProcessPayment("ORDER-002", 49.99, true);
        mockGateway.whenProcessPayment("ORDER-BAD", 10.00, false);
        mockGateway.whenRefund("ORDER-001", true);
        mockGateway.whenRefund("ORDER-002", false);

        // --- testPlaceOrder: success ---
        System.out.println("▶ testPlaceOrder (success)");
        boolean placed1 = orderService.placeOrder("ORDER-001", 100.00);
        assertTrue("placeOrder should succeed", placed1);
        assertTrue("order should exist", orderService.orderExists("ORDER-001"));

        // --- testPlaceOrder: payment failure ---
        System.out.println("▶ testPlaceOrder (payment failure)");
        boolean placed2 = orderService.placeOrder("ORDER-BAD", 10.00);
        assertFalse("placeOrder should fail", placed2);
        assertFalse("order should not exist", orderService.orderExists("ORDER-BAD"));

        // --- testCancelOrder: success ---
        System.out.println("▶ testCancelOrder (success)");
        boolean cancelled1 = orderService.cancelOrder("ORDER-001");
        assertTrue("cancelOrder should succeed", cancelled1);
        assertFalse("order should be removed", orderService.orderExists("ORDER-001"));

        // --- testCancelOrder: non-existing order ---
        System.out.println("▶ testCancelOrder (non-existing)");
        boolean cancelled2 = orderService.cancelOrder("ORDER-NONEXIST");
        assertFalse("cancelOrder should fail for missing order", cancelled2);

        // --- testCancelOrder: refund failure ---
        System.out.println("▶ testCancelOrder (refund failure)");
        orderService.placeOrder("ORDER-002", 49.99);
        boolean cancelled3 = orderService.cancelOrder("ORDER-002");
        assertFalse("cancelOrder should fail when refund fails", cancelled3);
        assertTrue("order should still exist", orderService.orderExists("ORDER-002"));

        // --- VERIFICATION: check that methods were called as expected ---
        System.out.println("▶ Verification:");
        assertTrue("processPayment(ORDER-001, 100.00) was called",
                mockGateway.wasProcessPaymentCalled("ORDER-001", 100.00));
        assertTrue("processPayment(ORDER-BAD, 10.00) was called",
                mockGateway.wasProcessPaymentCalled("ORDER-BAD", 10.00));
        assertTrue("refund(ORDER-001) was called",
                mockGateway.wasRefundCalled("ORDER-001"));
        assertTrue("refund(ORDER-002) was called",
                mockGateway.wasRefundCalled("ORDER-002"));
        assertFalse("refund(ORDER-NONEXIST) should NOT have been called",
                mockGateway.wasRefundCalled("ORDER-NONEXIST"));

        System.out.println("\n========================================");
        System.out.printf("  RESULTS: %d passed, %d failed%n", passed, failed);
        System.out.println("========================================");
    }

    // --- Helper assertions ---

    private static void assertTrue(String label, boolean condition) {
        if (condition) {
            System.out.printf("  ✓ %s%n", label);
            passed++;
        } else {
            System.out.printf("  ✗ %s — expected true%n", label);
            failed++;
        }
    }

    private static void assertFalse(String label, boolean condition) {
        if (!condition) {
            System.out.printf("  ✓ %s%n", label);
            passed++;
        } else {
            System.out.printf("  ✗ %s — expected false%n", label);
            failed++;
        }
    }

    // --- Hand-written mock for PaymentGateway with stubbing & verification ---
    private static class MockPaymentGateway implements PaymentGateway {

        // Stubbing rules
        private final Map<String, Boolean> processPaymentStubs = new HashMap<>();
        private final Map<String, Boolean> refundStubs = new HashMap<>();

        // Call records for verification
        private final List<String> processPaymentCalls = new ArrayList<>();
        private final List<String> refundCalls = new ArrayList<>();

        // --- Stubbing methods ---
        void whenProcessPayment(String orderId, double amount, boolean result) {
            processPaymentStubs.put(key(orderId, amount), result);
        }

        void whenRefund(String orderId, boolean result) {
            refundStubs.put(orderId, result);
        }

        // --- Interface implementation ---
        @Override
        public boolean processPayment(String orderId, double amount) {
            String callKey = key(orderId, amount);
            processPaymentCalls.add(callKey);

            if (processPaymentStubs.containsKey(callKey)) {
                return processPaymentStubs.get(callKey);
            }
            // default: return true if we have a stub for any amount for this order
            return processPaymentStubs.entrySet().stream()
                    .filter(e -> e.getKey().startsWith(orderId + "::"))
                    .findFirst()
                    .map(Map.Entry::getValue)
                    .orElse(true);
        }

        @Override
        public boolean refund(String orderId) {
            refundCalls.add(orderId);
            return refundStubs.getOrDefault(orderId, true);
        }

        // --- Verification methods ---
        boolean wasProcessPaymentCalled(String orderId, double amount) {
            return processPaymentCalls.contains(key(orderId, amount));
        }

        boolean wasRefundCalled(String orderId) {
            return refundCalls.contains(orderId);
        }

        // --- Key helper ---
        private String key(String orderId, double amount) {
            return orderId + "::" + amount;
        }
    }
}
