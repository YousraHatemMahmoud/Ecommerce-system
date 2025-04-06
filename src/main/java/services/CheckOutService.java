package services;

import models.Cart;
import models.CartItem;
import models.Customer;
import models.Product;
import java.util.Set;
import java.util.HashSet;


public class CheckOutService {

    private static final double SHIPPING_PRICE = 5.0; // for 1 KG

    public static void checkout(Customer customer, Cart cart){
        if(cart.isEmpty()){
            System.out.println("Cart is Empty");
            return;
        }

        double totalPrice = 0.0;
        double totalWeight = 0.0;
        Set<Product> shippableProducts = new HashSet<>();

        for (CartItem item : cart.getItems()){
            Product product = item.getProduct();

            // Check stock
            if(product.getQuantity() < item.getQuantity()){
                System.out.println("Not enough stock for: " + product.getName());
                return;
            }

            // Check for expiry
            if(product.isExpirable() && product.isExpired()){
                System.out.println("Product expired: " + product.getName());
                return;
            }

            totalPrice += item.getTotalPrice();

            if (product.isShippable()) {
                totalWeight += item.getTotalWeight();
                shippableProducts.add(product);
            }
        }

        double shippingCost = totalWeight * SHIPPING_PRICE;
        double finalPrice = totalPrice + shippingCost;

        if (!customer.hasEnoughBalance(finalPrice)) {
            System.out.println("Insufficient balance for the transaction.");
            return;
        }

        // Deduct balance and update stock
        customer.deductBalance(finalPrice);
        for (CartItem item : cart.getItems()) {
            item.getProduct().decreaseQuantity(item.getQuantity());
        }

        ShippingService.shipProducts(cart.getItems());

        System.out.println("\n** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.println(item.getQuantity() + "x " + item.getProduct().getName() + " " + item.getTotalPrice() + " EGP");
        }

        System.out.println("----------------------");
        System.out.println("Subtotal " + totalPrice + " EGP");
        System.out.println("Shipping " + shippingCost + " EGP");
        System.out.println("Amount " + finalPrice + " EGP");
        System.out.println("Remaining balance: " + customer.getBalance() + " EGP");
        System.out.println("================");

    }
}
