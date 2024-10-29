package Inventory.Management.Service;

import Inventory.Management.Persistence.Customer;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerService {

    private ArrayList<Customer> customerList = new ArrayList<>();

    public void addCustomer(String customerName, String customerEmail){
        Customer newCustomer = new Customer(customerName, customerEmail);
        customerList.add(newCustomer);
    }

}
