package com.company.myapp.factory;

import com.company.myapp.cars.Car;
import com.company.myapp.details.engine.Engine;
import com.company.myapp.details.transmission.Transmission;

public abstract class CarFactory {
    public abstract Car createCar(int id, String model, Engine engine, Transmission transmission, double VIN, String color, int yearOfProduction, int price);
}
