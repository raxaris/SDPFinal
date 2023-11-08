package com.company.myapp.controllers;

import com.company.myapp.cars.Car;
import com.company.myapp.repositories.interfaces.ICarRepository;

import java.util.List;

public class CarController {
    private final ICarRepository repo;

    public CarController(ICarRepository repo) {
        this.repo = repo;
    }
    public boolean addCar(Car car){
       return repo.addCar(car);
    }
    public String getCar(int id) {
        Car car = repo.getCar(id);
        return (car == null ? "Car was not found!" : car.toString());
    }

    public List<Car> getAllCars() {
        List<Car> cars = repo.getAllCars();
        return cars;
    }

    public List<Car> getCarByPrice(int start, int end) {
        List<Car> cars = repo.getCarByPrice(start, end);
        return cars;
    }

    public List<Car> getCarByYear(int start, int end) {
        List<Car> cars = repo.getCarByYear(start, end);
        return cars;
    }

    public List<Car> getCarByBrand(String brand) {
        List<Car> cars = repo.getCarByBrand(brand);
        return cars;
    }

    public List<Car> getCarByModel(String brand, String model) {
        List<Car> cars = repo.getCarByModel(brand, model);
        return cars;
    }
}
