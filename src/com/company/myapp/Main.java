package com.company.myapp;

import com.company.myapp.controllers.CarController;
import com.company.myapp.data.DBSingleton;
import com.company.myapp.data.interfaces.IDB;
import com.company.myapp.repositories.CarRepository;

public class Main {
    public static void main(String[] args) {
        IDB db = DBSingleton.getInstance();
        CarRepository repo = new CarRepository(db);
        CarController controller = new CarController(repo);
        System.out.println(controller.getCar(2));
    }
}