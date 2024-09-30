package Warehouse;

import java.io.Serializable;

/**
 * Class representing a customer.
 */
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String address;
    private double balance;

    // Constructor to initialize a new customer
    public Customer(String name, String address, double balance) {
        this.id = CustomerIdServer.getInstance().getNextId();
        this.name = name;
        this.address = address;
        this.balance = balance;
    }

    // Getter for ID
    public int getId() {
        return id;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for address
    public String getAddress() {
        return address;
    }

    // Setter for address
    public void setAddress(String address) {
        this.address = address;
    }

    // Getter for balance
    public double getBalance() {
        return balance;
    }

    // Setter for balance
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Method to display customer information
    public void display() {
        System.out.println("Customer ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Balance: " + balance);
    }
}