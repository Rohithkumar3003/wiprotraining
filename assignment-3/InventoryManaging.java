package com.oop;

import java.util.ArrayList;
import java.util.List;

interface SupplierOperations {
    void addProduct(Productt product);
    void updateProduct(String productId, int quantity);
    void removeProduct(String productId);
    List<Productt> getProducts();
}
class Productt {
    private String productId;
    private String name;
    private double price;
    private int stockQuantity;
    public Productt(String productId, String name, double price, int stockQuantity) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }
    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }
    public void updateStock(int quantity) {
        this.stockQuantity += quantity;
    }
    @Override
    public String toString() {
        return "Productt[ID=" + productId + ", name=" + name + ", price=" + price + ", stock=" + stockQuantity + "]";
    }
}
class Supplier implements SupplierOperations {
    private String supplierName;
    private List<Productt> productList;
    public Supplier(String supplierName) {
        this.supplierName = supplierName;
        this.productList = new ArrayList<>();
    }
    public String getSupplierName() {
        return supplierName;
    }
    @Override
    public void addProduct(Productt product) {
        if (product.getPrice() < 0 || product.getStockQuantity() < 0) {
            System.out.println("Error: Price and stock quantity cannot be negative.");
            return;
        }
        productList.add(product);
    }

    @Override
    public void updateProduct(String productId, int quantity) {
        for (Productt p : productList) {
            if (p.getProductId().equals(productId)) {
                if (quantity < 0 && p.getStockQuantity() + quantity < 0) {
                    System.out.println("Error: Insufficient stock to remove " + Math.abs(quantity) + " units.");
                    return;
                }
                p.updateStock(quantity);
                return;
            }
        }
        System.out.println("Product not found in inventory.");
    }

    @Override
    public void removeProduct(String productId) {
        productList.removeIf(p -> p.getProductId().equals(productId));
    }

    @Override
    public List<Productt> getProducts() {
        return productList;
    }
}
class Inventory {
    private List<Supplier> suppliers;

    // Constructor to initialize the inventory
    public Inventory() {
        suppliers = new ArrayList<>();
    }
    public void addSupplier(Supplier supplier) {
        suppliers.add(supplier);
    }
    public void displayLowStockAlerts(int threshold) {
        for (Supplier supplier : suppliers) {
            for (Productt product : supplier.getProducts()) {
                if (product.getStockQuantity() < threshold) {
                    System.out.println("Low stock alert! Product: " + product.getName() +
                            ", Stock: " + product.getStockQuantity() + " (Threshold: " + threshold + ")");
                }
            }
        }
    }
    public void displayInventory() {
        for (Supplier supplier : suppliers) {
            System.out.println("Supplier: " + supplier.getSupplierName());
            for (Productt product : supplier.getProducts()) {
                System.out.println("  " + product);
            }
        }
    }
}

public class InventoryManaging {

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Supplier supplier1 = new Supplier("Supplier1");
        Supplier supplier2 = new Supplier("Supplier2");
        Productt product1 = new Productt("P1", "Laptop", 800.00, 50);
        Productt product2 = new Productt("P2", "Headphones", 100.00, 30);
        Productt product3 = new Productt("P3", "Smartphone", 500.00, 10);
        Productt product4 = new Productt("P4", "Keyboard", 50.00, 5);
        supplier1.addProduct(product1);
        supplier1.addProduct(product2);
        supplier2.addProduct(product3);
        supplier2.addProduct(product4);
        inventory.addSupplier(supplier1);
        inventory.addSupplier(supplier2);
        System.out.println("Current Inventory:");
        inventory.displayInventory();
        System.out.println("\nLow Stock Alerts:");
        inventory.displayLowStockAlerts(10);
        System.out.println("\nUpdating stock for Laptop (added 20 units):");
        supplier1.updateProduct("P1", 20); 
        inventory.displayInventory();
        System.out.println("\nRemoving product 'Keyboard' from Supplier2:");
        supplier2.removeProduct("P4");
        inventory.displayInventory();
    }
}
