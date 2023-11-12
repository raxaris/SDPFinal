package com.company.myapp.application;

import com.company.myapp.application.interfaces.IApplicationStrategy;
import com.company.myapp.cars.Car;
import com.company.myapp.controllers.CarController;
import com.company.myapp.user.Cart;
import com.company.myapp.user.User;
import java.util.List;

public class UserApplication implements IApplicationStrategy{
    private final CarController carController;
    private User user;

    public UserApplication(CarController carController, User user) {
        this.carController = carController;
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
            int option = InputUtils.getMenuInput("Select option:\n1. Create a car\n2. Show showroom\n0. Exit\nEnter option (1 or 2): ", 2);
            switch (option) {
                case 1 -> createCarMenu();
                case 2 -> showShowroomMenu();
                case 0 -> {
                    System.out.println("Exiting the application. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option. Please select a valid option (1 or 2).");
            }

            System.out.println("*************************");
        }
    }

    private void createCarMenu() {
        System.out.println("Creating a new car...");
    }
    //Show Room Menu
    private void showShowroomMenu() {
        System.out.println();
        System.out.println("Welcome to the showroom!");
        while (true) {
            printShowRoomMenu();
            int option = InputUtils.getMenuInput("Enter option (0-7): ", 7);

            switch (option) {
                case 1 -> getAllCarsMenu();
                case 2 -> getCarByIdMenu();
                case 3 -> getCarByPriceMenu();
                case 4 -> getCarByYearMenu();
                case 5 -> getCarByBrandMenu();
                case 6 -> getCarByModelMenu();
                case 7 -> viewCartMenu();
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
        System.out.println("7. Check cart");
        System.out.println("0. Exit");
    }

    private void viewCartMenu(){
        while(true){
            user.getCart().displayCartInfo();
            int option = InputUtils.getMenuInput("Select option:\n1. Add car to cart\n2. Remove car from cart\n3. Clear cart\n0. Exit\nEnter option (1 or 3): ", 3);
            switch (option) {
                case 1 -> addToCartMenu();
                case 2 -> removeFromCartMenu();
                case 3 -> user.getCart().clearCart();
                case 0 -> {
                    System.out.println("Exiting the application. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option. Please select a valid option (1 or 3).");
            }
            System.out.println("*************************");
        }
    }

    private void addToCartMenu(){
        int id = InputUtils.getUserInputInt("Please enter the car ID of the car you want to add to the cart: ");
        Car car = carController.getCar(id);

        if (car == null) {
            System.out.println("Car with ID " + id + " was not found!");
        } else {
            user.getCart().addToCart(car);
        }
    }

    private void removeFromCartMenu(){
        int id = InputUtils.getUserInputInt("Please enter the cart item ID of the car you want to remove from the cart: ");
        Cart cart = user.getCart();

        if(cart.getCart().get(id) == null) {
            System.out.println("No cart item with ID " + id);
        } else {
            cart.removeFromCart(id);
            System.out.println("Car with ID " + id + " successfully removed from the cart.");
        }
    }

    private void getAllCarsMenu() {
        displayCars(carController.getAllCars());
    }


    private void getCarByIdMenu() {
        int id = InputUtils.getUserInputInt("Please enter id: ");
        Car car = carController.getCar(id);
        if(car == null){
            System.out.println("Car was not found!");
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
        String model = InputUtils.getUserInputString("Please enter car model: ");
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