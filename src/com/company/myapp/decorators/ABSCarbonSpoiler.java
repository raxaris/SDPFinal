package com.company.myapp.decorators;

import com.company.myapp.cars.Car;

public class ABSCarbonSpoiler extends CarBodyKitDecorator{
    public ABSCarbonSpoiler(Car car){
        super(car);

    }
    @Override
    public String toString() {
        return car.toString() + "\n"+
                "Mod - Spoiler\n";
    }
}