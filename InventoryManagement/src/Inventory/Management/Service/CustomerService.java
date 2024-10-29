package Inventory.Management.Service;

import Inventory.Management.Persistence.Customer;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerService {

    private static ArrayList<Customer> customerList = new ArrayList<>();

    public static void addCustomer(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input the customer's details below:");
        System.out.print("\n\t Customer's Name: ");
        String customerName = scanner.nextLine();
        System.out.print("\tCustomer's Email: ");
        String customerEmail = scanner.nextLine();
        Customer newCustomer = new Customer(customerName, customerEmail);
        customerList.add(newCustomer);
        System.out.println("Customer: '" + customerName + "' successfully added");
        System.out.println("PRESS ENTER TO CONTINUE");
        scanner.nextLine();
    }

}
