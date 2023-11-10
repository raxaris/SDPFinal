package com.company.myapp.application;

import com.company.myapp.application.interfaces.IApplicationStrategy;
import com.company.myapp.controllers.CarController;
import com.company.myapp.menu.ShowRoom;
import com.company.myapp.user.User;

import java.util.Scanner;

public class AdminApplication implements IApplicationStrategy {
    private final CarController carController;
    private final Scanner scanner;
    private User user;
    private ShowRoom showRoom;

    public AdminApplication(CarController carController, Scanner scanner, User user) {
        this.carController = carController;
        this.scanner = scanner;
        this.user = user;
        this.showRoom = new ShowRoom(carController);
    }

    public void setUser(User user) {
        this.user = user;
    }
    @Override
    public void start() {
        System.out.println("""
                
                    ♠♚ \u001B[1mWelcome back Admin.\u001B[1m ♚♠ 
                         
                ░░░░░░░░░░░░░▐█▄▄▄█▌░░░░░░░░░░░░░░░░░░░
                ░░░░░░░░░░░░▄███████▄░░░░░░░░░░░░░░░░░░
                ░░░░░░░░░▄███░▀▀▀▀▀░███▄░░░░░░░░░░░░░░░
                ░░░░░░░░░░▀███████████▀░░░░░░░░░░░░░░░░
                ░░░░░░░░░░░░█░▄▄▄▄▄░█░░░░░░░░░░░░░░░░░░
                ░░░░░░░░░░▄██░▀▀░▀▀░██▄░░░░░░░░░░░░░░░░
                ░░░░░░░░▄█████░░░░░█████▄░░░░░░░░░░░░░░
                ░░░░░░░░░▀█████▄▄▄█████▀░░░░░░░░░░░░░░░
                ░░░░░░░░░░░▀█████████▀░░░░░░░░░░░░░░░░░
                ░░░░░░░░░░░░░▀▀▀▀▀▀▀░░░░░░░░░░░░░░░░░░░
                
                """);
        while (true) {
            int option = getMenuInput("Select option:\n1. Create a car\n2. Show showroom\n0. Exit\nEnter option (1 or 2): ", 2);
            switch (option) {
                case 1:
                    System.out.println("menu1");
                    break;
                case 2:
                    System.out.println("menu2");
                    break;
                case 0:
                    System.out.println("Exiting the application. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please select a valid option (1 or 2).");
                    break;
            }

            System.out.println("*************************");
            System.out.println();
        }
    }

    private int getMenuInput(String message, int maxOption) {
        int option = -1;
        while (true) {
            System.out.print(message);
            if (scanner.hasNextInt()) {
                option = scanner.nextInt();

                if (option >= 0 && option <= maxOption) {
                    break;
                } else {
                    System.out.println("Invalid option. Please select a valid option (0-" + maxOption + ").");
                }
            } else {
                System.out.println("Input must be an integer.");
                scanner.next(); // consume invalid input
            }
        }

        scanner.nextLine(); // cleaning buffer
        return option;
    }

}
