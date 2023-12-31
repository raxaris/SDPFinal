package com.company.myapp.factory.brandfactories;

import com.company.myapp.cars.Car;
import com.company.myapp.cars.brands.BMW;
import com.company.myapp.details.engine.Engine;
import com.company.myapp.details.transmission.Transmission;
import com.company.myapp.factory.CarFactory;

public class BMWFactory extends CarFactory {
    @Override
    public Car createCar(int id, String model, Engine engine, Transmission transmission, double VIN, String color, int yearOfProduction, int price) {
        return new BMW(id,model,engine,transmission,VIN,color, yearOfProduction, price);
    }
}
