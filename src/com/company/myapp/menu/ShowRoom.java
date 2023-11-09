package com.company.myapp.menu;

import com.company.myapp.cars.Car;
import com.company.myapp.controllers.CarController;
import com.company.myapp.user.User;
import com.company.myapp.user.inferfaces.IPublisher;
import com.company.myapp.user.inferfaces.IUser;

import java.util.ArrayList;
import java.util.List;

public class ShowRoom {
    private final CarController controller;
    private final IPublisher carManager;
    private final List<Car> cars;
    public ShowRoom(CarController controller, IPublisher carManager) {
        this.controller = controller;
        cars = controller.getAllCars();
        this.carManager = carManager;
    }
    public void addCar(Car car){
        cars.add(car);
        controller.addCar(car);
        carManager.notifySubscribers("Added: \n" + car.toString());
    }
    public void removeCar(Car car){
        cars.remove(car);
        controller.removeCar(car);
        carManager.notifySubscribers("Removed: \n" + car.toString());
    }
    public void subscribe(IUser subscriber) {
        carManager.subscribe(subscriber);
    }

    public void unSubscribe(IUser subscriber) {
        carManager.unSubscribe(subscriber);
    }


}
