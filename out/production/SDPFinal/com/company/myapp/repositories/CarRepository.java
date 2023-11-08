package com.company.myapp.repositories;

import com.company.myapp.data.interfaces.IDB;
import com.company.myapp.cars.Car;
import com.company.myapp.details.engine.Engine;
import com.company.myapp.details.engine.types.Electro;
import com.company.myapp.details.engine.types.ICE;
import com.company.myapp.details.transmission.Transmission;
import com.company.myapp.repositories.interfaces.ICarRepository;

import java.sql.*;
import java.util.*;

public class CarRepository implements ICarRepository {
    private final IDB db;
    Configurator configurator = new Configurator();

    public CarRepository(IDB db) {
        this.db = db;
    }

    @Override
    public Car getCar(int id) {
        try (Connection con = db.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM cars WHERE id = ?")) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Car car = configurator.createCarFromResultSet(rs);
                    return car;
                } else {
                    return null;
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Car> getAllCars() {
        try (Connection con = db.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM cars")) {

            List<Car> cars = new ArrayList<>();
            while (rs.next()) {
                Car car = configurator.createCarFromResultSet(rs);
                cars.add(car);
            }
            return cars;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private List<Car> getCarsByQuery(String query, Object... params) {
        try (Connection con = db.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }

            try (ResultSet rs = ps.executeQuery()) {
                List<Car> cars = new ArrayList<>();
                while (rs.next()) {
                    Car car = configurator.createCarFromResultSet(rs);
                    cars.add(car);
                }
                return cars;
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public List<Car> getCarByPrice(int start, int end) {
        String query = "SELECT * FROM cars WHERE price BETWEEN ? AND ?";
        return getCarsByQuery(query, start, end);
    }

    @Override
    public List<Car> getCarByYear(int start, int end) {
        String query = "SELECT * FROM cars WHERE years BETWEEN ? AND ?";
        return getCarsByQuery(query, start, end);
    }
    @Override
    public List<Car> getCarByBrand(String brand) {
        String query = "SELECT * FROM cars WHERE brand = ?";
        return getCarsByQuery(query, brand);
    }
    @Override
    public List<Car> getCarByModel(String brand, String model) {
        String query = "SELECT * FROM cars WHERE brand = ? AND model = ?";
        return getCarsByQuery(query, brand, model);
    }
    @Override
    public boolean deleteCar(int id) {
        try (Connection con = db.getConnection();
             PreparedStatement ps = con.prepareStatement("DELETE FROM cars WHERE id = ?")) {

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public boolean addCar(Car car){
        try (Connection con = db.getConnection();
             PreparedStatement ps = con.prepareStatement("INSERT INTO cars (brand, model, engine_type, fuel, torque, volume, power, transmission, gears, years, price, VIN, color) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")){

            ps.setString(1, car.getBrand());
            ps.setString(2, car.getModel());
            Engine engine = car.getEngine();
            ps.setString(3, engine.getType());

            if (engine instanceof ICE) {
                ICE ice = (ICE) engine;
                ps.setString(4, ice.getTypeOfFuel());
                ps.setInt(5, ice.getTorque());
                ps.setDouble(6, ice.getEngineVolume());
                ps.setInt(7, ice.getHorsepower());
            } else if (engine instanceof Electro) {
                Electro electro = (Electro) engine;
                ps.setNull(4, Types.VARCHAR);
                ps.setInt(5, electro.getTorque());
                ps.setNull(6, java.sql.Types.DOUBLE);
                ps.setInt(7, electro.getPower());
            } else {
                throw new IllegalArgumentException("Error. Invalid engine type");
            }

            Transmission transmission = car.getTransmission();
            ps.setString(8, transmission.getType());
            ps.setInt(9, transmission.getNumberOfGears());
            ps.setInt(10, car.getYearOfProduction());
            ps.setInt(11, car.getPrice());
            ps.setDouble(12, car.getVIN());
            ps.setString(13, car.getColor());


            return ps.executeUpdate() > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}
