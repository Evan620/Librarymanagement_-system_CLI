package com.evan.library.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
        public static Connection getConnection() throws SQLException {
            String url = "jdbc:mysql://localhost:3306/librarydb"; // Replace with your database URL
            String username = "root"; // Replace with your MySQL username
            String password = "Evan@2002"; // Replace with your MySQL password
            return DriverManager.getConnection(url, username, password);
        }
}

