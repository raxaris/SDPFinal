package com.company.myapp.details.engine.Adapter;

import com.company.myapp.details.engine.Adapter.Interfaces.ElectricPower;

public class Wire22kW implements ElectricPower {
    @Override
    public String getType() {
        return "22000 W electricity";
    }
}
