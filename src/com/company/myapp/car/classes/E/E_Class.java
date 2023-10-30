package com.company.myapp.car.classes.E;

import com.company.myapp.car.Car;
import com.company.myapp.details.engine.Engine;
import com.company.myapp.details.transmission.Transmission;

public class E_Class extends Car {
    protected String suspension = "Soft";
    protected boolean GPSEnabled;
    protected boolean sunRoofOpened;

    public E_Class(int id, String brand, String model, Engine engine, Transmission transmission, double VIN, String color, int yearOfProduction, int price) {
        super(id, brand, model, engine, transmission, VIN, color, yearOfProduction,price);
    }

    public void enableGPS() {
        GPSEnabled = true;
        System.out.println("GPS enabled.");
    }

    public void disableGPS() {
        GPSEnabled = false;
        System.out.println("GPS disabled.");
    }
    public void openSunRoof() {
        sunRoofOpened = true;
        System.out.println("Sunroof opened.");
    }

    public void closeSunRoof() {
        sunRoofOpened = false;
        System.out.println("Sunroof closed.");
    }

    public void setSuspension(String suspension){
        this.suspension=suspension;
    }
    public String getSuspension(){
        return suspension;
    }
    public boolean isGPSEnabled() {
        return GPSEnabled;
    }

    public void setGPSEnabled(boolean GPSEnabled) {
        this.GPSEnabled = GPSEnabled;
    }

    public boolean isSunRoofOpened() {
        return sunRoofOpened;
    }

    public void setSunRoofOpened(boolean sunRoofOpened) {
        this.sunRoofOpened = sunRoofOpened;
    }
}
