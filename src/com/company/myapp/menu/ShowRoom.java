package com.company.myapp.menu;

import com.company.myapp.cars.Car;
import com.company.myapp.controllers.CarController;
import com.company.myapp.user.inferfaces.IPublisher;
import com.company.myapp.user.inferfaces.IUser;

import java.util.List;

public class ShowRoom {
    private final CarController controller;
    private final IPublisher ShowRoomManager;
    private final List<Car> cars;
    public ShowRoom(CarController controller, IPublisher ShowRoomManager) {
        this.controller = controller;
        cars = controller.getAllCars();
        this.ShowRoomManager = ShowRoomManager;
    }
    public void addCar(Car car){
        cars.add(car);
        controller.addCar(car);
        ShowRoomManager.notifySubscribers("Added: \n" + car.toString());
    }
    public void removeCar(Car car){
        cars.remove(car);
        controller.removeCar(car);
        ShowRoomManager.notifySubscribers("Removed: \n" + car.toString());
    }
    public void subscribe(IUser subscriber) {
        ShowRoomManager.subscribe(subscriber);
    }

    public void unSubscribe(IUser subscriber) {
        ShowRoomManager.unSubscribe(subscriber);
    }


}
