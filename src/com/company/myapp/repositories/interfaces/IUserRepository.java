package com.company.myapp.repositories.interfaces;

import com.company.myapp.user.User;
import java.util.List;

public interface IUserRepository {
    User getUserByID(int id);
    List<User> getAllUsers();
    boolean addUser(User user);
    boolean deleteUser(int id);
    User getUserByCredentials(String login, String password);
    boolean isLoginAvailable(String login);
}
