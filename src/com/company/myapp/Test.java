package com.company.myapp;

import com.company.myapp.application.MyApplication;
import com.company.myapp.application.MyApplication1;
import com.company.myapp.cars.Car;
import com.company.myapp.cars.brands.BMW;
import com.company.myapp.controllers.CarController;
import com.company.myapp.controllers.UserController;
import com.company.myapp.data.DBSingleton;
import com.company.myapp.data.interfaces.IDB;

import com.company.myapp.repositories.CarRepository;
import com.company.myapp.repositories.UserRepository;

public class Test {
    public static void main(String[] args) {
        IDB db = DBSingleton.getInstance();
        CarRepository carRepo = new CarRepository(db);
        UserRepository userRepo = new UserRepository(db);
        CarController carController = new CarController(carRepo);
        UserController userController = new UserController(userRepo);
        MyApplication1 application = new MyApplication1(carController, userController);
        application.start();
    }
}
