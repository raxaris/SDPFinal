package com.company.myapp.decorators;

import com.company.myapp.cars.Car;

public class SprinterBumpers extends CarBodyKitDecorator {
    public SprinterBumpers(Car car) {
        super(car);
    }

    @Override
    public String toString() {
        return car.toString() +
                "Mod - SprBumpers\n";
    }
}