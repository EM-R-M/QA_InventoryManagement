package Inventory.Management.Controller;

import Inventory.Management.DAO.CustomerDAO;
import Inventory.Management.Persistence.Customer;

import java.util.List;
import java.util.Scanner;

public class CustomerController {

    // Empty definition for the controller
    public CustomerController() {}

    // Show the customer menu
    public void customerMenu() {

        CustomerDAO customerService = new CustomerDAO();

        // Display all the options in the customer menu
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\tCUSTOMER MENU:");
        System.out.println("Would you like to:\n" +
                            "\tADD a customer (A)\n" +
                            "\tFIND a customer (F)\n" +
                            "\tUPDATE a customer (U)\n" +
                            "\tDELETE a customer (D)\n" +
                            "\tRETURN to the main menu (R)");
        // get the user's input and perform the corresponding action
        String userInput = scanner.nextLine();
        switch (userInput.toLowerCase().trim()){

            case "a": // CREATE customer
                // Get the user to input the customer's details
                System.out.println("Please input the new customer's details below:");
                System.out.print("\n\t Customer's Name: ");
                String customerName = scanner.nextLine();
                System.out.print("\tCustomer's Email: ");
                String customerEmail = scanner.nextLine();
                // Create the customer object
                Customer newCustomer = new Customer(customerName, customerEmail);
                // Add to the database
                customerService.addCustomer(newCustomer);
                // Prompt for the user to interact in order to continue
                System.out.println("PRESS ENTER TO CONTINUE");
                scanner.nextLine();
                break;

            case "f": // READ customer
                // Get the type of read that the user wants
                System.out.println("Would you like to view ALL customers (A) or an individual (I)?");
                String secondInput = scanner.nextLine();
                if (secondInput.equalsIgnoreCase("A")) { // ALL CUSTOMERS
                    // Get all the known customers from the database
                    List<Customer> allCustomers = customerService.getAllCustomers();
                    System.out.println("ALL CUSTOMERS:");
                    // Loop through all the results and paste them onto the terminal
                    for (Customer customer : allCustomers) {
                        System.out.println("ID:\t" + customer.getCustomerID() + "\nName:\t" + customer.getCustomerName() +
                                            "\nEmail:\t" + customer.getCustomerEmail() + "\n");
                    }
                    // Prompt the user to continue
                    System.out.println("PRESS ENTER TO CONTINUE");
                    scanner.nextLine();
                } else if (secondInput.equalsIgnoreCase("I")){ // INDIVIDUAL CUSTOMER
                    System.out.println("Please input the customer's ID:");
                    // ADD MORE HERE
                    System.out.println("PRESS ENTER TO CONTINUE");
                    scanner.nextLine();
                } else { // INVALID INPUT
                    System.out.println("INVALID INPUT. RETURNING TO MAIN MENU");
                }
                break;

            case "u": // UPDATE customer

                break;

            case "d": // DELETE customer
                break;

            case "r":
                break;

            default:
                // Invalid input so return to the main menu
                System.out.println("INVALID INPUT. PLEASE INPUT A VALID OPTION.");
                break;
        }
    }
}
