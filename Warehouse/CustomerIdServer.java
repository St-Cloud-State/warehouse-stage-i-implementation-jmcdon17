package Warehouse;

import java.io.*;

/**
 * Singleton class to generate unique customer IDs.
 */
public class CustomerIdServer implements Serializable {
    private static final long serialVersionUID = 1L;
    private int idCounter;
    private static CustomerIdServer server;

    // Private constructor to prevent instantiation
    private CustomerIdServer() {
        idCounter = 1;
    }

    // Method to get the singleton instance of CustomerIdServer
    public static CustomerIdServer getInstance() {
        if (server == null) {
            server = new CustomerIdServer();
        }
        return server;
    }

    // Method to get the next unique ID
    public int getNextId() {
        return idCounter++;
    }

    // Method to serialize the object
    private void writeObject(ObjectOutputStream output) throws IOException {
        output.defaultWriteObject();
        output.writeObject(server);
    }

    // Method to deserialize the object
    private void readObject(ObjectInputStream input) throws IOException, ClassNotFoundException {
        input.defaultReadObject();
        if (server == null) {
            server = (CustomerIdServer) input.readObject();
        } else {
            input.readObject();
        }
    }
}