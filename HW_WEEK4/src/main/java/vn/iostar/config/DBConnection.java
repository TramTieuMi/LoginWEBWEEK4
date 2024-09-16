package vn.iostar.config;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/login_register";
    
    // Register MySQL driver
    static {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        } catch (SQLException e) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, "Failed to register MySQL driver.", e);
        }
    }

    // Method to get database connection
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, "Failed to establish database connection.", e);
        }
        return connection;
    }

    // Main method to test connection
    public static void main(String[] args) {
        try (Connection connection = getConnection()) {
            if (connection != null) {
                System.out.println("Database connection successful.");
            } else {
                System.out.println("Failed to connect to the database.");
            }
        } catch (Exception e) {
            System.err.println("An error occurred while testing the database connection.");
            e.printStackTrace();
        }
    }
}
