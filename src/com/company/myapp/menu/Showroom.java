package com.company.myapp.menu;

import com.company.myapp.cars.Car;
import com.company.myapp.controllers.CarController;

public class Showroom {
    private final CarController controller;
    private final ShowroomManager showRoomManager;
    public Showroom(CarController controller) {
        this.controller = controller;
        showRoomManager = new ShowroomManager();
    }

    public boolean addCarToShowroom(Car car){
        showRoomManager.notifySubscribers("Car added: \n" + car.toString());
        return controller.addCar(car);
    }
    public boolean removeCarFromShowroom(int id){
        showRoomManager.notifySubscribers("Car removed: \n" + controller.getCar(id).toString());
        return controller.removeCarByID(id);
    }

    public ShowroomManager getShowRoomManager(){
        return showRoomManager;
    }
}
