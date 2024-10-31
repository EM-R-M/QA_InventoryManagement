package Inventory.Management.DAO;

import Inventory.Management.Persistence.Customer;
import Inventory.Management.Persistence.DatabaseConnection;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    // Variable for database connections
    DatabaseConnection inventoryDatabase = new DatabaseConnection();

    public boolean addCustomer(Customer newCustomer){
        // Create the SQL query to add the customer to the database
        String query = "INSERT INTO customers VALUES (customerName, customerEmail) VALUES ('" +
                newCustomer.getCustomerName() + "', '" + newCustomer.getCustomerEmail() + "');";
        // Connect to the database and upload the customer's information
        try (Connection conn = inventoryDatabase.connect()){
            Statement statement = conn.createStatement();
            statement.executeUpdate(query);
            // Inform the user that the new customer has been created
            return true;
        } catch (Exception e) {
            // Failed to add the new customer to the system
            e.printStackTrace();
            System.out.println("\nFailed to add new customer: '" + newCustomer.getCustomerName() + "'.");
            return false;
        }
    }

    public List<Customer> getAllCustomers(){
        List<Customer> allCustomers = new ArrayList<>();
        return allCustomers;
    }

}
