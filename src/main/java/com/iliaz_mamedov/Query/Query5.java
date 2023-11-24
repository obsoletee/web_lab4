package com.iliaz_mamedov.Query;
import com.iliaz_mamedov.Connection.JDBC;

import java.sql.*;

public class Query5 {
    public static void main(String[] args) {
        Statement stmt = null;
        try {

            JDBC.connect();

            stmt = JDBC.connection.createStatement();
            String newAuthorFirstName[] = { "Fyodor" };
            String newAuthorLastName[] = { "Dostoevsky" };
            for (int i = 0; i < newAuthorFirstName.length; i++) {
                String updateAuthorsTable = "INSERT INTO Authors (firstName, lastName)" + "VALUES ('" + newAuthorFirstName[i]
                        + "', '" + newAuthorLastName[i] + "');";
                try {
                    stmt.executeUpdate(updateAuthorsTable);
                } catch (SQLException e) {
                    System.out.println("Execute INSERT Failed!");
                    e.printStackTrace();
                    return;
                }
            }
            System.out.println("New author added");

        } catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } finally {
            //finally block used to close resources
            JDBC.close();
        }
    }
}