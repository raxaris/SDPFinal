package com.company.myapp.controllers;

import com.company.myapp.repositories.interfaces.IUserRepository;
import com.company.myapp.user.User;


import java.util.List;

public class UserController {
    private final IUserRepository userRepository;

    public UserController(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean addUser(User user) {
        return userRepository.addUser(user);
    }

    public boolean  removeUser(User user){
        return userRepository.deleteUser(user.getId());
    }

    public String getUser(int id) {
        User user = userRepository.getUserByID(id);
        return (user == null ? "User was not found!" : user.toString());
    }

    public List<User> getAllUsers() {
        List<User> users = userRepository.getAllUsers();
        return users;
    }

    public User getUserCredentials(String login, String password) {
        return userRepository.getUserByCredentials(login, password);
    }

    public boolean isLoginAvailable(String login){
        return userRepository.isLoginAvailable(login);
    }
}
