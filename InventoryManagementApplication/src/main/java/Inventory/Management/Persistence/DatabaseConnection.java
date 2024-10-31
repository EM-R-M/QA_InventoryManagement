package Inventory.Management.Persistence;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {

    private String classForName;
    private String jdbcConnectionURL;
    private String username;
    private String password;

    public DatabaseConnection() {
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String appConfigPath = rootPath + "application.properties";

        Properties appProps = new Properties();
        try {
            appProps.load(new FileInputStream(appConfigPath));
            if (appProps.getProperty("activeEnvironment").equals("dev")){
                this.classForName="org.h2.Driver";
                this.jdbcConnectionURL = "jdbc:h2:mem:test";
                this.username="sa";
                this.password="";
            }
            if (appProps.getProperty("activeEnvironment").equals("prod")){
                this.classForName = "com.mysql.cj.jdbc.Driver";
                this.jdbcConnectionURL = "jdbc:mysql://localhost:3306/inventorymanagement";
                this.username = "root";
                this.password = "root";
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public Connection connect() throws SQLException, ClassNotFoundException, IOException {
        Class.forName(classForName);
        return DriverManager.getConnection(jdbcConnectionURL, username, password);
    }

}
