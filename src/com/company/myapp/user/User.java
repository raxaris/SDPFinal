package com.company.myapp.user;

import com.company.myapp.cars.Car;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final String login;
    private String password;
    private final String email;
    private Cart cart = new Cart();

    public User(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }
    public Cart getCart(){
        return cart;
    }
}
