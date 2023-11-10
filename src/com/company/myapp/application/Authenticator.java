package com.company.myapp.application;

import com.company.myapp.controllers.UserController;
import com.company.myapp.user.User;

import java.util.Scanner;

public class Authenticator {
    private final UserController userController;
    private final Scanner scanner;

    public Authenticator(UserController userController, Scanner scanner) {
        this.userController = userController;
        this.scanner = scanner;
    }

    public User authenticate() {
        System.out.println("Login | Sign Up");

        while (true) {
            int option = getMenuInput("Select option:\n1. Login.\n2. Sign up for free.\n0. Exit\nEnter option (1 or 2): ", 2);

            switch (option) {
                case 1:
                    return login();
                case 2:
                    return signUp();
                case 0:
                    System.out.println("Exiting the application. Goodbye!");
                    return null;
                default:
                    System.out.println("Invalid option. Please select a valid option (1 or 2).");
                    break;
            }
        }
    }

    private User login() {
        while (true) {
            System.out.print("Please enter your login: ");
            String login = scanner.next();
            System.out.print("Please enter your password: ");
            String password = scanner.next();

            User user = userController.getUserCredentials(login, password);

            if (user != null) {
                System.out.println("You successfully logged in!");
                return user;
            } else {
                System.out.println("Incorrect login or password. Try again!");
            }
        }
    }

    private User signUp() {
        while (true) {
            System.out.print("Please enter login: ");
            String login = scanner.next();

            if (!userController.isLoginAvailable(login)) {
                System.out.println("This login is unavailable");
                continue;
            }

            System.out.print("Please enter password: ");
            String password = scanner.next();
            System.out.print("Please enter e-mail: ");
            String email = scanner.next();

            User user = new User(login, password, email, false);

            if (userController.addUser(user)) {
                System.out.println("You signed up successfully!");
                return user;
            } else {
                System.out.println("Error. Try again!");
            }
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

