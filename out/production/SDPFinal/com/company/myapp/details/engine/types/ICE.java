package com.company.myapp.details.engine.types;

import com.company.myapp.details.engine.Engine;

public class ICE extends Engine {
    private double engineVolume;
    private int horsePower;
    private String typeOfFuel;

    public ICE(int torque, double engineVolume, int horsepower, String typeOfFuel) {
        super(torque);
        this.engineVolume = engineVolume;
        this.horsePower = horsepower;
        this.typeOfFuel = typeOfFuel;
        type = "ICE";
    }
    public String getType() {
        return type;
    }

    public double getEngineVolume() {
        return engineVolume;
    }


    public int getHorsepower() {
        return horsePower;
    }


    public String getTypeOfFuel() {
        return typeOfFuel;
    }

    public void setTypeOfFuel(String typeOfFuel) {
        this.typeOfFuel = typeOfFuel;
    }

    public String toString() {
        return "ICE " + "\n" + "Torque: "
                + getTorque() +
                ", Power: " + horsePower + ", Volume: " + engineVolume + ", Fuel:" + typeOfFuel;
    }
}
