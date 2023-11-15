package com.company.myapp.cars.decorators;

import com.company.myapp.cars.ICar;

public class PolyurethaneWrap extends CarWrapDecorator{
    public PolyurethaneWrap(ICar car){
        super(car);
    }

    @Override
    public String toString() {
        return car.toString() + "Wrapped in polyurethane defense wrap\n";
    }

    @Override
    public int getPrice(){
        return car.getPrice() + 500;
    }
}