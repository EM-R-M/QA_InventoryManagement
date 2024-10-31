package Inventory.Management.DAO;

import Inventory.Management.Persistence.Customer;
import Inventory.Management.Persistence.DatabaseConnection;

import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    // Variable for database connections
    DatabaseConnection inventoryDatabase = new DatabaseConnection();

    public void addCustomer(Customer customer){

    }

    public List<Customer> getAllCustomers(){
        List<Customer> allCustomers = new ArrayList<>();
        return allCustomers;
    }

}
