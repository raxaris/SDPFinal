package com.company.myapp.repositories;

import com.company.myapp.car.classes.C.brands.models.*;
import com.company.myapp.car.classes.E.brands.models.*;
import com.company.myapp.car.classes.S.brands.models.*;
import com.company.myapp.data.interfaces.IDB;
import com.company.myapp.car.Car;
import com.company.myapp.details.engine.Engine;
import com.company.myapp.details.engine.types.Electro;
import com.company.myapp.details.engine.types.ICE;
import com.company.myapp.details.transmission.Transmission;
import com.company.myapp.details.transmission.types.Auto;
import com.company.myapp.details.transmission.types.Manual;
import com.company.myapp.repositories.interfaces.ICarRepository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class CarRepository implements ICarRepository {
    private final IDB db;
    Engine engine;
    Transmission transmission;
    Car car;

    public CarRepository(IDB db) {
        this.db = db;
    }

    public Engine createEngine(ResultSet rs) throws SQLException {
        Engine engine;
        if (rs.getString("engine_type").equals("ICE")) {
            engine = new ICE(rs.getDouble("torque"), rs.getDouble("volume"), rs.getInt("power"), rs.getString("fuel"));
        } else if (rs.getString("engine_type").equals("Electro")) {
            engine = new Electro(rs.getDouble("torque"), rs.getInt("power"));
        } else {
            throw new IllegalArgumentException("Invalid engine type: " + rs.getString("engine_type"));
        }
        return engine;
    }

    public Transmission createTransmission(ResultSet rs) throws SQLException {
        Transmission transmission;
        if (rs.getString("transmission").equals("Auto")) {
            transmission = new Auto(rs.getInt("gears"));
        } else if (rs.getString("transmission").equals("Manual")) {
            transmission = new Manual(rs.getInt("gears"));
        } else {
            throw new IllegalArgumentException("Invalid transmission type: " + rs.getString("transmission"));
        }
        return transmission;
    }
    public Car createCar(ResultSet rs) throws SQLException{
        if(rs.getString("brand").equals("BMW")) {
            if (rs.getString("model").equals("Z4")) {
                car = new BMW_Z4(rs.getInt("id"), engine, transmission, rs.getInt("VIN"), rs.getString("color"), rs.getInt("years"), rs.getInt("price"));
            } else if (rs.getString("model").equals("M2")) {
                car = new BMW_M2(rs.getInt("id"), engine, transmission, rs.getInt("VIN"), rs.getString("color"), rs.getInt("years"), rs.getInt("price"));
            } else if (rs.getString("model").equals("iX")) {
                car = new BMW_iX(rs.getInt("id"), engine, transmission, rs.getInt("VIN"), rs.getString("color"), rs.getInt("years"), rs.getInt("price"));
            } else if (rs.getString("model").equals("520d")) {
                car = new BMW_520d(rs.getInt("id"), engine, transmission, rs.getInt("VIN"), rs.getString("color"), rs.getInt("years"), rs.getInt("price"));
            } else if (rs.getString("model").equals("540i")) {
                car = new BMW_540i(rs.getInt("id"), engine, transmission, rs.getInt("VIN"), rs.getString("color"), rs.getInt("years"), rs.getInt("price"));
            } else if (rs.getString("model").equals("M5 F90")) {
                car = new BMW_M5(rs.getInt("id"), engine, transmission, rs.getInt("VIN"), rs.getString("color"), rs.getInt("years"), rs.getInt("price"));
            }
        } else if(rs.getString("brand").equals("Audi")) {
            if (rs.getString("model").equals("S7")) {
                car = new Audi_S7(rs.getInt("id"), engine, transmission, rs.getInt("VIN"), rs.getString("color"), rs.getInt("years"), rs.getInt("price"));
            } else if (rs.getString("model").equals("RS6")) {
                car = new Audi_RS6(rs.getInt("id"), engine, transmission, rs.getInt("VIN"), rs.getString("color"), rs.getInt("years"), rs.getInt("price"));
            } else if (rs.getString("model").equals("e-tron GT")) {
                car = new Audi_e_tron_GT(rs.getInt("id"), engine, transmission, rs.getInt("VIN"), rs.getString("color"), rs.getInt("years"), rs.getInt("price"));
            }
        } else if(rs.getString("brand").equals("Mercedes-Benz")) {
            if (rs.getString("model").equals("E-class")) {
                car = new MercedesBenz_E_Class(rs.getInt("id"), engine, transmission, rs.getInt("VIN"), rs.getString("color"), rs.getInt("years"), rs.getInt("price"));
            } else if (rs.getString("model").equals("CLA")) {
                car = new MercedesBenz_CLA(rs.getInt("id"), engine, transmission, rs.getInt("VIN"), rs.getString("color"), rs.getInt("years"), rs.getInt("price"));
            } else if (rs.getString("model").equals("CLS")) {
                car = new MercedesBenz_CLS(rs.getInt("id"), engine, transmission, rs.getInt("VIN"), rs.getString("color"), rs.getInt("years"), rs.getInt("price"));
            }
        } else if(rs.getString("brand").equals("Porsche")) {
            if (rs.getString("model").equals("Cayman")) {
                car = new Porsche_Cayman(rs.getInt("id"), engine, transmission, rs.getInt("VIN"), rs.getString("color"), rs.getInt("years"), rs.getInt("price"));
            } else if (rs.getString("model").equals("Taycan")) {
                car = new Porsche_Taycan(rs.getInt("id"), engine, transmission, rs.getInt("VIN"), rs.getString("color"), rs.getInt("years"), rs.getInt("price"));
            } else if (rs.getString("model").equals("911 Turbo-S")) {
                car = new Porsche_911_Turbo_S(rs.getInt("id"), engine, transmission, rs.getInt("VIN"), rs.getString("color"), rs.getInt("years"), rs.getInt("price"));
            }
        } else if(rs.getString("brand").equals("Lamborghini")) {
            if (rs.getString("model").equals("Huracan LP 580-2")) {
                car = new Lamborghini_Huracan(rs.getInt("id"), engine, transmission, rs.getInt("VIN"), rs.getString("color"), rs.getInt("years"), rs.getInt("price"));
            } else if (rs.getString("model").equals("Urus")) {
                car = new Lamborghini_Urus(rs.getInt("id"), engine, transmission, rs.getInt("VIN"), rs.getString("color"), rs.getInt("years"), rs.getInt("price"));
            } else if (rs.getString("model").equals("Aventador LP 780-4")) {
                car = new Lamborghini_Aventador(rs.getInt("id"), engine, transmission, rs.getInt("VIN"), rs.getString("color"), rs.getInt("years"), rs.getInt("price"));
            }
        } else if(rs.getString("brand").equals("Hyundai")) {
            if (rs.getString("model").equals("Accent")) {
                car = new Hyundai_Accent(rs.getInt("id"), engine, transmission, rs.getInt("VIN"), rs.getString("color"), rs.getInt("years"), rs.getInt("price"));
            } else if (rs.getString("model").equals("i30")) {
                car = new Hyundai_i30(rs.getInt("id"), engine, transmission, rs.getInt("VIN"), rs.getString("color"), rs.getInt("years"), rs.getInt("price"));
            } else if (rs.getString("model").equals("Elantra")) {
                car = new Hyundai_Elantra(rs.getInt("id"), engine, transmission, rs.getInt("VIN"), rs.getString("color"), rs.getInt("years"), rs.getInt("price"));
            }
        } else if(rs.getString("brand").equals("Toyota")) {
            if (rs.getString("model").equals("Auris")) {
                car = new Toyota_Auris(rs.getInt("id"), engine, transmission, rs.getInt("VIN"), rs.getString("color"), rs.getInt("years"), rs.getInt("price"));
            } else if (rs.getString("model").equals("Corolla")) {
                car = new Toyota_Corolla(rs.getInt("id"), engine, transmission, rs.getInt("VIN"), rs.getString("color"), rs.getInt("years"), rs.getInt("price"));
            } else if (rs.getString("model").equals("Prius")) {
                car = new Toyota_Prius(rs.getInt("id"), engine, transmission, rs.getInt("VIN"), rs.getString("color"), rs.getInt("years"), rs.getInt("price"));
            }
        } else if(rs.getString("brand").equals("Volkswagen")) {
            if (rs.getString("model").equals("Golf 7")) {
                car = new Volkswagen_Golf_7(rs.getInt("id"), engine, transmission, rs.getInt("VIN"), rs.getString("color"), rs.getInt("years"), rs.getInt("price"));
            } else if (rs.getString("model").equals("id.3")) {
                car = new Volkswagen_ID3(rs.getInt("id"), engine, transmission, rs.getInt("VIN"), rs.getString("color"), rs.getInt("years"), rs.getInt("price"));
            } else if (rs.getString("model").equals("Polo")) {
                car = new Volkswagen_Polo(rs.getInt("id"), engine, transmission, rs.getInt("VIN"), rs.getString("color"), rs.getInt("years"), rs.getInt("price"));
            }
        }
    return car;
    }
    @Override
    public Car getCar(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM cars WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                engine = createEngine(rs);
                transmission = createTransmission(rs);
                car = createCar(rs);
                    return car;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Car> getAllCars() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM cars";
            //String sql = "SELECT id,brand,model,engine_type,fuel,torque,volume,power,transmission,gears,years,price,class,VIN,color  FROM cars WHERE id=?";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Car> cars = new LinkedList<>();
            while (rs.next()) {
                engine = createEngine(rs);
                transmission = createTransmission(rs);
                car = createCar(rs);
                cars.add(car);
            }
            return cars;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
    @Override
    public List<Car> getCarByPrice(int start, int end) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM cars";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Car> cars = new LinkedList<>();
            while (rs.next()) {
                if(rs.getInt("price")>=start && rs.getInt("price")<=end) {
                    engine = createEngine(rs);
                    transmission = createTransmission(rs);
                    car = createCar(rs);
                    cars.add(car);
                }
            }
            return cars;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
    @Override
    public List<Car> getCarByYear(int start, int end){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM cars";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Car> cars = new LinkedList<>();
            while (rs.next()) {
                if(rs.getInt("years")>=start && rs.getInt("years")<=end) {
                    engine = createEngine(rs);
                    transmission = createTransmission(rs);
                    car = createCar(rs);
                    cars.add(car);
                }
            }
            return cars;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Car> getCarByBrand(String brand) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM cars";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Car> cars = new LinkedList<>();
            while (rs.next()) {
                if(rs.getString("brand").equals(brand)) {
                    engine = createEngine(rs);
                    transmission = createTransmission(rs);
                    car = createCar(rs);
                    cars.add(car);
                }
            }
            return cars;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Car> getCarByModel(String brand, String model) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM cars";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Car> cars = new LinkedList<>();
            while (rs.next()) {
                if(rs.getString("brand").equals(brand) && rs.getString("model").equals(model)) {
                    engine = createEngine(rs);
                    transmission = createTransmission(rs);
                    car = createCar(rs);
                    cars.add(car);
                }
            }
            return cars;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
}
