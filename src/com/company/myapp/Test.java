package com.company.myapp;

import com.company.myapp.cars.Car;
import com.company.myapp.cars.brands.BMW;
import com.company.myapp.controllers.UserController;
import com.company.myapp.data.DBSingleton;
import com.company.myapp.data.interfaces.IDB;
import com.company.myapp.decorators.ABSCarbonSpoiler;
import com.company.myapp.decorators.CarBodyKitDecorator;
import com.company.myapp.decorators.CarbonSideSkirts;
import com.company.myapp.decorators.SprinterBumpers;
import com.company.myapp.details.engine.Adapter.GasolineAI92;
import com.company.myapp.details.engine.Adapter.Interfaces.GasolineType;
import com.company.myapp.details.engine.types.ElectroEngineStrategy;
import com.company.myapp.details.engine.types.ICEStrategy;
import com.company.myapp.details.transmission.types.Auto;
import com.company.myapp.repositories.CarRepository;
import com.company.myapp.repositories.UserRepository;

public class Test {
    public static void main(String[] args) {
//        IDB db = DBSingleton.getInstance();
//        UserRepository repo = new UserRepository(db);
//        UserController controller = new UserController(repo);
//        controller.isLoginAvailable("beka")
        BMW M5 = new BMW(15,"M5",new ICEStrategy(455,3,500,"AI950"),new Auto(),500,"White",2023,250000);
        Car M5_modded = new ABSCarbonSpoiler(M5);
        Car M5_modded1 = new CarbonSideSkirts(M5_modded);
        Car M5_modded2 = new SprinterBumpers(M5_modded1);
        M5_modded2.startEngine ();
        BMW I8 = new BMW(16,"I8",new ElectroEngineStrategy(400,500),new Auto(),5555.0,"black",2015,20000000);
        I8.startEngine();

    }
}
