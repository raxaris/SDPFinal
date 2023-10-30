package com.company.myapp.car.classes.S;

import com.company.myapp.car.Car;
import com.company.myapp.details.engine.Engine;
import com.company.myapp.details.transmission.Transmission;

public class S_Class extends Car {
    private String suspension = "Sport";
    private boolean turboEnabled = false;
    private boolean isDriftModeActivated = false;

    public S_Class(int id, String brand, String model, Engine engine, Transmission transmission, double VIN, String color, int yearOfProduction, int price) {
        super(id, brand, model, engine, transmission, VIN, color, yearOfProduction,price);
    }


    public void setTurboEnabled(boolean turboEnabled) {
        this.turboEnabled = turboEnabled;
    }

    public void setDriftModeActivated(boolean driftModeActivated) {
        isDriftModeActivated = driftModeActivated;
    }

    public String getSuspension() {
        return suspension;
    }

    public boolean isTurboEnabled() {
        return turboEnabled;
    }

    public boolean driftModeActivated() {
        return isDriftModeActivated;
    }
}
