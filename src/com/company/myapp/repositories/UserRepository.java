package com.company.myapp.repositories;

import com.company.myapp.data.interfaces.IDB;
import com.company.myapp.repositories.interfaces.IUserRepository;
import com.company.myapp.user.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    private final IDB db;
    Configurator configurator = new Configurator();

    public UserRepository(IDB db) {
        this.db = db;
    }

    @Override
    public User getUserByID(int id) {
        try (Connection con = db.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE id = ?")) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    User user = configurator.createUserFromResultSet(rs);
                    return user;
                } else {
                    return null;
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<User> getAllUsers() {
        try (Connection con = db.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM users")) {

            List<User> users = new ArrayList<>();
            while (rs.next()) {
                User user = configurator.createUserFromResultSet(rs);
                users.add(user);
            }
            return users;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public boolean addUser(User user) {
        try (Connection con = db.getConnection();
             PreparedStatement ps = con.prepareStatement("INSERT INTO users (login, password, email, isAdmin) VALUES (?, ?, ?, ?)")) {

            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.setBoolean(4, user.isAdmin());

            return ps.executeUpdate() > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteUser(int id) {
        try (Connection con = db.getConnection();
             PreparedStatement ps = con.prepareStatement("DELETE FROM users WHERE id = ?")) {

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public User getUserByCredentials(String login, String password) {
        try (Connection con = db.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE login = ? AND password = ?")) {
            ps.setString(1, login);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return configurator.createUserFromResultSet(rs);
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
    @Override
    public boolean isLoginAvailable(String login) {
        try (Connection con = db.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE login = ?")) {
            ps.setString(1, login);

            try (ResultSet rs = ps.executeQuery()) {
                return !rs.next();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}
