package com.company.myapp.car.classes.E.brands.models;

import com.company.myapp.car.classes.E.brands.E_MercedesBenz;
import com.company.myapp.details.engine.Engine;
import com.company.myapp.details.transmission.Transmission;

public class MercedesBenz_E_Class extends E_MercedesBenz {
    public MercedesBenz_E_Class(int id, Engine engine, Transmission transmission, double VIN, String color, int yearOfProduction, int price) {
        super(id,"E-class", engine, transmission, VIN, color, yearOfProduction, price);
    }
}
