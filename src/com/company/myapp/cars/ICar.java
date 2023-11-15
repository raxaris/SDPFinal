package com.company.myapp.cars;

import com.company.myapp.details.engine.Engine;
import com.company.myapp.details.transmission.Transmission;

public interface ICar{
    int getId();
    Transmission getTransmission();
    int getPrice();
    String getBrand();
    String getModel();
    double getVIN();
    String getColor();
    int getYearOfProduction();
    Engine getEngine();
    String toString();
    void setColor(String color);
}
