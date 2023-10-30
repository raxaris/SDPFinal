package com.company.myapp.car.classes.C.brands.models;

import com.company.myapp.car.classes.C.brands.C_Toyota;
import com.company.myapp.details.engine.Engine;
import com.company.myapp.details.transmission.Transmission;

public class Toyota_Corolla extends C_Toyota {
    public Toyota_Corolla(int id, Engine engine, Transmission transmission, double VIN, String color, int yearOfProduction, int price) {
        super(id,"Corolla", engine, transmission, VIN, color, yearOfProduction, price);
    }
}
