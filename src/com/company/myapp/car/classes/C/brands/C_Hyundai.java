package com.company.myapp.car.classes.C.brands;

import com.company.myapp.car.classes.C.C_Class;
import com.company.myapp.details.engine.Engine;
import com.company.myapp.details.transmission.Transmission;

public class C_Hyundai extends C_Class {

    public C_Hyundai(int id, String model, Engine engine, Transmission transmission, double VIN, String color, int yearOfProduction, int price) {
        super(id,"Hyundai", model, engine, transmission, VIN, color, yearOfProduction, price);
    }
}
