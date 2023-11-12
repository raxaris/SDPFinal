package com.company.myapp.application.admin;

import com.company.myapp.application.InputUtils;
import com.company.myapp.controllers.UserController;
import com.company.myapp.user.User;
import java.util.InputMismatchException;

public class UserMenuHandler {

    private final UserController userController;

    public UserMenuHandler(UserController userController) {
        this.userController = userController;
    }

    public void processUserMenu() {
        while (true) {
            int option = InputUtils.getMenuInput("\nSelect option:\n1. Add user\n2. Delete user\n0. Exit\nEnter option (1 or 2): ", 2);
            switch (option) {
                case 1 -> createUserMenu();
                case 2 -> deleteUserMenu();
                case 0 -> {
                    System.out.println("Exiting the user menu. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option. Please select a valid option (1 or 2).");
            }
            System.out.println("*************************");
        }
    }

    private void createUserMenu() {
        String login = InputUtils.getUserInputString("Enter user login: ");

        while (!userController.isLoginAvailable(login)) {
            System.out.println("This login is unavailable");
            login = InputUtils.getUserInputString("Please enter a different login: ");
        }

        String password = InputUtils.getUserInputString("Enter user password: ");
        String email = InputUtils.getUserInputString("Enter user email: ");

        String option = InputUtils.getUserInputString("Do you want this user to be admin? Y/N: ").toLowerCase();
        boolean isAdmin = false;

        if ((option.equals("y")) || (option.equals("n"))) {
            isAdmin = option.equals("y");
        } else {
            System.out.println("Invalid choice, assuming N");
        }

        User newUser = new User(login, password, email, isAdmin);
        System.out.println(userController.addUser(newUser) ? "User login: " + login + " added successfully!" : "Error, cannot add user.");
    }

    private void deleteUserMenu() {
        try {
            int id = InputUtils.getUserInputInt("Enter user ID: ");
            boolean isDeleted = userController.removeUserByID(id);

            System.out.println(isDeleted ? "User ID: " + id + " was deleted successfully!" : "Error, cannot delete user.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid integer ID.");
        }
    }
}

