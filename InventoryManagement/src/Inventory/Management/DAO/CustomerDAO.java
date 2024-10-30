package Inventory.Management.DAO;

import Inventory.Management.Persistence.Customer;
import Inventory.Management.Persistence.DatabaseConnection;

import java.sql.*;

public class CustomerDAO {

    // Variable for database connections
    DatabaseConnection inventoryDatabase = new DatabaseConnection("jdbc:mysql://localhost:3306/inventorymanagement", "root", "root");

    // Add a new customer to the list
    public void addCustomer(Customer newCustomer){
        // Check the customer's name & email is valid before continuing
        if ((!newCustomer.getCustomerName().isBlank() && checkEmailValid(newCustomer.getCustomerEmail()))) {
            // Create the SQL query to add the customer to the database
            String query = "INSERT INTO customers(customerName, customerEmail) VALUES ('" +
                    newCustomer.getCustomerName() + "', '" + newCustomer.getCustomerEmail() + "');";
            // Connect to the database and upload the customer's information
            try (Connection conn = inventoryDatabase.connect()){
                Statement statement = conn.createStatement();
                statement.executeUpdate(query);
                // Inform the user that the new customer has been created
                System.out.println("\nCustomer: '" + newCustomer.getCustomerName() + "' successfully added.\n");
            } catch (Exception e) {
                // Failed to add the new customer to the system
                System.out.println("\nFailed to add new customer: '" + newCustomer.getCustomerName() + "'.");
            }
        } else {
            // Failed to pass basic checks
            System.out.println("\nFailed to add new customer: '" + newCustomer.getCustomerName() + "'.");
            System.out.println("Invalid customer name or email address.\n");
        }
    }


    /* ==================== //
    // CODE REFERENCE START //
    // ==================== */

    // NOTES:
    // Validate email method adapted and taken from: https://www.baeldung.com/java-email-validation-regex

    private boolean checkEmailValid(String emailAddress){
        String emailRegex = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^-]+(?:\\\\.[a-zA-Z0-9_!#$%&’*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\\\.[a-zA-Z0-9-]+)*$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(emailRegex);
        java.util.regex.Matcher m = p.matcher(emailRegex);
        return m.matches();
    }

    /* ================== //
    // CODE REFERENCE END //
    // ================== */

}
