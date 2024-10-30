package Inventory.Management.DAO;

import Inventory.Management.Persistence.Customer;
import Inventory.Management.Persistence.DatabaseConnection;

import java.sql.Connection;
import java.sql.Statement;

public class CustomerDAO {

    // Variable for database connections
    DatabaseConnection inventoryDatabase = new DatabaseConnection();

    // Add a new customer to the list
    public void addCustomer(Customer newCustomer){
        // Check the customer's name & email is valid before continuing
        if ((!newCustomer.getCustomerName().isEmpty() && checkEmailValid(newCustomer.getCustomerEmail()))) {
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

    // Check whether the email address is a valid address
    private boolean checkEmailValid(String emailAddress){
        String emailRegex = "^[\\p{L}0-9!#$%&'*+/=?^_`{|}~-][\\p{L}0-9.!#$%&'*+/=?^_`{|}~-]{0,63}@[\\p{L}0-9-]+(?:\\.[\\p{L}0-9-]{2,6})+$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(emailRegex);
        java.util.regex.Matcher m = p.matcher(emailAddress);
        System.out.println(m.matches());
        return m.matches();
    }

}
