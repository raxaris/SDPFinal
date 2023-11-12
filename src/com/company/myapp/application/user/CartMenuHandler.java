package com.company.myapp.application.user;

import com.company.myapp.application.InputUtils;
import com.company.myapp.cars.Car;
import com.company.myapp.controllers.CarController;
import com.company.myapp.user.Cart;

public class CartMenuHandler {
    private final Cart userCart;
    private final CarController carController;
    public CartMenuHandler(Cart userCart, CarController carController) {
        this.userCart = userCart;
        this.carController = carController;
    }

    public void processCartMenu() {
        while (true) {
            showCartMenu();

            int option = InputUtils.getMenuInput("\nSelect option:\n1. Add car to cart\n2. Remove car from cart\n3. Clear cart\n4. Cart information\n0. Exit\nEnter option (1-4): ", 4);

            switch (option) {
                case 1 -> addToCartMenu();
                case 2 -> removeFromCartMenu();
                case 3 -> clearCartMenu();
                case 4 -> showCartMenu();
                case 0 -> {
                    System.out.println("Exiting the cart menu.");
                    return;
                }
                default -> System.out.println("Invalid option. Please select a valid option (1-3).");
            }
            System.out.println("*************************");
        }
    }

    private void addToCartMenu() {
        int id = InputUtils.getUserInputInt("Please enter the car ID of the car you want to add to the cart: ");
        Car car = carController.getCar(id);

        if (car != null) {
            boolean status = userCart.addCarToCart(car);
            if (status) System.out.println("Car added to the cart successfully!");
        } else {
            System.out.println("Car with ID: " + id + " was not found!.");
        }
    }

    private void removeFromCartMenu() {
        int id = InputUtils.getUserInputInt("Please enter the cart item ID of the car you want to remove from the cart: ");
        userCart.removeFromCart(id);
    }

    private void clearCartMenu() {
        userCart.clearCart();
        System.out.println("Cart cleared successfully!");
    }

    private void showCartMenu(){
        userCart.displayCartInfo();
    }
}
