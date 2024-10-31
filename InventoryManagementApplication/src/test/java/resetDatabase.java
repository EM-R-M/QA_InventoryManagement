import Inventory.Management.Persistence.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class resetDatabase {

    DatabaseConnection inventoryDatabase = new DatabaseConnection();

    public void reset(){

        // Add code in here to reset the database in between testing to ensure consistent results

        // Create sql queries
        String createTables = "DROP TABLE IF EXISTS customers; " +
                "CREATE TABLE customers (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(255), " +
                "email VARCHAR(255)); ";
        String insertData = "INSERT INTO customers (name, email) VALUES (?, ?);";

        // Connect to the database and upload the customer's information
        try (Connection conn = inventoryDatabase.connect();){

            // Execute sql queries

            Statement statement = conn.createStatement();
            statement.executeUpdate(createTables);

            PreparedStatement stmt = conn.prepareStatement(insertData);

            stmt.setString(1, "Emily");
            stmt.setString(2, "emily@email.com");
            stmt.executeUpdate();

            stmt.setString(1, "John");
            stmt.setString(2, "john@email.com");
            stmt.executeUpdate();

            stmt.setString(1, "Anna");
            stmt.setString(2, "anna@email.com");
            stmt.executeUpdate();

            conn.commit();

        } catch (Exception e) {

            // Failed to add the new customer to the system
            System.out.println("\nFailed to reset the database. Expect failure in tests.");
        }
    }
}
