package com.company.myapp.data;
import com.company.myapp.data.interfaces.IDB;

import java.sql.*;
public class DBSingleton implements IDB {
    private static DBSingleton instance;
    private DBSingleton(){};
    public static DBSingleton getInstance() {
        if (instance == null) {
            synchronized (DBSingleton.class) {
                if (instance == null) {
                    instance = new DBSingleton();
                }
            }
        }
        return instance;
    }
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String connectionUrl = "jdbc:postgresql://localhost:5432/cars";
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(connectionUrl, "postgres", "123");
        } catch (Exception e) {
            throw new SQLException("Failed to get a database connection.", e);
        }
    }

    public void closeConnection(Connection connection) throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}