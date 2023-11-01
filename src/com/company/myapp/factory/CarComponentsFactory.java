package com.company.myapp.factory;

import com.company.myapp.details.engine.Engine;
import com.company.myapp.details.transmission.Transmission;

public interface CarComponentsFactory {
    public Engine createEngine();
    public Transmission createTransmission();
}
