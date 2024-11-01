package Inventory.Management.DAO;

import Inventory.Management.Persistence.Customer;
import Inventory.Management.Persistence.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    // Variable for database connections
    DatabaseConnection inventoryDatabase = new DatabaseConnection();

    public boolean addCustomer(Customer newCustomer){
        // Create the SQL query to add the customer to the database
        String query = "INSERT INTO customers (customerName, customerEmail) VALUES ('" +
                newCustomer.getCustomerName() + "', '" + newCustomer.getCustomerEmail() + "');";
        // Connect to the database and upload the customer's information
        try (Connection conn = inventoryDatabase.connect()){
            Statement statement = conn.createStatement();
            statement.executeUpdate(query);
            // Inform the user that the new customer has been created
            return true;
        } catch (Exception e) {
            // Failed to add the new customer to the system
            System.out.println("\nFailed to add new customer: '" + newCustomer.getCustomerName() + "'.");
            return false;
        }
    }

    public List<Customer> getAllCustomers(){
        List<Customer> allCustomers = new ArrayList<>();
        // Create the SQL query to get all the customers' information
        String query = "SELECT * FROM customers;";
        try (Connection conn = inventoryDatabase.connect()){
            Statement statement = conn.createStatement();
            ResultSet resultData = statement.executeQuery(query);
            while (resultData.next()) {
                Customer foundCustomer = new Customer(resultData.getInt("customerID"), resultData.getString("customerName"), resultData.getString("customerEmail"));
                allCustomers.add(foundCustomer);
            }
            // Inform the user that the new customer has been created
        } catch (Exception e) {
            // Failed to add the new customer to the system
            System.out.println("\nFailed to get the customer data.");
        }
        return allCustomers;
    }

}
