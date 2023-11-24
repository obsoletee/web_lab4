package com.iliaz_mamedov.Query;
import com.iliaz_mamedov.Connection.JDBC;

import java.sql.*;

public class Query1 {
    public static void main(String[] args) {
        Statement stmt = null;
        try {

            JDBC.connect();

            stmt = JDBC.connection.createStatement();
            String query1Author = "SELECT * FROM authors ORDER BY firstName ASC, lastName ASC";
            System.out.println("Authors sorted by first name:");

            ResultSet rs1 = stmt.executeQuery(query1Author);
            while (rs1.next()) {
                int id = rs1.getInt("authorID");
                String firstName = rs1.getString("firstName");
                String lastName = rs1.getString("lastNAme");
                System.out.println(id + "\t" + firstName + "\t" + lastName);
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