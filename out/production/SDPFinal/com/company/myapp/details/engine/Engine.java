package com.company.myapp.details.engine;
public abstract class Engine {
    protected String type;
    private int torque;//крутящий момент
    public Engine(int torque) {
        this.torque = torque;

    }
    public int getTorque() {
        return torque;
    }

    public String getType() {
        return type;
    }
}
