package com.util;

import java.sql.Connection;

public class Program {
    public static void main(String[] args) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            if (conn != null && !conn.isClosed()) {
                System.out.println("Connection is Success");
            } else {
                System.out.println("Connection is Failed");
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Connection is failed due to: " + e.getMessage());
        }
    }
}
