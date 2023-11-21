package com.company.myapp;

import com.company.myapp.adapter.SqlFileSaver;
import com.company.myapp.adapter.SqlToTxtFileAdapter;
import com.company.myapp.adapter.TxtFileSaver;
import com.company.myapp.application.MyApplication;
import com.company.myapp.cars.Car;
import com.company.myapp.controllers.CarController;
import com.company.myapp.controllers.UserController;
import com.company.myapp.data.DBSingleton;
import com.company.myapp.data.interfaces.IDB;
import com.company.myapp.repositories.CarRepository;
import com.company.myapp.repositories.UserRepository;

public class Test {
    public static void main(String[] args) {
        SqlFileSaver sql = new SqlFileSaver();
        sql.saveToSqlFile("test.sql", "Hello world!");
        System.out.println(sql.loadFromSqlFile("test.sql"));
        System.out.println("*****************");
        TxtFileSaver txt = new TxtFileSaver();
        IDB db = DBSingleton.getInstance();
        CarRepository repo = new CarRepository(db);
        Car car = repo.getCar(23);
        String carInfo = car.toString();
        txt.saveToTxtFile("carInfo.txt", carInfo);
        System.out.println(txt.loadFromTxtFile("carInfo.txt"));
        System.out.println("*****************");
        SqlToTxtFileAdapter adapter = new SqlToTxtFileAdapter(sql);
        adapter.saveToTxtFile("carInfo.txt", "Test2");
        System.out.println(adapter.loadFromTxtFile("carInfo.txt"));
    }
}
