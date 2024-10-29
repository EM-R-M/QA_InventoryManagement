package Inventory.Management.Controller;

import Inventory.Management.DAO.CustomerDAO;

import java.util.Scanner;

public class CustomerController {

    static CustomerDAO customerService = new CustomerDAO();
    public CustomerController() {}

    public void customerMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\tCUSTOMER MENU:");
        System.out.println("""
                Would you like to:\s
                \tADD a customer (A)\s
                \tFIND a customer (F)\s
                \tUPDATE a customer (U)\s
                \tDELETE a customer (D)\s
                \tRETURN to the main menu (R)""");
        String userInput = scanner.nextLine();
        String givenOption;
        switch (userInput.toLowerCase().trim()){

            case "a": // CREATE
                System.out.println("Please input the customer's details below:");
                System.out.print("\n\t Customer's Name: ");
                String customerName = scanner.nextLine();
                System.out.print("\tCustomer's Email: ");
                String customerEmail = scanner.nextLine();
                customerService.addCustomer(customerName, customerEmail);
                System.out.println("\nCustomer: '" + customerName + "' successfully added");
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
                System.out.println("INVALID INPUT. PLEASE INPUT A VALID OPTION.");
                break;
        }
    }
}
