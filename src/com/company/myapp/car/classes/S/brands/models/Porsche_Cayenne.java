package com.company.myapp.car.classes.S.brands.models;

import com.company.myapp.car.classes.S.brands.S_Porsche;
import com.company.myapp.details.engine.Engine;
import com.company.myapp.details.transmission.Transmission;

public class Porsche_Cayenne extends S_Porsche {
    public Porsche_Cayenne(int id, Engine engine, Transmission transmission, double VIN, String color, int yearOfProduction, int price) {
        super(id,"Cayenne", engine, transmission, VIN, color, yearOfProduction, price);
    }
}
