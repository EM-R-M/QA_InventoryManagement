package Inventory.Management.Persistence;

import java.sql.*;

public class DatabaseConnection {

    private String jdbcConnectionURL;
    private String username;
    private String password;

    public DatabaseConnection(String jdbcConnectionURL, String username, String password) {
        this.jdbcConnectionURL = jdbcConnectionURL;
        this.username = username;
        this.password = password;
    }

    public Connection connect() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(jdbcConnectionURL, username, password);
    }

}
