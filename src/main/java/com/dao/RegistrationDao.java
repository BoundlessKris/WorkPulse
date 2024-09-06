package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.model.RegModel;

import java.sql.PreparedStatement;

public class RegistrationDao {
    private static final String URL = "jdbc:mysql://localhost:3306/user_info";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";

    static {
        try {
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
    public boolean saveRegistration(RegModel regModel) {
        boolean status = false;
        try (Connection connection = RegistrationDao.getConnection()) {
            String query = "INSERT INTO user (name, email, username,password) VALUES (?, ?, ?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, regModel.getName());
            ps.setString(2, regModel.getEmail());
            ps.setString(3, regModel.getUsername());
            ps.setString(4, regModel.getPassword());
            status = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
}
