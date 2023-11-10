package com.company.myapp.decorators;

import com.company.myapp.cars.Car;

public class CarbonSideSkirts extends CarBodyKitDecorator{
    public CarbonSideSkirts(Car car) {
        super(car);
    }

    @Override
    public String toString() {
        return car.toString() +
                "Mod - Carbon Side Skirts\n";
    }
}