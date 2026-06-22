package Exercises.SortingOrders;

import java.util.Arrays;

public class SortingTest {
    public static void main(String[] args) {
        Order[] orders = {
            new Order(1, "Alice", 250.00),
            new Order(2, "Bob", 150.00),
            new Order(3, "Charlie", 450.00),
            new Order(4, "Diana", 100.00)
        };

        Order[] bubbleOrders = orders.clone();
        SortingService.bubbleSort(bubbleOrders);
        System.out.println("Bubble Sort: " + Arrays.toString(bubbleOrders));

        Order[] quickOrders = orders.clone();
        SortingService.quickSort(quickOrders, 0, quickOrders.length - 1);
        System.out.println("Quick Sort: " + Arrays.toString(quickOrders));
    }
}
