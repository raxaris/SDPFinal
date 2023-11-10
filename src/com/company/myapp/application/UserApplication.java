package com.company.myapp.application;

import com.company.myapp.application.interfaces.IApplicationStrategy;
import com.company.myapp.cars.Car;
import com.company.myapp.controllers.CarController;
import com.company.myapp.user.User;

import java.util.List;
import java.util.Scanner;

public class UserApplication implements IApplicationStrategy{
    private final CarController carController;
    private final Scanner scanner;
    private User user;

    public UserApplication(CarController carController, Scanner scanner, User user) {
        this.carController = carController;
        this.scanner = scanner;
        this.user = user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    @Override
    public void start() {
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

    private void createCarMenu() {
        System.out.println("Creating a new car...");
    }

    private void showShowroomMenu() {
        System.out.println();
        System.out.println("Welcome to the showroom!");
        while (true) {
            printShowRoomMenu();
            int option = getMenuInput("Enter option (0-7): ", 7);

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
                case 7:
                    viewCartMenu();
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
        System.out.println("7. Check cart");
        System.out.println("0. Exit");
        System.out.println();
    }

    private void viewCartMenu(){
        while(true){
            user.getCart().displayCartInfo();
            int option = getMenuInput("\nSelect option:\n1. Add car to cart\n2. Remove car from cart\n3. Clear cart\n0. Exit\nEnter option (1 or 3): ", 3);
            switch (option) {
                case 1:
                    addToCartMenu();
                    break;
                case 2:
                    removeFromCartMenu();
                    break;
                case 3:
                    user.getCart().clearCart();
                    break;
                case 0:
                    System.out.println("Exiting the application. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please select a valid option (1 or 3).");
                    break;
            }
        }
    }

    private void addToCartMenu(){
        int id = getUserInputInt("Please enter the car ID of the car you want to add to the cart: ");
        Car car = carController.getCar(id);

        if (car == null) {
            System.out.println("Car with ID " + id + " was not found!");
        } else {
            user.getCart().addToCart(car);
        }
    }

    private void removeFromCartMenu(){
        int id = getUserInputInt("Please enter the cart item ID of the car you want to remove from the cart: ");
        user.getCart().removeFromCart(id);
    }

    private void getAllCarsMenu() {
        displayCars(carController.getAllCars());
    }


    private void getCarByIdMenu() {
        int id = getUserInputInt("Please enter id: ");
        Car car = carController.getCar(id);
        if(car == null){
            System.out.println("Car was not found!");
        }
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
}