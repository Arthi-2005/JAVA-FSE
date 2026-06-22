package Exercises.InventoryManagement;

public class InventoryTest {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        manager.addProduct(new Product(101, "Laptop", 10, 75000));
        manager.addProduct(new Product(102, "Mouse", 50, 500));
        manager.addProduct(new Product(103, "Keyboard", 30, 1200));
        System.out.println("--- All Products ---");
        manager.displayAll();
        System.out.println("--- Update & Delete ---");
        manager.updateProduct(102, 45, 450);
        manager.deleteProduct(103);
        System.out.println("--- Final Inventory ---");
        manager.displayAll();
    }
}
