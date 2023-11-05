package com.company.myapp.repositories;

import com.company.myapp.data.interfaces.IDB;
import com.company.myapp.cars.Car;
import com.company.myapp.repositories.interfaces.ICarRepository;

import java.sql.*;

public class CarRepository implements ICarRepository {
    private final IDB db;
    Configurator configurator = new Configurator();

    public CarRepository(IDB db) {
        this.db = db;
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
                Car car = configurator.createCar(rs.getInt())
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

//    @Override
//    public List<Car> getAllCars() {
//        Connection con = null;
//        try {
//            con = db.getConnection();
//            String sql = "SELECT * FROM cars";
//            //String sql = "SELECT id,brand,model,engine_type,fuel,torque,volume,power,transmission,gears,years,price,class,VIN,color  FROM cars WHERE id=?";
//            Statement st = con.createStatement();
//
//            ResultSet rs = st.executeQuery(sql);
//            List<Car> cars = new LinkedList<>();
//            while (rs.next()) {
//                engine = createEngine(rs);
//                transmission = createTransmission(rs);
//                car = createCar(rs);
//                cars.add(car);
//            }
//            return cars;
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                con.close();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//        }
//        return null;
//    }
//    @Override
//    public List<Car> getCarByPrice(int start, int end) {
//        Connection con = null;
//        try {
//            con = db.getConnection();
//            String sql = "SELECT * FROM cars";
//            Statement st = con.createStatement();
//
//            ResultSet rs = st.executeQuery(sql);
//            List<Car> cars = new LinkedList<>();
//            while (rs.next()) {
//                if(rs.getInt("price")>=start && rs.getInt("price")<=end) {
//                    engine = createEngine(rs);
//                    transmission = createTransmission(rs);
//                    car = createCar(rs);
//                    cars.add(car);
//                }
//            }
//            return cars;
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                con.close();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//        }
//        return null;
//    }
//    @Override
//    public List<Car> getCarByYear(int start, int end){
//        Connection con = null;
//        try {
//            con = db.getConnection();
//            String sql = "SELECT * FROM cars";
//            Statement st = con.createStatement();
//
//            ResultSet rs = st.executeQuery(sql);
//            List<Car> cars = new LinkedList<>();
//            while (rs.next()) {
//                if(rs.getInt("years")>=start && rs.getInt("years")<=end) {
//                    engine = createEngine(rs);
//                    transmission = createTransmission(rs);
//                    car = createCar(rs);
//                    cars.add(car);
//                }
//            }
//            return cars;
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                con.close();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public List<Car> getCarByBrand(String brand) {
//        Connection con = null;
//        try {
//            con = db.getConnection();
//            String sql = "SELECT * FROM cars";
//            Statement st = con.createStatement();
//
//            ResultSet rs = st.executeQuery(sql);
//            List<Car> cars = new LinkedList<>();
//            while (rs.next()) {
//                if(rs.getString("brand").equals(brand)) {
//                    engine = createEngine(rs);
//                    transmission = createTransmission(rs);
//                    car = createCar(rs);
//                    cars.add(car);
//                }
//            }
//            return cars;
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                con.close();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public List<Car> getCarByModel(String brand, String model) {
//        Connection con = null;
//        try {
//            con = db.getConnection();
//            String sql = "SELECT * FROM cars";
//            Statement st = con.createStatement();
//
//            ResultSet rs = st.executeQuery(sql);
//            List<Car> cars = new LinkedList<>();
//            while (rs.next()) {
//                if(rs.getString("brand").equals(brand) && rs.getString("model").equals(model)) {
//                    engine = createEngine(rs);
//                    transmission = createTransmission(rs);
//                    car = createCar(rs);
//                    cars.add(car);
//                }
//            }
//            return cars;
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                con.close();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//        }
//        return null;
//    }
//}
