package com.company.myapp.details.engine.types;

import com.company.myapp.details.engine.Engine;

public class ElectroEngineStrategy extends Engine {
    private int power;
    private int torque;

    public ElectroEngineStrategy(int torque, int power) {
        this.torque = torque;
        this.power = power;
        type = "Electro";
    }

    public int getPower() {
        return power;
    }


    public void startEngine() {
        System.out.println("No sound.");
    }

    public int getTorque() {
        return torque;
    }
    @Override
    public String toString() {
        return "Electro " + "\n" + "Torque: "
                + getTorque() +
                ", Power: " + power;
    }
}
