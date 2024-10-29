package Inventory.Management.Controller;

import Inventory.Management.DAO.CustomerDAO;

import java.util.Scanner;

public class CustomerController {

    // Create static object for accessing all the data access objects
    static CustomerDAO customerService = new CustomerDAO();

    // Empty definition for the controller
    public CustomerController() {}

    // Show the customer menu
    public void customerMenu() {
        // Display all the options in the customer menu
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\tCUSTOMER MENU:");
        System.out.println("""
                Would you like to:\s
                \tADD a customer (A)\s
                \tFIND a customer (F)\s
                \tUPDATE a customer (U)\s
                \tDELETE a customer (D)\s
                \tRETURN to the main menu (R)""");
        // get the user's input and perform the corresponding action
        String userInput = scanner.nextLine();
        switch (userInput.toLowerCase().trim()){

            case "a": // CREATE customer
                // Get the user to input the customer's details
                System.out.println("Please input the customer's details below:");
                System.out.print("\n\t Customer's Name: ");
                String customerName = scanner.nextLine();
                System.out.print("\tCustomer's Email: ");
                String customerEmail = scanner.nextLine();
                // Create the customer object
                customerService.addCustomer(customerName, customerEmail);
                // Inform the user that the new customer has been created
                System.out.println("\nCustomer: '" + customerName + "' successfully added.\n");
                // Prompt for the user to interact in order to continue
                System.out.println("PRESS ENTER TO CONTINUE");
                scanner.nextLine();
                break;

            case "f": // READ
                break;

            case "u": // UPDATE

                break;

            case "d": // DELETE
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
