package com.company.myapp.application;

import com.company.myapp.application.interfaces.IApplicationStrategy;
import com.company.myapp.cars.Car;
import com.company.myapp.controllers.CarController;
import com.company.myapp.controllers.UserController;
import com.company.myapp.menu.ShowRoom;
import com.company.myapp.user.User;
import com.company.myapp.user.inferfaces.IUser;

import java.util.InputMismatchException;

public class AdminApplication implements IApplicationStrategy {
    private final CarController carController;
    private final UserController userController;
    private User user;
    private final ShowRoom showRoom;

    public AdminApplication(CarController carController, UserController userController, User user) {
        this.carController = carController;
        this.userController = userController;
        this.user = user;
        this.showRoom = new ShowRoom(carController);
    }

    public void setUser(User user) {
        this.user = user;
    }
    @Override
    public void start() {
        System.out.println("""
                
                    ♠♚ \u001B[1mWelcome back Admin.\u001B[1m ♚♠\s
                         
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
            int option = InputUtils.getMenuInput("Select option:\n1. User menu\n2. Showroom menu\n0. Exit\nEnter option (1 or 2): ", 2);
            switch (option) {
                case 1 -> userMenu();
                case 2 -> showRoomMenu();
                case 0 -> {
                    System.out.println("Exiting the application. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option. Please select a valid option (1 or 2).");
            }

            System.out.println("*************************");
        }
    }
    //User Menu
    private void userMenu(){
        while(true) {
            int option = InputUtils.getMenuInput("\nSelect option:\n1. Add user\n2. Delete user\n0. Exit\nEnter option (1 or 2): ", 2);
            switch (option) {
                case 1 -> createUserMenu();
                case 2 -> deleteUserMenu();
                case 0 -> {
                    System.out.println("Exiting the application. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option. Please select a valid option (1 or 2).");
            }
            System.out.println("*************************");
        }
    }
    private void createUserMenu(){
        String login = InputUtils.getUserInputString("Enter user login: ");
        String password = InputUtils.getUserInputString("Enter user password: ");
        String email = InputUtils.getUserInputString("Enter user email: ");

        String option = InputUtils.getUserInputString("Do you want this user to be admin? Y/N: ").toLowerCase();
        boolean isAdmin = false;

        if((option.equals("y")) || (option.equals("n"))){
            isAdmin = option.equals("y");
        } else {
            System.out.println("Invalid choice, assuming N");
        }

        User newUser = new User(login, password, email, isAdmin);
        System.out.println(userController.addUser(newUser) ? "User added successfully!" : "Error, cannot add user." );
    }

    private void deleteUserMenu() {
        try {
            int id = InputUtils.getUserInputInt("Enter car ID");
            boolean isDeleted = userController.removeUserByID(id);

            System.out.println(isDeleted? "User was deleted successfully!" : "Error, cannot delete user." );
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid integer ID.");
        }
    }
    // Show Room Menu
    private void showRoomMenu(){
        System.out.println(" ");
        while(true) {
            int option = InputUtils.getMenuInput("Select option:\n1. Car menu\n2. Showroom manager menu\n0. Exit\nEnter option (1 or 2): ", 2);
            switch (option) {
                case 1 -> carMenu();
                case 2 -> showRoomManagerMenu();
                case 0 -> {
                    System.out.println("Exiting the application. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option. Please select a valid option (1 or 2).");
            }

            System.out.println("*************************");
        }
    }

    private void carMenu(){
        while(true) {
            int option = InputUtils.getMenuInput("\nSelect option:\n1. Add car to showroom\n2. Remove car from showroom\n0. Exit\nEnter option (1 or 2): ", 2);
            switch (option) {
                case 1 -> addCarMenu();
                case 2 -> removeCarMenu();
                case 0 -> {
                    System.out.println("Exiting the application. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option. Please select a valid option (1 or 2).");
            }
            System.out.println("*************************");
        }
    }

    private void addCarMenu(){
        String brand = InputUtils.getUserInputString("Enter car brand: ");
        String model = InputUtils.getUserInputString("Enter car model: ");

        String engineType;
        do {
            engineType = InputUtils.getUserInputString("Enter engine type (ICE or Electro): ");
            if (!engineType.equalsIgnoreCase("ICE") && !engineType.equalsIgnoreCase("Electro")) {
                System.out.println("Invalid engine type. Please enter ICE or Electro.");
            }
        } while (!engineType.equalsIgnoreCase("ICE") && !engineType.equalsIgnoreCase("Electro"));

        String fuel = InputUtils.getUserInputString("Enter engine fuel type: ");
        int torque = InputUtils.getUserInputInt("Enter engine torque: ");
        double volume = InputUtils.getUserInputDouble("Enter engine volume: ");
        int power = InputUtils.getUserInputInt("Enter engine power: ");


        String transmissionType;
        do {
            transmissionType = InputUtils.getUserInputString("Enter transmission type (Auto or Manual): ");
            if (!transmissionType.equalsIgnoreCase("Auto") && !transmissionType.equalsIgnoreCase("Manual")) {
                System.out.println("Invalid transmission type. Please enter Auto or Manual.");
            }
        } while (!transmissionType.equalsIgnoreCase("Auto") && !transmissionType.equalsIgnoreCase("Manual"));

        int gears = InputUtils.getUserInputInt("Enter number of gears: ");
        int yearOfProduction = InputUtils.getUserInputInt("Enter car's year of production: ");
        int price = InputUtils.getUserInputInt("Enter car price: ");
        double VIN = InputUtils.getUserInputDouble("Enter car VIN: ");
        String color = InputUtils.getUserInputString("Enter car color: ");

        Car car = carController.getConfigurator().createCar(0, brand, model, engineType, fuel, torque, volume, power, transmissionType, gears, yearOfProduction, price, VIN, color);
        boolean isAdded = showRoom.addCarToShowRoom(car);
        System.out.println(isAdded ? "Car added successfully!" : "Error, cannot add car." );
    }


    private void removeCarMenu() {
        try {
            int id = InputUtils.getUserInputInt("Enter car ID: ");
            boolean isDeleted = showRoom.removeCarFromShowRoom(id);

            System.out.println(isDeleted? "Car was deleted successfully!":"Error, cannot delete car." );
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid integer ID.");
        }
    }

    //Show Room Manager Menu
    private void showRoomManagerMenu(){
        System.out.println(" ");
        while(true) {
            int option = InputUtils.getMenuInput("Select option:\n1. Add subscriber\n2. Remove subscriber\n3. Display subscribers\n4. Notify subscribers\n0. Exit\nEnter option (1 or 4): ", 4);
            switch (option) {
                case 1 -> addSubMenu();
                case 2 -> removeSubMenu();
                case 3 -> displaySubMenu();
                case 4 -> notifySubMenu();
                case 0 -> {
                    System.out.println("Exiting the application. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option. Please select a valid option (1 or 3).");
            }

            System.out.println("*************************");
        }
    }

    private void addSubMenu(){
        int id = InputUtils.getUserInputInt("User ID: ");
        IUser subscriber = userController.getUser(id);
        if (subscriber != null) {
            boolean status = showRoom.getShowRoomManager().subscribe(subscriber);
            if(status) System.out.println("User was successfully subscribed");
        } else {
            System.out.println("Error: User not found.");
        }
    }

    private void removeSubMenu() {
        int option = InputUtils.getMenuInput("\nSelect option:\n1. Remove by user ID\n2. Remove by subscriber ID\n0. Exit\nEnter option (1 or 2): ", 2);
        switch (option) {
            case 1 -> removeSub();
            case 2 -> removeSubByID();
            case 0 -> {
                System.out.println("Exiting the application. Goodbye!");
                return;
            }
            default -> System.out.println("Invalid option. Please select a valid option (1 or 2).");
        }
    }

    private void removeSub(){
        int id = InputUtils.getUserInputInt("User ID: ");
        User subscriber = userController.getUser(id);
        if (subscriber != null) {
            showRoom.getShowRoomManager().unSubscribe(subscriber);
            System.out.println("User was successfully unsubscribed");
        } else {
            System.out.println("Error: User not found.");
        }
    }

    private void removeSubByID(){
        int id = InputUtils.getUserInputInt("User ID: ");
        showRoom.getShowRoomManager().unSubscribeByID(id);
        System.out.println("User was successfully unsubscribed");
    }



    private void displaySubMenu(){
        showRoom.getShowRoomManager().displaySubscribers();
    }

    private void notifySubMenu(){
        String message = InputUtils.getUserInputLine("Enter a message: ");
        showRoom.getShowRoomManager().notifySubscribers(message);
    }
}
