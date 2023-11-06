package com.company.myapp.user;

import com.company.myapp.cars.Car;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Car> cart;
    public Cart(){
        cart = new ArrayList<>();
    }
    public Cart(List<Car> cart) {
        this.cart = cart;
    }
    public void addToCart(Car car){
        cart.add(car);
    }
    public void removeFromCart(int id){
        if (id >= 0 && id < cart.size()) {
            cart.remove(id);
        } else {
            System.out.println("Invalid ID. Please provide a valid index.");
        }
    }
    public void displayCartInfo() {
        System.out.println("Your cart:");
        for (int i = 0; i < cart.size(); i++) {
            Car car = cart.get(i);
            System.out.println("ID: " + i);
            System.out.println(car.toString());
        }
    }
}
