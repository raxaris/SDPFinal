package com.company.myapp.car.classes.S.brands;

import com.company.myapp.car.classes.S.S_Class;
import com.company.myapp.details.engine.Engine;
import com.company.myapp.details.transmission.Transmission;

public class S_Lamborghini extends S_Class {

    public S_Lamborghini(int id,String model, Engine engine, Transmission transmission, double VIN, String color, int yearOfProduction, int price) {
        super(id,"Lamborghini", model, engine, transmission, VIN, color, yearOfProduction, price);
    }
}