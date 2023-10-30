package com.company.myapp.car.classes.S.brands.models;

import com.company.myapp.car.classes.S.brands.S_Lamborghini;
import com.company.myapp.details.engine.Engine;
import com.company.myapp.details.transmission.Transmission;

public class Lamborghini_Aventador extends S_Lamborghini {
    public Lamborghini_Aventador(int id, Engine engine, Transmission transmission, double VIN, String color, int yearOfProduction, int price) {
        super(id,"Aventador LP 780-4", engine, transmission, VIN, color, yearOfProduction, price);
    }
}
