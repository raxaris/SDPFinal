package com.company.myapp.details.engine.types;

import com.company.myapp.details.engine.Engine;

public class Electro extends Engine {
    private int power;
    private int torque;

    public Electro(int torque, int power) {
        this.torque = torque;
        this.power = power;
        type = "Electro";
    }

    public int getPower() {
        return power;
    }

    public String getType() {
        return type;
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
