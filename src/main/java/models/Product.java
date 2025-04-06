package models;

import java.time.LocalDate;

public class Product {

    private String name; // The name of the product
    private double price; // The price of the product
    private int quantity; // The available quantity of the product in stock
    private boolean isExpirable; // Flag to check if the product is expirable
    private LocalDate expiryDate; // The expiry date of the product
    private boolean isShippable; // Flag to check if the product requires shipping
    private double weight; // The weight of the product (used for shipping calculation)


    // Parameterized constructor to initialize product attributes
    public Product(String name, double price, int quantity, boolean isExpirable, LocalDate expiryDate, boolean isShippable, double weight) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.isExpirable = isExpirable;
        this.expiryDate = expiryDate;
        this.isShippable = isShippable;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    // Method to decrease the quantity of the product
    public void decreaseQuantity(int amount) {

        // Check if the amount to decrease is more than available quantity
        if (amount > quantity) {
            throw new IllegalArgumentException("Not enough quantity to decrease.");
        }
        this.quantity -= amount;
    }


    public boolean isShippable() {
        return isShippable;
    }

    public double getWeight() {
        return weight;
    }

    public boolean isExpirable() {
        return isExpirable;
    }

    // Method to check if the product is expired (if it has an expiry date)
    public boolean isExpired() {
        return isExpirable && expiryDate != null && LocalDate.now().isAfter(expiryDate);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
