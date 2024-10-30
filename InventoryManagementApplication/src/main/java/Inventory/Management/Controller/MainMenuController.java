package Inventory.Management.Controller;

import java.util.Scanner;

public class MainMenuController {

    public void mainMenu(){

        // Create the controller objects
        CustomerController customer = new CustomerController();

        // Define a scanner for getting user inputs
        Scanner scanner = new Scanner(System.in);

        // Boolean to track whether the user is still using the system
        boolean usingSystem = true;

        // While loop maintained until the user no longer wants to continue
        // using the application
        while (usingSystem) {

            // Display the main menu options
            System.out.println("\n\tMAIN MENU:");
            System.out.println("Would you like to view:\n" +
                                "\tOrders (O)\n" +
                                "\tCustomers (C)\n" +
                                "\tProducts (P)\n" +
                                "\tQuit (Q)");
            // Get the user's option selection and go with the
            // corresponding case
            String userInput = scanner.nextLine();
            switch (userInput.toLowerCase().trim()){
                case "o": // Orders Menu
                    //ordersMenu();
                    break;
                case "c": // Customer Menu
                    customer.customerMenu();
                    break;
                case "p": // Product Menu
                    //productsMenu();
                    break;
                case "q": // Quit application
                    usingSystem = false;
                    break;
                default: // Invalid input
                    System.out.println("INVALID INPUT. PLEASE INPUT A VALID OPTION.");
                    break;
            }
        }

        // Thank the user and close the system
        System.out.println("Thank you for using the system, see you again soon.");
        scanner.close();

    }
}
