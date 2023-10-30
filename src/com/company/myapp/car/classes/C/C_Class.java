package com.company.myapp.car.classes.C;

import com.company.myapp.car.Car;
import com.company.myapp.details.engine.Engine;
import com.company.myapp.details.transmission.Transmission;

public class C_Class extends Car {
    protected final String suspension = "Hard";

    public C_Class(int id, String brand, String model, Engine engine, Transmission transmission, double VIN, String color, int yearOfProduction, int price) {
        super(id, brand, model, engine, transmission, VIN, color, yearOfProduction,price);
    }

    public String getSuspension() {
        return suspension;
    }
}
