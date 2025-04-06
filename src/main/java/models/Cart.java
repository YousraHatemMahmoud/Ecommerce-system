package models;

import java.util.List;

public class Cart {

    private List<CartItem> items; // List to store the cart items

    // Constructor to initialize the cart with a list of cart items
    public Cart(List<CartItem> items) {
        this.items = items;
    }

    public List<CartItem> getItems() {
        return items;
    }

    // Method to add a product to the cart with a specified quantity
    public void addProduct(Product product, int quantity) {

        // Check if the stock has enough quantity of the product
        if(product.getQuantity() < quantity) {
            throw new IllegalArgumentException("Not enough quantity available in stock.");
        }

        // Check if the product is already in the cart
        for (CartItem item : items){
            if(item.getProduct().equals(product)){
                throw new IllegalArgumentException("Product already in cart.");
            }
        }
        // Add the product as a new cart item if the product isn't already in the cart
        items.add(new CartItem(product,quantity));
    }

    // Method to remove a product from the cart
    public void removeProduct(Product product) {
        items.removeIf(item -> item.getProduct().equals(product));
    }

    // Method to calculate the total price of all items in the cart
    public double getTotalPrice() {
        double total = 0.0;

        // Iterate over each cart item and sum up the total price
        for (CartItem item : items){
            total += item.getTotalPrice();
        }
        return total;
    }

    // Method to calculate the total weight of all shippable items in the cart
    public double getTotalWeight() {
        double total = 0.0;

        // Iterate over each cart item and sum up the total weight
        for (CartItem item : items){
            total += item.getTotalWeight();
        }
        return total;
    }

    public boolean isEmpty(){
        return items.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Cart:\n");
        for (CartItem item : items) {
            sb.append("- ").append(item).append("\n");
        }
        sb.append("Total: ").append(getTotalPrice());
        return sb.toString();
    }
}
