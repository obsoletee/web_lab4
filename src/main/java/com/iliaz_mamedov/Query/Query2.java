package com.iliaz_mamedov.Query;
import com.iliaz_mamedov.Connection.JDBC;

import java.sql.*;

public class Query2 {
    public static void main(String[] args) {
        Statement stmt = null;
        try {

            JDBC.connect();

            stmt = JDBC.connection.createStatement();
            String newPublisher[] = { "Pikachu" };
            // reset the auto increment
            for (int i = 0; i < newPublisher.length; i++) {
                String updatePublishersTable = "INSERT INTO Publishers (publisherName)" + "VALUES ('" + newPublisher[i] + "')";
                try {
                    stmt.executeUpdate(updatePublishersTable);
                } catch (SQLException e) {
                    System.out.println("Execute Update Failed!");
                    e.printStackTrace();
                    return;
                }
            }
            System.out.println("New publisher added");

        } catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } finally {
            //finally block used to close resources
            JDBC.close();
        }
    }
}