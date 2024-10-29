package Inventory.Management.Controller;

import java.util.Scanner;

public class MainMenuController {

    public void mainMenu(){

        CustomerController customer = new CustomerController();

        Scanner scanner = new Scanner(System.in);
        boolean usingSystem = true;

        while (usingSystem) {
            System.out.println("\n\tMAIN MENU:");
            System.out.println("""
                        Would you like to view:\s
                        \tOrders (O)\s
                        \tCustomers (C)\s
                        \tProducts (P)\s
                        \tQuit (Q)""");
            String userInput = scanner.nextLine();
            switch (userInput.toLowerCase().trim()){
                case "o":
                    //ordersMenu();
                    break;
                case "c":
                    customer.customerMenu();
                    break;
                case "p":
                    //productsMenu();
                    break;
                case "q":
                    usingSystem = false;
                    break;
                default:
                    System.out.println("INVALID INPUT. PLEASE INPUT A VALID OPTION.");
                    break;
            }
        }

        System.out.println("Thank you for using the system, see you again soon.");
        scanner.close();
    }
}
