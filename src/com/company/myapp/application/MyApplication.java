package com.company.myapp.application;

import com.company.myapp.application.interfaces.IApplicationStrategy;
import com.company.myapp.controllers.CarController;
import com.company.myapp.controllers.UserController;
import com.company.myapp.user.User;


public class MyApplication {
    private final Authenticator authenticator;
    private final CarController carController;
    private final UserController userController;
    private IApplicationStrategy userApplication;

    public MyApplication(CarController carController, UserController userController) {
        this.authenticator = new Authenticator(userController);
        this.carController = carController;
        this.userController = userController;
    }

    public void start() {
        User authenticatedUser = authenticator.authenticate();

        if (authenticatedUser != null) {
            if (authenticatedUser.isAdmin()) {
                setApplicationStrategy(new AdminApplication(carController, userController, authenticatedUser));
            } else {
                setApplicationStrategy(new UserApplication(carController,authenticatedUser));
            }

            userApplication.start();
        }
    }
    private void setApplicationStrategy(IApplicationStrategy strategy) {
        this.userApplication = strategy;
    }
}

