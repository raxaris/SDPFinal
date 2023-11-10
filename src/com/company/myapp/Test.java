package com.company.myapp;

import com.company.myapp.cars.Car;
import com.company.myapp.cars.brands.BMW;
import com.company.myapp.cars.decorators.CarbonWrapDecorator;
import com.company.myapp.cars.decorators.PolyurethaneWrap;
import com.company.myapp.cars.decorators.ColorBlackWrapDecorator;
import com.company.myapp.details.engine.types.ICEStrategy;
import com.company.myapp.details.transmission.types.Auto;

public class Test {
    public static void main(String[] args) {
//        IDB db = DBSingleton.getInstance();
//        UserRepository repo = new UserRepository(db);
//        UserController controller = new UserController(repo);
//        controller.isLoginAvailable("beka")
        BMW M5 = new BMW(15,"M5",new ICEStrategy(455,3,500,"AI950"),new Auto(),500,"White",2023,250000);
        Car M5_modded = new CarbonWrapDecorator(M5);
        Car M5_modded1 = new PolyurethaneWrap(M5_modded);
        Car M5_modded2 = new ColorBlackWrapDecorator(M5_modded1);
        M5_modded2.startEngine();
    }
}
