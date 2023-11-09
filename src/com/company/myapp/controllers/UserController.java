package com.company.myapp.controllers;

import com.company.myapp.user.User;
import com.company.myapp.repositories.interfaces.IUserRepository;

import java.util.List;

public class UserController {
    private final IUserRepository repo;

    public UserController(IUserRepository repo) {
        this.repo = repo;
    }

    public boolean addUser(User user) {
        return repo.addUser(user);
    }

    public boolean removeUser(User user){
        return repo.deleteUser(user.getId());
    }

    public String getUser(int id) {
        User user = repo.getUserByID(id);
        return (user == null ? "User was not found!" : user.toString());
    }

    public List<User> getAllUsers() {
        List<User> users = repo.getAllUsers();
        return users;
    }

    public User getUserCredentials(String login, String password) {
        return repo.getUserByCredentials(login, password);
    }

    public boolean isLoginAvailable(String login){
        return repo.isLoginAvailable(login);
    }
}
