package com.company.myapp.car.classes.E.brands.models;

import com.company.myapp.car.classes.E.brands.E_BMW;
import com.company.myapp.details.engine.Engine;
import com.company.myapp.details.transmission.Transmission;

public class BMW_M5 extends E_BMW {
    public BMW_M5(int id, Engine engine, Transmission transmission, double VIN, String color, int yearOfProduction, int price) {
        super(id,"M5 F90", engine, transmission, VIN, color, yearOfProduction, price);
    }
}
