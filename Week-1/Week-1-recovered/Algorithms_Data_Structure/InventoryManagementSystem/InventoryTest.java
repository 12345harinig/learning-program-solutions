package InventoryManagementSystem;

public class InventoryTest {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();

        // Add Products
        manager.addProduct(new Product(101, "Laptop", 10, 55000));
        manager.addProduct(new Product(102, "Mouse", 50, 500));
        manager.addProduct(new Product(103, "Keyboard", 30, 1200));

        // Update Product
        manager.updateProduct(102, "Wireless Mouse", 60, 650);

        // Delete Product
        manager.deleteProduct(103);

        // Display Inventory
        manager.displayInventory();
    }
}
