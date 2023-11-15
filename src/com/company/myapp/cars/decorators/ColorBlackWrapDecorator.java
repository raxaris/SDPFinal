package com.company.myapp.cars.decorators;

import com.company.myapp.cars.ICar;

public class ColorBlackWrapDecorator extends CarWrapDecorator{
    public ColorBlackWrapDecorator(ICar car){
        super(car);
    }
    @Override
    public String toString() {
        return car.toString() + "Wrapped in matte black wrap\n";
    }

    @Override
    public int getPrice(){
        return car.getPrice() + 100;
    }
}