package com.company.myapp.repositories;

import com.company.myapp.data.interfaces.IDB;
import com.company.myapp.cars.Car;
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
}
