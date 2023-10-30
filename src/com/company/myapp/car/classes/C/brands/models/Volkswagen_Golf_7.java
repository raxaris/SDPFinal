package com.company.myapp.car.classes.C.brands.models;

import com.company.myapp.car.classes.C.brands.C_Volkswagen;
import com.company.myapp.details.engine.Engine;
import com.company.myapp.details.transmission.Transmission;

public class Volkswagen_Golf_7 extends C_Volkswagen {
    public Volkswagen_Golf_7(int id, Engine engine, Transmission transmission, double VIN, String color, int yearOfProduction, int price) {
        super(id,"Golf 7", engine, transmission, VIN, color, yearOfProduction, price);
    }
}
