package com.company.myapp.details.engine.types;

import com.company.myapp.details.engine.Engine;

public class Electro extends Engine {
    private final String type = "Electro";
    private int power;


    public Electro(double torque, int power) {
        super(torque);
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Electro " + "\n" + "Torque: "
                + getTorque() +
                ", Power: " + power;
    }
}
