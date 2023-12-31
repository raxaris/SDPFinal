package com.company.myapp.controllers;

import com.company.myapp.cars.Car;
import com.company.myapp.repositories.Configurator;
import com.company.myapp.repositories.interfaces.ICarRepository;

import java.util.List;

public class CarController {
    private final ICarRepository carRepository;
    private final Configurator configurator;
    public CarController(ICarRepository carRepository) {
        this.carRepository = carRepository;
        this.configurator = new Configurator();
    }
    public boolean addCar(Car car){
        return carRepository.addCar(car);
    }

    public boolean removeCar(Car car){
        return carRepository.deleteCar(car.getId());
    }
    public boolean removeCarByID(int id){
        return carRepository.deleteCar(id);
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

    public List<String> getAllBrands() {
        return carRepository.getAllBrands();
    }

    public List<String> getModelsByBrand(String brand) {
        return carRepository.getModelsByBrand(brand);
    }

    public List<String> getModificationsByBrandAndModel(String brand, String model) {
        return carRepository.getModificationsByBrandAndModel(brand, model);
    }

    public Car getCarByFullName(String brand, String model, String modification) {
        return carRepository.getCarByFullName(brand, model, modification);
    }

    public Configurator getConfigurator(){
        return configurator;
    }
}
