package com.company.myapp.details.transmission;

public abstract class Transmission {
    protected String type;
    private int numberOfGears;
    public Transmission() {
    }

    public Transmission(int numberOfGears) {
        this.numberOfGears = numberOfGears;
    }


    //setters
    public void setNumberOfGears(int numberOfGears) {
        this.numberOfGears = numberOfGears;
    }
    //getters
    public int getNumberOfGears() {
        return numberOfGears;
    }
    public String getType(){
        return type;
    }
}

