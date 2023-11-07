package com.company.myapp.details.engine.types;

import com.company.myapp.details.engine.Engine;

public class Electro extends Engine {
    private int power;


    public Electro(int torque, int power) {
        super(torque);
        this.power = power;
        type = "Electro";
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
