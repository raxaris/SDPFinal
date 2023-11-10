package com.company.myapp.repositories;

import com.company.myapp.cars.Car;
import com.company.myapp.details.engine.Engine;
import com.company.myapp.details.transmission.Transmission;
import com.company.myapp.factory.CarFactory;
import com.company.myapp.factory.brandfactories.*;
import com.company.myapp.user.User;

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
        CarFactory factory = getCarFactory(brand);
        engine = factory.createEngine(engineType, fuel, torque, volume, power);
        transmission = factory.createTransmission(transmissionType, gears);
        car = factory.createCar(id, model, engine, transmission, VIN, color, yearOfProduction, price);
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
        CarFactory factory = getCarFactory(brand);
        engine = factory.createEngine(engineType, fuel, torque, volume, power);
        transmission = factory.createTransmission(transmissionType, gears);
        car = factory.createCar(id, model, engine, transmission, VIN, color, yearOfProduction, price);
        return car;
    }

    private CarFactory getCarFactory(String brand) {
        switch (brand) {
            case "Hyundai":
                return hyundaiFactory;
            case "Audi":
                return audiFactory;
            case "Porsche":
                return porscheFactory;
            case "BMW":
                return bmwFactory;
            case "Mercedes-Benz":
                return mercedesFactory;
            case "Lamborghini":
                return lamboFactory;
            case "Volkswagen":
                return vwFactory;
            case "Toyota":
                return toyotaFactory;
            default:
                throw new IllegalArgumentException("Unsupported car brand: " + brand);
        }
    }

    public User createUserFromResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String login = rs.getString("login");
        String password = rs.getString("password");
        String email = rs.getString("email");
        boolean isAdmin = rs.getBoolean("isAdmin");

        User user = new User(id, login, password, email, isAdmin);
        return user;
    }

}
