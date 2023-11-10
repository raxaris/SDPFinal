package com.company.myapp.application;

import com.company.myapp.application.interfaces.IApplicationStrategy;
import com.company.myapp.controllers.CarController;
import com.company.myapp.controllers.UserController;
import com.company.myapp.user.User;

import java.util.Scanner;

public class MyApplication1 {
    private final Authenticator authenticator;
    private final CarController carController;
    private final Scanner scanner;
    private IApplicationStrategy userApplication;

    public MyApplication1(CarController carController, UserController userController) {
        this.scanner = new Scanner(System.in);
        this.authenticator = new Authenticator(userController, scanner);
        this.carController = carController;
    }

    public void start() {
        User authenticatedUser = authenticator.authenticate();

        if (authenticatedUser != null) {
            if (authenticatedUser.isAdmin()) {
                setApplicationStrategy(new AdminApplication(carController,scanner,authenticatedUser));
            } else {
                setApplicationStrategy(new UserApplication(carController,scanner,authenticatedUser));
            }

            userApplication.start();
        }
    }
    private void setApplicationStrategy(IApplicationStrategy strategy) {
        this.userApplication = strategy;
    }
}

