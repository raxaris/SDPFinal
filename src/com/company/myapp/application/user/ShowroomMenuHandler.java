package com.company.myapp.application.user;

import com.company.myapp.application.InputUtils;
import com.company.myapp.cars.Car;
import com.company.myapp.controllers.CarController;
import java.util.List;

public class ShowroomMenuHandler {
    private final CarController carController;

    public ShowroomMenuHandler(CarController carController) {
        this.carController = carController;
    }

    public void processShowroomMenu() {
        System.out.println();
        System.out.println("Welcome to the showroom!");
        while (true) {
            printShowRoomMenu();
            int option = InputUtils.getMenuInput("Enter option (0-6): ", 6);

            switch (option) {
                case 1 -> getAllCarsMenu();
                case 2 -> getCarByIdMenu();
                case 3 -> getCarByPriceMenu();
                case 4 -> getCarByYearMenu();
                case 5 -> getCarByBrandMenu();
                case 6 -> getCarByModelMenu();
                case 0 -> {
                    System.out.println("Exiting the showroom.");
                    return;
                }
                default -> System.out.println("Invalid option. Please select a valid option (0-6).");
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
    }


    private void getAllCarsMenu() {
        displayCars(carController.getAllCars());
    }

    private void getCarByIdMenu() {
        int id = InputUtils.getUserInputInt("Please enter id: ");
        Car car = carController.getCar(id);
        if (car == null) {
            System.out.println("Car was not found!");
        } else {
            System.out.println(car);
        }
    }

    private void getCarByPriceMenu() {
        int start = InputUtils.getUserInputInt("Please enter start price: ");
        int end = InputUtils.getUserInputInt("Please enter end price: ");
        displayCars(carController.getCarByPrice(start, end));
    }

    private void getCarByYearMenu() {
        int start = InputUtils.getUserInputInt("Please enter start year: ");
        int end = InputUtils.getUserInputInt("Please enter end year: ");
        displayCars(carController.getCarByYear(start, end));
    }

    private void getCarByBrandMenu() {
        String brand = InputUtils.getUserInputString("Please enter car brand: ");
        displayCars(carController.getCarByBrand(brand));
    }

    private void getCarByModelMenu() {
        String brand = InputUtils.getUserInputString("Please enter car brand: ");
        String model = InputUtils.getUserInputLine("Please enter car model: ");
        displayCars(carController.getCarByModel(brand, model));
    }

    private void displayCars(List<Car> cars) {
        if (cars == null || cars.isEmpty()) {
            System.out.println("Cars were not found!");
        } else {
            cars.forEach(car -> System.out.println(car.toString()));
        }
    }
}
