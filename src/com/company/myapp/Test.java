package com.company.myapp;

import com.company.myapp.cars.Car;
import com.company.myapp.data.DBSingleton;
import com.company.myapp.data.interfaces.IDB;
import com.company.myapp.repositories.CarRepository;

public class Test {
    public static void main(String[] args) {
        IDB db = DBSingleton.getInstance();
        CarRepository repo = new CarRepository(db);
        Car copyCar = repo.getCar(15);
        System.out.println(repo.addCar(copyCar));
    }
}
