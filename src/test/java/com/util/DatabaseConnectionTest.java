package com.util;

import org.junit.Test;
import static org.junit.Assert.*;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnectionTest {

    @Test
    public void testDatabaseConnection() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            assertNotNull("Connection should not be null", conn);
            assertTrue("Connection should be valid", !conn.isClosed());
            System.out.println("Database connection successful!");
        } catch (SQLException e) {
            fail("Should not have thrown any SQLException: " + e.getMessage());
        }
    }
}