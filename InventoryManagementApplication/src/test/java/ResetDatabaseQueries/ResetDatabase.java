package ResetDatabaseQueries;

import Inventory.Management.Persistence.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class ResetDatabase {

    DatabaseConnection inventoryDatabase;

    public ResetDatabase(DatabaseConnection database){
        this.inventoryDatabase = database;
    }

    public void reset(){

        // Add code in here to reset the database in between testing to ensure consistent results

        // Create sql queries
        String removeTables = "DROP TABLE IF EXISTS customers;";
        String createTables = "CREATE TABLE IF NOT EXISTS customers (" +
                                "customerID INT AUTO_INCREMENT PRIMARY KEY, " +
                                "customerName VARCHAR(255), " +
                                "customerEmail VARCHAR(255)); ";
        String insertData = "INSERT INTO customers (customerName, customerEmail) VALUES " +
                                "('Emily', 'emily@email.com'), " +
                                "('John', 'john@email.com'), " +
                                "('Joe', 'joe@email.com');";

        // Connect to the database and upload the customer's information
        try (Connection conn = inventoryDatabase.connect();){

            // Execute sql queries

            // Delete table (if exists)
            Statement statement1 = conn.createStatement();
            statement1.execute(removeTables);

            // Add table into database
            Statement statement2 = conn.createStatement();
            statement2.execute(createTables);

            // Add information into the table
            Statement statement3 = conn.createStatement();
            statement3.execute(insertData);

            conn.commit();

        } catch (Exception e) {

            // Failed to add the new customer to the system
            System.out.println("\nFailed to reset the database. Expect failure in tests.");
        }
    }
}
