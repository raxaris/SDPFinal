package com.company.myapp.menu;

import com.company.myapp.cars.Car;
import com.company.myapp.controllers.CarController;

public class ShowRoom {
    private final CarController controller;
    private final ShowRoomManager showRoomManager;
    public ShowRoom(CarController controller) {
        this.controller = controller;
        showRoomManager = new ShowRoomManager();
    }

    public void addCarToShowRoom(Car car){
        controller.addCar(car);
        showRoomManager.notifySubscribers("Car added: \n" + car.toString());
    }
    public void removeCarFromShowRoom(Car car){
        controller.removeCar(car);
        showRoomManager.notifySubscribers("Car removed: \n" + car.toString());
    }

    public ShowRoomManager getShowRoomManager(){
        return showRoomManager;
    }
}
