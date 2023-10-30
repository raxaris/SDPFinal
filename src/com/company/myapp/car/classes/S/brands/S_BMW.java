package com.company.myapp.car.classes.S.brands;

import com.company.myapp.car.classes.S.S_Class;
import com.company.myapp.details.engine.Engine;
import com.company.myapp.details.transmission.Transmission;

public class S_BMW extends S_Class {

    public S_BMW(int id, String model, Engine engine, Transmission transmission, double VIN, String color, int yearOfProduction, int price) {
        super(id,"BMW", model, engine, transmission, VIN, color, yearOfProduction, price);
    }
}
