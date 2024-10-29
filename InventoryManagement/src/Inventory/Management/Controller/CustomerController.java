package Inventory.Management.Controller;

import java.util.Scanner;

public class CustomerController {

    public CustomerController() {}

    public static void customerMenu() {
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
