package com.company.myapp.user;

import com.company.myapp.cars.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;

public class User {
    private final String login;
    private String password;
    private final String email;
    private Cart cart;

    public User(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.cart = new Cart();
    }

    public User(String login, String password, String email, Cart cart) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.cart = cart;
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
    public void update(String message){
        System.out.println(message);
    }
}
