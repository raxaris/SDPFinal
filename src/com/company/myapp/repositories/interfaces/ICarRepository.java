package com.company.myapp.repositories.interfaces;

import com.company.myapp.cars.Car;

import java.util.List;

public interface ICarRepository {
    Car getCar(int id);
    List<Car> getAllCars();
    List<Car> getCarByPrice(int start, int end);
    List<Car> getCarByYear(int start, int end);
    List<Car> getCarByBrand(String brand);
    List<Car> getCarByModel(String brand, String model);
    List<String> getAllBrands();
    List<String> getModelsByBrand(String brand);
    List<String> getModificationsByBrandAndModel(String brand, String model);
    Car getCarByFullName(String brand, String model, String modification);
    boolean addCar(Car car);
    boolean deleteCar(int id);
}
