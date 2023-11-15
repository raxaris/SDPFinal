package com.company.myapp.cars.decorators;

import com.company.myapp.cars.ICar;

public class CarbonWrapDecorator extends CarWrapDecorator{
    public CarbonWrapDecorator(ICar car){
        super(car);
    }
    @Override
    public String toString() {
        return car.toString() + "Wrapped in carbon wrap\n";
    }

    @Override
    public int getPrice(){
        return car.getPrice() + 300;
    }
}