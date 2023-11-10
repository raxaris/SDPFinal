package com.company.myapp.details.engine.types;

import com.company.myapp.details.engine.Adapter.Interfaces.GasolineType;
import com.company.myapp.details.engine.Engine;

public class ICEStrategy extends Engine {
    private int torque;
    private double engineVolume;
    private int horsePower;
    private String typeOfFuel;

    public ICEStrategy(int torque, double engineVolume, int horsepower, String typeOfFuel) {
        this.torque = torque;
        this.engineVolume = engineVolume;
        this.horsePower = horsepower;
        this.typeOfFuel = typeOfFuel;
        type = "ICE";
    }

    public void startEngine(GasolineType gasoline) {
        System.out.println("Sound of " + engineVolume + "L, " + horsePower + "HP " + "engine." );
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
    public int getTorque() {
        return torque;
    }

    public String toString() {
        return "ICE " + "\n" + "Torque: "
                + getTorque() +
                ", Power: " + horsePower + ", Volume: " + engineVolume + ", Fuel:" + typeOfFuel;
    }
}
