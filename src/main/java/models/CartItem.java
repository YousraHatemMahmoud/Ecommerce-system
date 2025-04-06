package models;

public class CartItem {

    private Product product; // The product that is added to the cart
    private int quantity; // The quantity of the product in the cart


    // Constructor to initialize the cart item with a product and quantity
    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    // Method to calculate the total price of the cart item (product price * quantity)
    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }

    // Method to calculate the total weight of the cart item (only for shippable products)
    public double getTotalWeight() {
        if(product.isShippable()){
            return product.getWeight() * quantity;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "product=" + product.getName() +
                ", quantity=" + quantity +
                ", Total-Price= " + getTotalPrice() +
                '}';
    }
}
