package com.company.myapp.details.engine.Adapter;

import com.company.myapp.details.engine.Adapter.Interfaces.ElectricPower;
import com.company.myapp.details.engine.Adapter.Interfaces.GasolineType;

public class GasolineToElectricity implements ElectricPower{
    GasolineType gasolineType;
    public GasolineToElectricity(GasolineType gasolineType) {
        this.gasolineType = gasolineType;
    }
    private String convertGasolineToElectricity(){
        return "22000 W electricity";
    }
    @Override
    public String getType() {
        return convertGasolineToElectricity();
    }
}
