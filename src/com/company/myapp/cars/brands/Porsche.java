package com.company.myapp.cars.brands;


import com.company.myapp.cars.Car;
import com.company.myapp.details.engine.Engine;
import com.company.myapp.details.transmission.Transmission;

public class Porsche extends Car {
    public Porsche(int id, String model, Engine engine, Transmission transmission, double VIN, String color, int yearOfProduction, int price) {
        super(id,"Porsche", model, engine, transmission, VIN, color, yearOfProduction, price);
    }
}
