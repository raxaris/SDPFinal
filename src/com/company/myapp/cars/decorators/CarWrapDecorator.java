package com.company.myapp.decorators;


import com.company.myapp.cars.Car;
import com.company.myapp.details.engine.interfaces.IEngineStrategy;
import com.company.myapp.details.transmission.Transmission;

public abstract class CarBodyKitDecorator extends Car {
    Car car;
    public abstract String toString();
    public CarBodyKitDecorator(Car car){
        this.car = car;
    }
    public int getId() {
        return  car.getId();
    }
    public Transmission getTransmission() {return car.getTransmission();}
    public int getPrice() {
        return car.getPrice();
    }
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
    public IEngineStrategy getEngine() {
        return car.getEngine();
    }

}