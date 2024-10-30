package Inventory.Management;

import Inventory.Management.Controller.MainMenuController;

public class Main {

    public static void main(String[] args) {

        // Create the main menu controller
        MainMenuController main = new MainMenuController();
        // Greet the user
        System.out.println("Welcome to the Inventory Management System!");
        // Run the main menu
        main.mainMenu();

    }

}
