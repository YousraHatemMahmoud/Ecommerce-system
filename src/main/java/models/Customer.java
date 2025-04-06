package models;

public class Customer {

    private String name; // The name of the customer
    private double balance; // The balance available in the customer's account

    // Constructor to initialize the customer's name and balance
    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    // Method to check if the customer has enough balance to make a purchase
    public boolean hasEnoughBalance(double amount) {
        return balance >= amount;
    }

    // Method to deduct a specific amount from the customer's balance
    public void deductBalance(double amount) {
        if(balance >= amount){
            balance -= amount;
        }
        else{
            throw new IllegalArgumentException("Insufficient balance");
        }
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
