package Warehouse;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Driver to test the functionality of Customer, CustomerIdServer, and CustomersList classes.
 */
public class CustomerTester {
    public static void main(String[] args) {
        // Create a CustomersList instance
        CustomersList customersList = CustomersList.getInstance();

        // Create some customers
        Customer customer1 = new Customer("Alice", "123 Fake St", 11.0);
        Customer customer2 = new Customer("Bob", "456 Blank Ave", 222.0);
        Customer customer3 = new Customer("Charlie", "789 Whatever Rd", 3333.0);

        // Display customer information one by one
        System.out.println("\nDisplaying customers one by one:");
        customer1.display();
        customer2.display();
        customer3.display();

        // Test set functions
        System.out.println("\nTesting set functions:");
        customer1.setName("Mary");
        customer1.setAddress("321 Real St");
        customer1.setBalance(44.0);
        customer1.display();

        // Test get functions
        System.out.println("\nTesting get functions:");
        System.out.println("Customer 1 ID: " + customer1.getId());
        System.out.println("Customer 1 Name: " + customer1.getName());
        System.out.println("Customer 1 Address: " + customer1.getAddress());
        System.out.println("Customer 1 Balance: " + customer1.getBalance());

        // Add customers to the list
        customersList.addCustomer(customer1);
        customersList.addCustomer(customer2);
        customersList.addCustomer(customer3);

        // Display all customers by iterating through the list
        System.out.println("\nCustomer List:");
        for (Customer customer : customersList.getCustomers()) {
            customer.display();
        }

        // Test serialization and deserialization
        System.out.println("\nTesting Serialization and Deserialization:");
        try {
            // Serialize CustomersList
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("customersList.ser"));
            out.writeObject(customersList);
            out.close();

            // Deserialize CustomersList
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("customersList.ser"));
            CustomersList deserializedList = (CustomersList) in.readObject();
            in.close();

            // Display all customers from deserialized list
            System.out.println("\nDisplaying all customers from deserialized list:");
            for (Customer customer : deserializedList.getCustomers()) {
                customer.display();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}