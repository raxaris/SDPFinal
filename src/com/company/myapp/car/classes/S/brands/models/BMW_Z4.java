package com.company.myapp.car.classes.S.brands.models;

import com.company.myapp.car.classes.S.brands.S_BMW;
import com.company.myapp.details.engine.Engine;
import com.company.myapp.details.transmission.Transmission;

public class BMW_Z4 extends S_BMW {
    public BMW_Z4(int id, Engine engine, Transmission transmission, double VIN, String color, int yearOfProduction, int price) {
        super(id,"Z4", engine, transmission, VIN, color, yearOfProduction, price);
    }
}
