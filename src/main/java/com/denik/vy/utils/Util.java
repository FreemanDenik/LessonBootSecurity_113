package com.denik.vy.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String HOST_NAME = "localhost";
    private static final String DB_NAME = "denik_db";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "12345";
    private static final String CONNECTION_URL = String.format("jdbc:mysql://%s:3306/%s", HOST_NAME, DB_NAME);

    public static Connection DBConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(CONNECTION_URL, USER_NAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return connection;
        }
    }
}
