package com.company.myapp.user;

import com.company.myapp.cars.Car;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<Car> cart;
    public Cart(){
        cart = new ArrayList<>();
    }
    public Cart(List<Car> cart) {
        this.cart = cart;
    }
    public boolean addCarToCart(Car car) {
        for (Car existingCar : cart) {
            if (existingCar.getId() == (car.getId())) {
                System.out.println("Car ID: " + car.getId() + " already added to cart!");
                return false;
            }
        }
        cart.add(car);
        return true;
    }
    public void removeFromCart(int id){
        if (id >= 0 && id < cart.size()) {
            cart.remove(id);
        } else {
            System.out.println("Invalid ID. Please provide a valid index.");
        }
    }
    public void displayCartInfo() {
        if (!cart.isEmpty()) {
            System.out.println("\nYour cart:");
            int id = 0;
            for (Car car : cart) {
                System.out.println("Cart ID: " + id++);
                System.out.println(car);
            }
        } else {
            System.out.println("\nYour cart is empty :(");
        }
    }

    public void clearCart(){
        cart.clear();
    }

    public List<Car> getCart(){
        return cart;
    }
}
