package com.company.myapp.details.engine;
public abstract class Engine {
    private double torque;//крутящий момент
    public Engine(double torque) {
        this.torque = torque;

    }
    public double getTorque() {
        return torque;
    }

}
