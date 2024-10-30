package Inventory.Management.Persistence;

import java.sql.*;

public class DatabaseConnection {

    public Connection connect() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String jdbcConnectionURL = "jdbc:mysql://localhost:3306/inventorymanagement";
        String username = "root";
        String password = "root";

        return DriverManager.getConnection(jdbcConnectionURL, username, password);
    }

}
