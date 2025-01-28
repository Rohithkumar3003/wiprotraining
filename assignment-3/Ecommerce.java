package com.oop;

import java.io.*;
import java.util.*;

// Class to represent a product
class Product {
    int id;
    String name;
    double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product ID: " + id + ", Name: " + name + ", Price: $" + price;
    }
}

// Class to represent a customer
class Customerr {
    int id;
    private String name;

    public Customerr(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Customer ID: " + id + ", Name: " + name;
    }
}

// Class to represent an order
class Order {
    int orderId;
    Customer customer;
    List<Product> products;

    public Order(int orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public double calculateTotalCost() {
        double total = 0;
        for (Product product : products) {
            total += product.price;
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order ID: ").append(orderId).append(", Customer: ").append(customer.getName()).append("\nProducts: \n");
        for (Product product : products) {
            sb.append("  ").append(product.toString()).append("\n");
        }
        sb.append("Total Cost: $").append(calculateTotalCost());
        return sb.toString();
    }
}

// Main class for e-commerce management
public class Ecommerce {
    private static List<Product> productList = new ArrayList<>();
    private static List<Order> orderList = new ArrayList<>();
    private static int orderCounter = 1;

    public static void addProduct(Product product) {
        productList.add(product);
        System.out.println("Product added: " + product);
    }

    public static void removeProduct(int productId) {
        productList.removeIf(product -> product.id == productId);
        System.out.println("Product with ID " + productId + " removed.");
    }

    public static void createOrder(Customer customer, List<Integer> productIds) {
        Order order = new Order(orderCounter++, customer);
        for (int productId : productIds) {
            productList.stream()
                      .filter(product -> product.id == productId)
                      .findFirst()
                      .ifPresent(order::addProduct);
        }
        orderList.add(order);
        saveOrderToFile(order);
        System.out.println("Order created:\n" + order);
    }

    public static void saveOrderToFile(Order order) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("order_history.txt", true))) {
            writer.write(order.toString());
            writer.newLine();
            writer.write("------------------------------------\n");
        } catch (IOException e) {
            System.out.println("Error saving order: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Customer customer1 = new Customer(1, "Kiran");
        Customer customer2 = new Customer(2, "Madhu");

        Product product1 = new Product(1, "Laptop", 1200.50);
        Product product2 = new Product(2, "Phone", 800.75);
        Product product3 = new Product(3, "Headphones", 150.00);

        addProduct(product1);
        addProduct(product2);
        addProduct(product3);

        createOrder(customer1, Arrays.asList(1, 3));
        createOrder(customer2, Arrays.asList(2));

        removeProduct(3);
    }
}
