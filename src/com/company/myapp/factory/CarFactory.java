package com.company.myapp.factory;

import com.company.myapp.cars.Car;
import com.company.myapp.details.engine.Engine;
import com.company.myapp.details.engine.types.Electro;
import com.company.myapp.details.engine.types.ICE;
import com.company.myapp.details.transmission.Transmission;
import com.company.myapp.details.transmission.types.Auto;
import com.company.myapp.details.transmission.types.Manual;

public abstract class CarFactory {
    public Engine createEngine(String engineType, String fuel, double torque, double volume, int power) {
        Engine engine = switch (engineType) {
            case "ICE" -> new ICE(torque, volume, power, fuel);
            case "Electro" -> new Electro(torque, power);
            default -> throw new IllegalArgumentException("Unsupported engine type: " + engineType);
        };
        return engine;
    }

    public Transmission createTransmission(String transmissionType, int gears){
        Transmission transmission = switch (transmissionType) {
            case "Auto" -> new Auto(gears);
            case "Manual" -> new Manual(gears);
            default -> throw new IllegalArgumentException("Unsupported engine type: " + transmissionType);
        };
        return transmission;
    }
    public abstract Car createCar(int id, String model, Engine engine, Transmission transmission, double VIN, String color, int yearOfProduction, int price);
}
