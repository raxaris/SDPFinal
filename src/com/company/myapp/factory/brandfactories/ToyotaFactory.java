package com.company.myapp.factory.brandfactories;

import com.company.myapp.cars.Car;
import com.company.myapp.cars.brands.Toyota;
import com.company.myapp.details.engine.Engine;
import com.company.myapp.details.engine.interfaces.IEngineStrategy;
import com.company.myapp.details.transmission.Transmission;
import com.company.myapp.factory.CarFactory;

public class ToyotaFactory extends CarFactory {
    public Car createCar(int id, String model, IEngineStrategy engine, Transmission transmission, double VIN, String color, int yearOfProduction, int price) {
        return new Toyota(id,model,engine,transmission,VIN,color, yearOfProduction, price);
    }
}
