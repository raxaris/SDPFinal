package com.company.myapp;

import com.company.myapp.cars.Car;
import com.company.myapp.controllers.CarController;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MyApplication {
    private final CarController controller;
    private final Scanner scanner;

    public MyApplication(CarController controller) {
        this.controller = controller;
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            int option = getInitialOption();
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
        displayCars(controller.getAllCars());
    }


    private void getCarByIdMenu() {
        System.out.println("Please enter id: ");
        int id = scanner.nextInt();
        String response = controller.getCar(id);
        System.out.println(response);
    }

    private void getCarByPriceMenu() {
        System.out.println("Please enter price range.");
        System.out.print("Start price: ");
        int start = scanner.nextInt();
        System.out.print("End price: ");
        int end = scanner.nextInt();
        displayCars(controller.getCarByPrice(start, end));
    }

    private void getCarByYearMenu() {
        System.out.println("Please enter year range.");
        System.out.print("Start year: ");
        int start = scanner.nextInt();
        System.out.print("End year: ");
        int end = scanner.nextInt();
        displayCars(controller.getCarByYear(start, end));
    }

    private void getCarByBrandMenu() {
        System.out.print("Please enter car brand: ");
        String brand = scanner.next();
        displayCars(controller.getCarByBrand(brand));
    }

    private void getCarByModelMenu() {
        System.out.print("Please enter car brand: ");
        String brand = scanner.next();
        System.out.print("Please enter car model: ");
        scanner.nextLine();
        String model = scanner.nextLine();
        displayCars(controller.getCarByModel(brand, model));
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
}

