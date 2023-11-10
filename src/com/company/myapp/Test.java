package com.company.myapp;

import com.company.myapp.cars.Car;
import com.company.myapp.controllers.UserController;
import com.company.myapp.data.DBSingleton;
import com.company.myapp.data.interfaces.IDB;
import com.company.myapp.repositories.CarRepository;
import com.company.myapp.repositories.UserRepository;

public class Test {
    public static void main(String[] args) {
        IDB db = DBSingleton.getInstance();
        UserRepository repo = new UserRepository(db);
        UserController controller = new UserController(repo);
        controller.isLoginAvailable("beka");
    }
}
