package com.company.myapp.menu;

import com.company.myapp.cars.Car;
import com.company.myapp.controllers.CarController;
import com.company.myapp.user.User;

import java.util.ArrayList;
import java.util.List;

public class ShowRoom {
    private final CarController controller;
    private List<Car> cars;
    private List<User> users;
    public ShowRoom(CarController controller) {
        this.controller = controller;
        cars = controller.getAllCars();
        users = new ArrayList<>();
    }
    public void subscribe(User user){
        users.add(user);
    }
    public void unsubscribe(User user){
        users.remove(user);
    }
    public void notifySubscribers(String message){
        for (User user: users) {
            user.update(message);
        }
    }
    public void addCar(Car car){
        cars.add(car);
        notifySubscribers("Added: \n" + car.toString());
    }
    public void removeCar(Car car){
        cars.remove(car);
        notifySubscribers("Removed: \n" + car.toString());
    }

}
