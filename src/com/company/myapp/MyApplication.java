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

    }

    public void authenticatorMenu() {
        System.out.println("Login | Sign Up");
        while (true) {
            int option = getInitialOption();
            switch (option) {
                case 1:
                    loginMenu();
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
        System.out.println("\n \n \nWelcome to AliSar Car Company!" +
                "\n ─────▄───▄ \n" +
                "─▄█▄─█▀█▀█─▄█▄\n" +
                "▀▀████▄█▄████▀▀\n" +
                "─────▀█▀█▀\n");
        while (true) {
            int option = getSecondOption();
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

    private int getInitialOption() {
        System.out.println("Select option:");
        System.out.println("1. Login.");
        System.out.println("2. Sign up for free.");
        System.out.println("0. Exit");
        System.out.print("Enter option (1 or 2): ");

        int option = -1;
        while (option != 1 && option != 2 && option !=0) {
            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                scanner.nextLine(); //cleaning buffer
            } else {
                System.out.println("Input must be an integer.");
                scanner.nextLine(); //cleaning buffer
            }
        }
        return option;
    }

    private int getSecondOption() {
        System.out.println("Select option:");
        System.out.println("1. Create a car");
        System.out.println("2. Show showroom");
        System.out.println("0. Exit");
        System.out.print("Enter option (1 or 2): ");

        int option = -1;
        while (option != 1 && option != 2 && option !=0) {
            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                scanner.nextLine(); //cleaning buffer
            } else {
                System.out.println("Input must be an integer.");
                scanner.nextLine(); //cleaning buffer
            }
        }
        return option;
    }

    private void createCarMenu() {
        System.out.println("Creating a new car...");
    }

    private void showShowroomMenu() {
        System.out.println();
        System.out.println("Welcome to the showroom!");
        while (true) {
            printShowRoomMenu();
            int option = getUserShowRoomOption();

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

    private int getUserShowRoomOption() {
        int option = -1;
        while (option < 0 || option > 6) {
            System.out.print("Enter option (0-6): ");
            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Input must be an integer.");
                scanner.nextLine();
            }
        }
        return option;
    }

    private void getAllCarsMenu() {
        displayCars(carController.getAllCars());
    }


    private void getCarByIdMenu() {
        System.out.println("Please enter id: ");
        int id = scanner.nextInt();
        String response = carController.getCar(id);
        System.out.println(response);
    }

    private void getCarByPriceMenu() {
        System.out.println("Please enter price range.");
        System.out.print("Start price: ");
        int start = scanner.nextInt();
        System.out.print("End price: ");
        int end = scanner.nextInt();
        displayCars(carController.getCarByPrice(start, end));
    }

    private void getCarByYearMenu() {
        System.out.println("Please enter year range.");
        System.out.print("Start year: ");
        int start = scanner.nextInt();
        System.out.print("End year: ");
        int end = scanner.nextInt();
        displayCars(carController.getCarByYear(start, end));
    }

    private void getCarByBrandMenu() {
        System.out.print("Please enter car brand: ");
        String brand = scanner.next();
        displayCars(carController.getCarByBrand(brand));
    }

    private void getCarByModelMenu() {
        System.out.print("Please enter car brand: ");
        String brand = scanner.next();
        System.out.print("Please enter car model: ");
        scanner.nextLine();
        String model = scanner.nextLine();
        displayCars(carController.getCarByModel(brand, model));
    }
    private void displayCars(List<Car> cars) {
        if (cars == null || cars.isEmpty()) {
            System.out.println("Cars were not found!");
        } else {
            for (Car car : cars) {
                System.out.println(car.toString());
            }
        }
    }

    private void loginMenu() {
        System.out.print("Please enter your login: ");
        String login = scanner.next();
        System.out.print("Please enter your password: ");
        String password = scanner.nextLine();
        user = userController.getUserCredentials(login, password);
        if (user != null) {
            System.out.println("You successfully logged in!");
        } else {
            System.out.println("Incorrect login or password. Try again!");
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
            } else {
                System.out.println("Error. Try again!");
            }
            break;
        }
    }
}

