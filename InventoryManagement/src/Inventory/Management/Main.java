package Inventory.Management;
import Inventory.Management.Controller.*;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        MainMenuController main = new MainMenuController();
        System.out.println("Welcome to the Inventory Management System!");
        main.mainMenu();

    }

}
