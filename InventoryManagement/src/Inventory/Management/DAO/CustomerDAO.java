package Inventory.Management.DAO;

import Inventory.Management.Persistence.Customer;

import java.util.ArrayList;

public class CustomerDAO {

    private ArrayList<Customer> customerList = new ArrayList<>();

    public void addCustomer(String customerName, String customerEmail){
        Customer newCustomer = new Customer(customerName, customerEmail);
        customerList.add(newCustomer);
    }

}
