package com.company.myapp.user;

import com.company.myapp.user.inferfaces.IUser;

public class User implements IUser {
    private int id;
    private final String login;
    private String password;
    private final String email;
    private Cart cart;
    private final boolean isAdmin;
    public User(int id, String login,String password, String email, boolean isAdmin) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.isAdmin = isAdmin;
        this.cart = new Cart();
    }

    public User(int id, String login, String password, String email, boolean isAdmin, Cart cart) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.isAdmin = isAdmin;
        this.cart = cart;
    }

    public User(String login, String password, String email, boolean isAdmin) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.isAdmin = isAdmin;
    }

    public int getId() {
        return id;
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
        System.out.println(login + ": " + message);
    }

    public boolean isAdmin() {
        return isAdmin;
    }
}
