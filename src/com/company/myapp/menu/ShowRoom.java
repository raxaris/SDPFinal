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

    public boolean addCarToShowRoom(Car car){
        showRoomManager.notifySubscribers("Car added: \n" + car.toString());
        return controller.addCar(car);
    }
    public boolean removeCarFromShowRoom(int id){
        showRoomManager.notifySubscribers("Car removed: \n" + controller.getCar(id).toString());
        return controller.removeCarByID(id);
    }

    public ShowRoomManager getShowRoomManager(){
        return showRoomManager;
    }
}
