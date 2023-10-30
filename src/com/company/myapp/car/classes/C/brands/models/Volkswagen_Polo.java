package com.company.myapp.car.classes.C.brands.models;

import com.company.myapp.car.classes.C.brands.C_Volkswagen;
import com.company.myapp.details.engine.Engine;
import com.company.myapp.details.transmission.Transmission;

public class Volkswagen_Polo extends C_Volkswagen {

    public Volkswagen_Polo(int id, Engine engine, Transmission transmission, double VIN, String color, int yearOfProduction, int price) {
        super(id,"Polo", engine, transmission, VIN, color, yearOfProduction, price);
    }
}
