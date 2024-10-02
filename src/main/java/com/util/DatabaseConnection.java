package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DatabaseConnection {
    private static final String PROPERTIES_FILE = "/database.properties";
    private static Properties props = new Properties();

    static {
        try (InputStream is = DatabaseConnection.class.getResourceAsStream(PROPERTIES_FILE)) {
            props.load(is);
        } catch (IOException e) {
            throw new ExceptionInInitializerError("Failed to load database properties");
        }
    }

    public static Connection getConnection() throws SQLException {
        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String password = props.getProperty("db.password");

        return DriverManager.getConnection(url, user, password);
    }
}