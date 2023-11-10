package com.company.myapp.details.engine.Adapter;

import com.company.myapp.details.engine.Adapter.Interfaces.GasolineType;

public class GasolineAI92 implements GasolineType {
    @Override
    public String getType() {
        return "AI92";
    }
}
