package Exercises.InventoryManagement;

import java.util.HashMap;
import java.util.Map;

public class InventoryManager {
    private Map<Integer, Product> inventory = new HashMap<>();

    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
        System.out.println("Added: " + product);
    }

    public void updateProduct(int id, int quantity, double price) {
        Product product = inventory.get(id);
        if (product != null) {
            inventory.put(id, new Product(id, product.getProductName(), quantity, price));
            System.out.println("Updated product " + id);
        } else {
            System.out.println("Product not found");
        }
    }

    public void deleteProduct(int id) {
        if (inventory.remove(id) != null) {
            System.out.println("Deleted product " + id);
        } else {
            System.out.println("Product not found");
        }
    }

    public Product getProduct(int id) {
        return inventory.get(id);
    }

    public void displayAll() {
        inventory.values().forEach(System.out::println);
    }
}
