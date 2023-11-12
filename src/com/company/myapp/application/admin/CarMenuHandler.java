package com.company.myapp.application.admin;

import com.company.myapp.controllers.CarController;
import com.company.myapp.application.InputUtils;
import com.company.myapp.cars.Car;
import com.company.myapp.menu.Showroom;

import java.util.InputMismatchException;

public class CarMenuHandler {

    private final CarController carController;
    private final Showroom showRoom;

    public CarMenuHandler(CarController carController) {
        this.carController = carController;
        this.showRoom = new Showroom(carController);
    }

    public void processCarMenu() {
        while (true) {
            int option = InputUtils.getMenuInput("\nSelect option:\n1. Add car to showroom\n2. Remove car from showroom\n0. Exit\nEnter option (1 or 2): ", 2);

            switch (option) {
                case 1 -> addCarMenu();
                case 2 -> removeCarMenu();
                case 0 -> {
                    System.out.println("Exiting the car menu. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option. Please select a valid option (1 or 2).");
            }
            System.out.println("*************************");
        }
    }

    private void addCarMenu() {
        String brand = InputUtils.getUserInputString("Enter car brand: ");
        InputUtils.clearScannerBuffer();
        String model = InputUtils.getUserInputLine("Enter car model: ");

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
        boolean isAdded = showRoom.addCarToShowroom(car);
        System.out.println(isAdded ? brand + " " + model + " added successfully!" : "Error, cannot add car.");
    }

    private void removeCarMenu() {
        try {
            int id = InputUtils.getUserInputInt("Enter car ID: ");
            boolean isDeleted = showRoom.removeCarFromShowroom(id);

            System.out.println(isDeleted ? "Car ID: " + id + " was deleted successfully!" : "Error, cannot delete car.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid integer ID.");
        }
    }
}

