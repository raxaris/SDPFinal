package com.company.myapp.controllers;

import com.company.myapp.cars.Car;
import com.company.myapp.repositories.interfaces.ICarRepository;

import java.util.List;

public class CarController {
    private final ICarRepository repo;

    public CarController(ICarRepository repo) {
        this.repo = repo;
    }

    public String getCar(int id) {
        Car car = repo.getCar(id);
        return (car == null ? "Car was not found!" : car.toString());
    }

    private void displayCars(List<Car> cars) {
        if (cars == null || cars.isEmpty()) {
            System.out.println("Cars were not found!");
        } else {
            for (Car car : cars) {
                System.out.println(car.toString());
            }
        }
    }
    public void getAllCars() {
        List<Car> cars = repo.getAllCars();
        displayCars(cars);
    }

    public void getCarByPrice(int start, int end) {
        List<Car> cars = repo.getCarByPrice(start, end);
        displayCars(cars);
    }

    public void getCarByYear(int start, int end) {
        List<Car> cars = repo.getCarByYear(start, end);
        displayCars(cars);
    }

    public void getCarByBrand(String brand) {
        List<Car> cars = repo.getCarByBrand(brand);
        displayCars(cars);
    }

    public void getCarByModel(String brand, String model) {
        List<Car> cars = repo.getCarByModel(brand, model);
        displayCars(cars);
    }
}

