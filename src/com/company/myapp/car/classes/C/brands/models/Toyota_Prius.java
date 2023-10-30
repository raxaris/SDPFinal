package com.company.myapp.car.classes.C.brands.models;

import com.company.myapp.car.classes.C.brands.C_Toyota;
import com.company.myapp.details.engine.Engine;
import com.company.myapp.details.transmission.Transmission;

public class Toyota_Prius extends C_Toyota {
    public Toyota_Prius(int id, Engine engine, Transmission transmission, double VIN, String color, int yearOfProduction, int price) {
        super(id,"Prius", engine, transmission, VIN, color, yearOfProduction, price);
    }
}
