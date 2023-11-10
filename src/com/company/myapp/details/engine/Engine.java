package com.company.myapp.details.engine;

import com.company.myapp.details.engine.interfaces.IEngineStrategy;

public abstract class Engine implements IEngineStrategy {
    protected String type;
    public Engine() {
    }
    public String getType() {
        return type;
    }
    public abstract void startEngine();
}
