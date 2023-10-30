package com.company.myapp.details.transmission;

public class Transmission {
    private int numberOfGears;
    //constructors
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
    
}

