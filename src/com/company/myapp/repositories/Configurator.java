package com.company.myapp.repositories;

import com.company.myapp.cars.Car;
import com.company.myapp.details.engine.Engine;
import com.company.myapp.details.transmission.Transmission;
import com.company.myapp.factory.CarFactory;
import com.company.myapp.factory.brandfactories.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Configurator {
    Car car = null;
    Transmission transmission = null;
    Engine engine = null;
    CarFactory bmwFactory = new BMWFactory();
    CarFactory audiFactory = new AudiFactory();
    CarFactory mercedesFactory = new MercedesFactory();
    CarFactory lamboFactory = new LamborghiniFactory();
    CarFactory hyundaiFactory = new HyundaiFactory();
    CarFactory toyotaFactory = new ToyotaFactory();
    CarFactory vwFactory = new VolkswagenFactory();
    CarFactory porscheFactory = new PorscheFactory();
    public Configurator() {}
    public Car createCar(int id, String brand, String model, String engineType, String fuel, int torque, double volume, int power, String transmissionType, int gears, int yearOfProduction, int price, double VIN, String color){
        switch (brand) {
            case "Hyundai" -> {
                engine = hyundaiFactory.createEngine(engineType, fuel, torque, volume, power);
                transmission = hyundaiFactory.createTransmission(transmissionType, gears);
                car = hyundaiFactory.createCar(id, model, engine, transmission, VIN, color, yearOfProduction, price);
            }
            case "Audi" -> {
                engine = audiFactory.createEngine(engineType, fuel, torque, volume, power);
                transmission = audiFactory.createTransmission(transmissionType, gears);
                car = audiFactory.createCar(id, model, engine, transmission, VIN, color, yearOfProduction, price);
            }
            case "Porsche" -> {
                engine = porscheFactory.createEngine(engineType, fuel, torque, volume, power);
                transmission = porscheFactory.createTransmission(transmissionType, gears);
                car = porscheFactory.createCar(id, model, engine, transmission, VIN, color, yearOfProduction, price);
            }
            case "BMW" -> {
                engine = bmwFactory.createEngine(engineType, fuel, torque, volume, power);
                transmission = bmwFactory.createTransmission(transmissionType, gears);
                car = bmwFactory.createCar(id, model, engine, transmission, VIN, color, yearOfProduction, price);
            }
            case "Mercedes-Benz" -> {
                engine = mercedesFactory.createEngine(engineType, fuel, torque, volume, power);
                transmission = mercedesFactory.createTransmission(transmissionType, gears);
                car = mercedesFactory.createCar(id, model, engine, transmission, VIN, color, yearOfProduction, price);
            }
            case "Lamborghini" -> {
                engine = lamboFactory.createEngine(engineType, fuel, torque, volume, power);
                transmission = lamboFactory.createTransmission(transmissionType, gears);
                car = lamboFactory.createCar(id, model, engine, transmission, VIN, color, yearOfProduction, price);
            }
            case "Volkswagen" -> {
                engine = vwFactory.createEngine(engineType, fuel, torque, volume, power);
                transmission = vwFactory.createTransmission(transmissionType, gears);
                car = vwFactory.createCar(id, model, engine, transmission, VIN, color, yearOfProduction, price);
            }
            case "Toyota" -> {
                engine = toyotaFactory.createEngine(engineType, fuel, torque, volume, power);
                transmission = toyotaFactory.createTransmission(transmissionType, gears);
                car = toyotaFactory.createCar(id, model, engine, transmission, VIN, color, yearOfProduction, price);
            }
            default -> throw new IllegalArgumentException("Unsupported car brand: " + brand);
        }

        return car;
    }

    public Car createCarFromResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String brand = rs.getString("brand");
        String model = rs.getString("model");
        String engineType = rs.getString("engine_type");
        String fuel = rs.getString("fuel");
        int torque = rs.getInt("torque");
        double volume = rs.getDouble("volume");
        int power = rs.getInt("power");
        String transmissionType = rs.getString("transmission");
        int gears = rs.getInt("gears");
        int yearOfProduction = rs.getInt("years");
        int price = rs.getInt("price");
        double VIN = rs.getDouble("VIN");
        String color = rs.getString("color");
        switch (brand) {
            case "Hyundai" -> {
                engine = hyundaiFactory.createEngine(engineType, fuel, torque, volume, power);
                transmission = hyundaiFactory.createTransmission(transmissionType, gears);
                car = hyundaiFactory.createCar(id, model, engine, transmission, VIN, color, yearOfProduction, price);
            }
            case "Audi" -> {
                engine = audiFactory.createEngine(engineType, fuel, torque, volume, power);
                transmission = audiFactory.createTransmission(transmissionType, gears);
                car = audiFactory.createCar(id, model, engine, transmission, VIN, color, yearOfProduction, price);
            }
            case "Porsche" -> {
                engine = porscheFactory.createEngine(engineType, fuel, torque, volume, power);
                transmission = porscheFactory.createTransmission(transmissionType, gears);
                car = porscheFactory.createCar(id, model, engine, transmission, VIN, color, yearOfProduction, price);
            }
            case "BMW" -> {
                engine = bmwFactory.createEngine(engineType, fuel, torque, volume, power);
                transmission = bmwFactory.createTransmission(transmissionType, gears);
                car = bmwFactory.createCar(id, model, engine, transmission, VIN, color, yearOfProduction, price);
            }
            case "Mercedes-Benz" -> {
                engine = mercedesFactory.createEngine(engineType, fuel, torque, volume, power);
                transmission = mercedesFactory.createTransmission(transmissionType, gears);
                car = mercedesFactory.createCar(id, model, engine, transmission, VIN, color, yearOfProduction, price);
            }
            case "Lamborghini" -> {
                engine = lamboFactory.createEngine(engineType, fuel, torque, volume, power);
                transmission = lamboFactory.createTransmission(transmissionType, gears);
                car = lamboFactory.createCar(id, model, engine, transmission, VIN, color, yearOfProduction, price);
            }
            case "Volkswagen" -> {
                engine = vwFactory.createEngine(engineType, fuel, torque, volume, power);
                transmission = vwFactory.createTransmission(transmissionType, gears);
                car = vwFactory.createCar(id, model, engine, transmission, VIN, color, yearOfProduction, price);
            }
            case "Toyota" -> {
                engine = toyotaFactory.createEngine(engineType, fuel, torque, volume, power);
                transmission = toyotaFactory.createTransmission(transmissionType, gears);
                car = toyotaFactory.createCar(id, model, engine, transmission, VIN, color, yearOfProduction, price);
            }
            default -> throw new IllegalArgumentException("Unsupported car brand: " + brand);
        }

       return car;
    }
}
