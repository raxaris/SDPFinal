package com.company.myapp.car.classes.S.brands.models;

import com.company.myapp.car.classes.S.brands.S_Porsche;
import com.company.myapp.details.engine.Engine;
import com.company.myapp.details.transmission.Transmission;

public class Porsche_911_Turbo_S extends S_Porsche {
    public Porsche_911_Turbo_S(int id, Engine engine, Transmission transmission, double VIN, String color, int yearOfProduction, int price) {
        super(id,"911 Turbo-S", engine, transmission, VIN, color, yearOfProduction, price);
    }
}
