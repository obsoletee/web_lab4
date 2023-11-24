package com.iliaz_mamedov.Query;
import com.iliaz_mamedov.Connection.JDBC;

import java.sql.*;

public class Query7 {
    public static void main(String[] args) {
        Statement stmt = null;
        try {

            JDBC.connect();

            stmt = JDBC.connection.createStatement();
            String newTitle[] = { "The Idiot" };
            int newEditionNumber = 7;
            int newYear = 1869;
            int newPrice = 10;

            for (int i = 0; i < newTitle.length; i++) {
                String updateTitlesTable = "INSERT INTO Titles (isbn, title, editionNumber, year, publisherID, price)"
                        + "VALUES ('0145449579', '" + newTitle[i] + "', " + newEditionNumber + ",'" + newYear + "', (SELECT publisherID FROM Publishers WHERE publisherName = 'Squirtle')," + newPrice + ")";
                try {
                    stmt.executeUpdate(updateTitlesTable);
                } catch (SQLException e) {
                    System.out.println("Execute INSERT Failed!");
                    e.printStackTrace();
                    return;
                }
            }
            System.out.println("New title added");
            String updateAuthorISBNTable = "INSERT INTO AuthorISBN (authorID, isbn) " + "VALUES ((SELECT authorID FROM Authors WHERE firstName = 'Ivan'), '0152479570')";
                try {
                    stmt.executeUpdate(updateAuthorISBNTable);
                } catch (SQLException e) {
                    System.out.println("Execute INSERT Failed!");
                    e.printStackTrace();
                    return;
                }

            System.out.println("New author ISBN added");

        } catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } finally {
            //finally block used to close resources
            JDBC.close();
        }
    }
}