package Inventory.Management;
import Inventory.Management.Controller.*;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to the Inventory Management System!");

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
                    CustomerController.customerMenu();
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
