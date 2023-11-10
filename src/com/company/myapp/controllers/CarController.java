package com.company.myapp.controllers;

import com.company.myapp.cars.Car;
import com.company.myapp.repositories.interfaces.ICarRepository;

import java.util.List;

public class CarController {
    private final ICarRepository carRepository;

    public CarController(ICarRepository carRepository) {
        this.carRepository = carRepository;
    }
    public boolean addCar(Car car){
        return carRepository.addCar(car);
    }

    public boolean removeCar(Car car){
        return carRepository.deleteCar(car.getId());
    }

    public Car getCar(int id) {
        Car car = carRepository.getCar(id);
        return car;
    }

    public List<Car> getAllCars() {
        List<Car> cars = carRepository.getAllCars();
        return cars;
    }

    public List<Car> getCarByPrice(int start, int end) {
        List<Car> cars = carRepository.getCarByPrice(start, end);
        return cars;
    }

    public List<Car> getCarByYear(int start, int end) {
        List<Car> cars = carRepository.getCarByYear(start, end);
        return cars;
    }

    public List<Car> getCarByBrand(String brand) {
        List<Car> cars = carRepository.getCarByBrand(brand);
        return cars;
    }

    public List<Car> getCarByModel(String brand, String model) {
        List<Car> cars = carRepository.getCarByModel(brand, model);
        return cars;
    }
}
