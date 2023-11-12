package com.company.myapp.cars.brands;


import com.company.myapp.cars.Car;
import com.company.myapp.details.engine.Engine;
import com.company.myapp.details.transmission.Transmission;

public class Mercedes extends Car {
    public Mercedes(int id, String model, Engine engine, Transmission transmission, double VIN, String color, int yearOfProduction, int price) {
        super(id,"Mercedes-Benz", model, engine, transmission, VIN, color, yearOfProduction, price);
    }
}
