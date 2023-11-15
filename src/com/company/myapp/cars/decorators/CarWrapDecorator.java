package com.company.myapp.cars.decorators;

import com.company.myapp.cars.ICar;
import com.company.myapp.details.engine.Engine;
import com.company.myapp.details.transmission.Transmission;

public abstract class CarWrapDecorator implements ICar {
    ICar car;
    public abstract String toString();
    public abstract int getPrice();
    public CarWrapDecorator(ICar car){
        this.car = car;
    }
    public int getId() {
        return  car.getId();
    }
    public Transmission getTransmission() {return car.getTransmission();}
    public String getBrand() {
        return car.getBrand();
    }
    public String getModel() {
        return car.getModel();
    }
    public double getVIN() {
        return  car.getVIN();
    }
    public String getColor() {
        return car.getColor();
    }
    public int getYearOfProduction() {
        return car.getYearOfProduction();
    }
    public Engine getEngine() {
        return car.getEngine();
    }
    public void setColor(String color) {
        car.setColor(color);
    }
}