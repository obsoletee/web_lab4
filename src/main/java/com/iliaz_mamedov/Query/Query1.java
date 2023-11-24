package com.iliaz_mamedov.Query;
import com.iliaz_mamedov.Connection.JDBC;

import java.sql.*;

public class Query1 {
    public static void main(String[] args) {
        Statement stmt = null;
        try {

            JDBC.connect();

            stmt = JDBC.connection.createStatement();
            String query2Author = "SELECT * FROM titles";
            System.out.println("Show all publishers");

            ResultSet rs1 = stmt.executeQuery(query2Author);
            while (rs1.next()) {
                int id = rs1.getInt("publisherID");
                String pubName = rs1.getString("title");
                System.out.println(id + "\t" + pubName);
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