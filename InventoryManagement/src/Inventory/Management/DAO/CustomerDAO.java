package Inventory.Management.DAO;

import Inventory.Management.Persistence.Customer;

import java.util.ArrayList;

public class CustomerDAO {

    // List to hold all of the created customers
    private ArrayList<Customer> customerList = new ArrayList<>();

    // Add a new customer to the list
    public void addCustomer(String customerName, String customerEmail){
        Customer newCustomer = new Customer(customerName, customerEmail);
        customerList.add(newCustomer);
    }

}
