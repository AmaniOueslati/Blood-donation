/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Database connection utility class.
 * Singleton pattern is not implemented here, but you might want to consider it.
 */
public class Dbconnect {

    private static final String URL = "jdbc:mysql://Amani@localhost/amani?serverTimezone=UTC";
    private static final String USERNAME = "Amani";
    private static final String PASSWORD = "20102001";

    /**
     * Establishes a connection to the database.
     *
     * @return Connection object if successful, otherwise null.
     */
    public static Connection connection() {
        Connection conn = null;
        try {
            // Attempt to connect
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connected to the database");
        } catch (SQLException e) {
            System.out.println("Error connecting to the database");
            e.printStackTrace();
        }
        return conn;
    }

  
    public static void main(String[] args) {
        // Call the connection method
        Connection conn = connection();

        // Perform additional operations using the connection if needed

        // Close the connection when done
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Connection closed");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
