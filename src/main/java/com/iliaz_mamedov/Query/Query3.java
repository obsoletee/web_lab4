package com.iliaz_mamedov.Query;
import com.iliaz_mamedov.Connection.JDBC;

import java.sql.*;

public class Query3 {
    public static void main(String[] args) {
        Statement stmt = null;
        try {

            JDBC.connect();

            stmt = JDBC.connection.createStatement();
            try {
                String updatePublishersTable = "UPDATE publishers SET publisherName = 'Squirtle' WHERE publisherName = 'Pikachu'";
                stmt.executeUpdate(updatePublishersTable);
                System.out.println("Publisher pikachu changed to Squirtle");
            } catch (SQLException e) {
                System.out.println("Execute Update Failed!");
                e.printStackTrace();
                return;
            }
            try {
                String printPublishersTable = "SELECT * FROM publishers";
                ResultSet rs3 = stmt.executeQuery(printPublishersTable);
                while (rs3.next()) {
                    int id = rs3.getInt("publisherID");
                    String publisherName = rs3.getString("publisherName");
                    System.out.println(id + "\t" + publisherName);
                }
            } catch (SQLException e) {
                System.out.println("Execute Update Failed!");
                e.printStackTrace();
                return;
            }

        } catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } finally {
            //finally block used to close resources
            JDBC.close();
        }
    }
}