package com.company.myapp.cars.decorators;

import com.company.myapp.cars.Car;

public class PolyurethaneWrap extends CarWrapDecorator{
    public PolyurethaneWrap(Car car) {
        super(car);
    }

    @Override
    public String toString() {
        return car.toString() + "\n"+
                ", wrapped in polyurethane defense wrap\n";
    }

    @Override
    public int getPrice(){
        return car.getPrice() + 500;
    }
}