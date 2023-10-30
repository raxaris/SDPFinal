package com.company.myapp.car.classes.E.brands.models;

import com.company.myapp.car.classes.E.brands.E_BMW;
import com.company.myapp.details.engine.Engine;
import com.company.myapp.details.transmission.Transmission;

public class BMW_520d extends E_BMW {
    public BMW_520d(int id, Engine engine, Transmission transmission, double VIN, String color, int yearOfProduction, int price) {
        super(id,"520d", engine, transmission, VIN, color, yearOfProduction, price);
    }
}
