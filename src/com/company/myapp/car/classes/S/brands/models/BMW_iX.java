package com.company.myapp.car.classes.S.brands.models;

import com.company.myapp.car.classes.S.brands.S_BMW;
import com.company.myapp.details.engine.Engine;
import com.company.myapp.details.transmission.Transmission;

public class BMW_iX extends S_BMW {
    public BMW_iX(int id, Engine engine, Transmission transmission, double VIN, String color, int yearOfProduction, int price) {
        super(id,"iX", engine, transmission, VIN, color, yearOfProduction, price);
    }
}
