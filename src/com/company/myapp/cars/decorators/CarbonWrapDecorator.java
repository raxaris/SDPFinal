package com.company.myapp.cars.decorators;

import com.company.myapp.cars.Car;

public class CarbonWrapDecorator extends CarWrapDecorator{
    public CarbonWrapDecorator(Car car){
        super(car);
    }
    @Override
    public String toString() {
        return car.toString() + "\n"+
                "wrapped in carbon wrap\n";
    }

    @Override
    public int getPrice(){
        return car.getPrice() + 300;
    }
}