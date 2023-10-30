package com.company.myapp.car.classes.C.brands.models;

import com.company.myapp.car.classes.C.brands.C_Hyundai;
import com.company.myapp.details.engine.Engine;
import com.company.myapp.details.transmission.Transmission;

public class Hyundai_Elantra extends C_Hyundai {
    public Hyundai_Elantra(int id, Engine engine, Transmission transmission, double VIN, String color, int yearOfProduction, int price) {
        super(id,"Elantra", engine, transmission, VIN, color, yearOfProduction, price);
    }
}
