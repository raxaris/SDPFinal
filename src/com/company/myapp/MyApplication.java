package com.company.myapp;

import com.company.myapp.cars.Car;
import com.company.myapp.controllers.CarController;
import com.company.myapp.controllers.UserController;
import com.company.myapp.user.User;

import java.util.List;
import java.util.Scanner;

public class MyApplication {
    private final CarController carController;
    private final UserController userController;
    private final Scanner scanner;
    private User user;

    public MyApplication(CarController carController, UserController userController) {
        this.carController = carController;
        this.userController = userController;
        scanner = new Scanner(System.in);
    }

    public void start(){
        authenticatorMenu();
        if(user != null) {
            if (user.isAdmin()) {
                startAdminApplication();
            } else {
                startUserApplication();
            }
        }
    }

    public void authenticatorMenu() {
        System.out.println("Login | Sign Up");
        while (true) {
            int option = getMenuInput("Select option:\n1. Login.\n2. Sign up for free.\n0. Exit\nEnter option (1 or 2): ", 2);
            switch (option) {
                case 1:
                    if(loginMenu()) return;
                    break;
                case 2:
                    signUpMenu();
                    break;
                case 0:
                    System.out.println("Exiting the application. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please select a valid option (1 or 2).");
                    break;
            }
        }
    }

    public void startUserApplication() {
        System.out.println("""
                
                Welcome to AliSar Car Company!
                 ─────▄───▄
                ─▄█▄─█▀█▀█─▄█▄
                ▀▀████▄█▄████▀▀
                ─────▀█▀█▀
                """);
        while (true) {
            int option = getMenuInput("Select option:\n1. Create a car\n2. Show showroom\n0. Exit\nEnter option (1 or 2): ", 2);
            switch (option) {
                case 1:
                    createCarMenu();
                    break;
                case 2:
                    showShowroomMenu();
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
    public void startAdminApplication() {

    }
    private void createCarMenu() {
        System.out.println("Creating a new car...");
    }

    private void showShowroomMenu() {
        System.out.println();
        System.out.println("Welcome to the showroom!");
        while (true) {
            printShowRoomMenu();
            int option = getMenuInput("Enter option (0-6): ", 6);

            switch (option) {
                case 1:
                    getAllCarsMenu();
                    break;
                case 2:
                    getCarByIdMenu();
                    break;
                case 3:
                    getCarByPriceMenu();
                    break;
                case 4:
                    getCarByYearMenu();
                    break;
                case 5:
                    getCarByBrandMenu();
                    break;
                case 6:
                    getCarByModelMenu();
                    break;
                case 0:
                    System.out.println("Exiting the showroom.");
                    return;
                default:
                    System.out.println("Invalid option. Please select a valid option (0-6).");
                    break;
            }
            System.out.println("*************************");
        }
    }

    private void printShowRoomMenu() {
        System.out.println();
        System.out.println("Select option:");
        System.out.println("1. Get all cars");
        System.out.println("2. Get car by id");
        System.out.println("3. Get car by price");
        System.out.println("4. Get car by year of production");
        System.out.println("5. Get car by brand");
        System.out.println("6. Get car by model");
        System.out.println("0. Exit");
        System.out.println();
    }

    private void getAllCarsMenu() {
        displayCars(carController.getAllCars());
    }


    private void getCarByIdMenu() {
        int id = getUserInputInt("Please enter id: ");
        String response = carController.getCar(id);
        System.out.println(response);
    }

    private void getCarByPriceMenu() {
        int start = getUserInputInt("Please enter start price: ");
        int end = getUserInputInt("Please enter end price: ");
        displayCars(carController.getCarByPrice(start, end));
    }

    private void getCarByYearMenu() {
        int start = getUserInputInt("Please enter start year: ");
        int end = getUserInputInt("Please enter end year: ");
        displayCars(carController.getCarByYear(start, end));
    }

    private void getCarByBrandMenu() {
        String brand = getUserInputString("Please enter car brand: ");
        displayCars(carController.getCarByBrand(brand));
    }

    private void getCarByModelMenu() {
        String brand = getUserInputString("Please enter car brand: ");
        String model = getUserInputString("Please enter car model: ");
        displayCars(carController.getCarByModel(brand, model));
    }

    private void displayCars(List<Car> cars) {
        if (cars == null || cars.isEmpty()) {
            System.out.println("Cars were not found!");
        } else {
            cars.forEach(car -> System.out.println(car.toString()));
        }
    }

    private int getUserInputInt(String message) {
        System.out.print(message);
        return scanner.nextInt();
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

    private String getUserInputString(String message) {
        System.out.print(message);
        return scanner.next();
    }

    private boolean loginMenu() {
        while (true){
            System.out.print("Please enter your login: ");
            String login = scanner.next();
            System.out.print("Please enter your password: ");
            String password = scanner.next();

            user = userController.getUserCredentials(login, password);
            if (user != null) {
                System.out.println("You successfully logged in!");
                return true;
            } else {
                System.out.println("Incorrect login or password. Try again!");
            }
        }
    }

    private void signUpMenu() {
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

            user = new User(login, password, email, false);

            if (userController.addUser(user)) {
                System.out.println("You signed up successfully!");
                break;
            } else {
                System.out.println("Error. Try again!");
            }
        }
    }
}

