package com.company.myapp.application;

import com.company.myapp.controllers.UserController;
import com.company.myapp.user.User;


public class Authenticator {
    private final UserController userController;

    public Authenticator(UserController userController) {
        this.userController = userController;
    }

    public User authenticate() {
        System.out.println("Login | Sign Up");

        while (true) {
            int option = InputUtils.getMenuInput("Select option:\n1. Login.\n2. Sign up for free.\n0. Exit\nEnter option (1 or 2): ", 2);

            switch (option) {
                case 1 -> {
                    return login();
                }
                case 2 -> {
                    return signUp();
                }
                case 0 -> {
                    System.out.println("Exiting the application. Goodbye!");
                    return null;
                }
                default -> System.out.println("Invalid option. Please select a valid option (1 or 2).");
            }
        }
    }

    private User login() {
        User user;

        while(true){
            String login = InputUtils.getUserInputString("Please enter your login: ");
            String password = InputUtils.getUserInputString("Please enter your password: ");

            user = userController.getUserCredentials(login, password);

            if (user != null) {
                System.out.println("You successfully logged in!");
                System.out.println("*******************************");
                return user;
            } else {
                System.out.println("Incorrect login or password. Try again!");
                System.out.println("*******************************");
            }
        }
    }

    private User signUp() {
        while (true) {
            String login = InputUtils.getUserInputString("Please enter login: ");

            while (!userController.isLoginAvailable(login)) {
                System.out.println("This login is unavailable");
                login = InputUtils.getUserInputString("Please enter a different login: ");
            }

            String password = InputUtils.getUserInputString("Please enter password: ");
            String email = InputUtils.getUserInputString("Please enter e-mail: ");

            User user = new User(login, password, email, false);

            if (userController.addUser(user)) {
                System.out.println("You signed up successfully!");
                return user;
            } else {
                System.out.println("Error. Try again!");
            }
            System.out.println("*******************************");
            System.out.println();
        }
    }
}

