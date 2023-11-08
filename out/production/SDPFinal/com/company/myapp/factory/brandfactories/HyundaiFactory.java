package com.company.myapp.factory.brandfactories;

import com.company.myapp.cars.Car;
import com.company.myapp.cars.brands.Hyundai;
import com.company.myapp.data.interfaces.IDB;
import com.company.myapp.details.engine.Engine;
import com.company.myapp.details.transmission.Transmission;
import com.company.myapp.factory.CarFactory;

public class HyundaiFactory extends CarFactory {

    @Override
    public Car createCar(int id, String model, Engine engine, Transmission transmission, double VIN, String color, int yearOfProduction, int price) {
        return new Hyundai(id,model,engine,transmission,VIN,color, yearOfProduction, price);
    }
}
