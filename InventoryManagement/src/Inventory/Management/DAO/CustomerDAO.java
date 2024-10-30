package Inventory.Management.DAO;

import Inventory.Management.Persistence.Customer;
import Inventory.Management.Persistence.DatabaseConnection;

import java.sql.*;

public class CustomerDAO {

    // Static  variable for database connections
    DatabaseConnection inventoryDatabase = new DatabaseConnection("jdbc:mysql://localhost:3306/inventorymanagement", "root", "root");

    // Add a new customer to the list
    public void addCustomer(Customer newCustomer){
        String query = "INSERT INTO customers(customerName, customerEmail) VALUES ('" +
                newCustomer.getCustomerName() + "', '" + newCustomer.getCustomerEmail() + "');";
        try (Connection conn = inventoryDatabase.connect();){
            Statement statement = conn.createStatement();
            statement.executeUpdate(query);
            // Inform the user that the new customer has been created
            System.out.println("\nCustomer: '" + newCustomer.getCustomerName() + "' successfully added.\n");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("\nFailed to add new customer: '" + newCustomer.getCustomerName() + "'.\n");
        }

    }

}
