package com.company.myapp.cars;

import com.company.myapp.details.engine.interfaces.IEngineStrategy;
import com.company.myapp.details.transmission.Transmission;

public abstract class Car {
    protected int id;
    protected int price;
    protected double VIN;
    protected String color;
    protected  int yearOfProduction;
    protected String brand;
    protected String model;
    protected IEngineStrategy engine;
    protected Transmission transmission;

    public Car(int id, String brand, String model, IEngineStrategy engine, Transmission transmission, double VIN, String color, int yearOfProduction, int price) {
        setVIN(VIN);
        setColor(color);
        setPrice(price);
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.engine = engine;
        this.transmission = transmission;
        this.yearOfProduction = yearOfProduction;
    }
    protected Car() {}
    //setters

    private void setVIN(double VIN) {
        this.VIN = VIN;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    //getters
    public int getId() {
        return id;
    }
    public Transmission getTransmission() {return transmission;}
    public int getPrice() {
        return price;
    }
    public String getBrand() {
        return brand;
    }
    public String getModel() {
        return model;
    }
    public double getVIN() {return  VIN;}
    public String getColor() {return color;}
    public int getYearOfProduction() {return yearOfProduction;}
    public IEngineStrategy getEngine() {return engine;}
    public void startEngine() {System.out.println("Engine started.");}
    public void stopEngine() {System.out.println("Engine stopped.");}

    @Override
    public String toString() {
        return brand + " " + model + "\n" + "ID: " + id + "\n" + "Price: " + price + "\n" + "VIN: " + (int)VIN + "\n" + "Color: " + color + "\n" + "Year of Production: " +yearOfProduction + "\n"
                + "Engine: " + engine + "\n" + "Transmission: "+ transmission+"\n\n";
    }
}
