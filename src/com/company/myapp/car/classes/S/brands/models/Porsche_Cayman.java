package com.company.myapp.car.classes.S.brands.models;

import com.company.myapp.car.classes.S.brands.S_Porsche;
import com.company.myapp.details.engine.Engine;
import com.company.myapp.details.transmission.Transmission;

public class Porsche_Cayman extends S_Porsche {
    public Porsche_Cayman(int id, Engine engine, Transmission transmission, double VIN, String color, int yearOfProduction, int price) {
        super(id,"Cayman", engine, transmission, VIN, color, yearOfProduction, price);
    }
}
