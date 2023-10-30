package com.company.myapp.details.transmission.types;

import com.company.myapp.details.transmission.Transmission;

public class Manual extends Transmission {
    private final String type = "Manual";
    private int gear;
    private boolean clutchEngaged;
    private boolean isDriving;

    public Manual() {
        this.gear = 1;
        this.clutchEngaged = false;
        this.isDriving = false;
    }

    public Manual(int numberOfGears) {
        super(numberOfGears);
        this.gear = 1;
        this.clutchEngaged = false;
        this.isDriving = false;
    }

    public void shiftUp() {
        if (clutchEngaged == false && gear < 5) {
            gear++;
        }
    }

    public void shiftDown() {
        if (clutchEngaged == false && gear > 1) {
            gear--;
        }
    }

    public void engageClutch() {
        clutchEngaged = true;
    }

    public void releaseClutch() {
        clutchEngaged = false;
    }

    public void startDriving() {
        isDriving = true;
    }

    public void stopDriving() {
        isDriving = false;
    }

    public String getType() {
        return type;
    }

    public int getGear() {
        return gear;
    }

    public boolean isClutchEngaged() {
        return clutchEngaged;
    }

    public boolean isDriving() {
        return isDriving;
    }
    @Override
    public String toString() {
        return "Type: Manual" + ", " + "Gears: " + getNumberOfGears();
    }
}
