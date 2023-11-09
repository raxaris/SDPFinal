package com.company.myapp.user;

import com.company.myapp.controllers.UserController;
import com.company.myapp.repositories.UserRepository;
import com.company.myapp.user.User;

public class LoginSystem {
    UserController userController;

    public LoginSystem(UserController userController) {
        this.userController = userController;
    }

    public boolean registrateUser(User user){

        return userController.addUser(user);
    }

    public User login(String login, String password){
        User user = userController.getUserCredentials(login,password);
        return user;
    }
}
