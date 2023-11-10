package com.company.myapp.cars.decorators;

import com.company.myapp.cars.Car;

public class ColorBlackWrapDecorator extends CarWrapDecorator {
    public ColorBlackWrapDecorator(Car car){
        super(car);
    }
    @Override
    public String toString() {
        return car.toString() + "\n"+
                "black wrap\n";
    }

    @Override
    public int getPrice(){
        return car.getPrice() + 100;
    }
}