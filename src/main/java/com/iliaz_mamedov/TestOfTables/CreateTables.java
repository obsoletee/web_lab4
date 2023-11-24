package com.iliaz_mamedov.TestOfTables;

import com.iliaz_mamedov.Connection.JDBC;

import java.util.*;
import java.sql.*;
public class CreateTables {
    public static void main(String[] args) {
        Statement stmt = null;
        try {
            System.out.println("This will DELETE all data, do you want to continue? (y/n)");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("Y")) {
                // Open a connection
                JDBC.connect();
                stmt = JDBC.connection.createStatement();

                // Drop Tables
                String drop1 = "DROP TABLE IF EXISTS Authors";
                stmt.executeUpdate(drop1);

                String drop2 = "DROP TABLE IF EXISTS Titles";
                stmt.executeUpdate(drop2);

                String drop3 = "DROP TABLE IF EXISTS Publishers";
                stmt.executeUpdate(drop3);

                String drop4 = "DROP TABLE IF EXISTS AuthorISBN";
                stmt.executeUpdate(drop4);
                System.out.println("Data deleted");

                // Create Tables
                String authorsTable = "CREATE TABLE Authors" +
                        "(authorID INTEGER NOT NULL AUTO_INCREMENT," +
                        "firstName CHAR(20)," +
                        "lastName CHAR(20)," +
                        "PRIMARY KEY (authorID))";

                stmt.executeUpdate(authorsTable);
                System.out.println("Created Authors table");

                String titlesTable = "CREATE TABLE Titles " +
                        "(isbn CHAR(13) not NULL," +
                        "title VARCHAR(255)," +
                        "editionNumber INTEGER," +
                        "year CHAR(4)," +
                        "publisherID INTEGER REFERENCES Publishers(publisherID)," +
                        "price DECIMAL(8,2)," +
                        "PRIMARY KEY (isbn))";
                stmt.executeUpdate(titlesTable);
                System.out.println("Created Titles table");

                String publishersTable = "CREATE TABLE Publishers " +
                        "(publisherID INTEGER NOT NULL AUTO_INCREMENT, " +
                        "publisherName CHAR(100)," +
                        "PRIMARY KEY (publisherID))";

                stmt.executeUpdate(publishersTable);
                System.out.println("Created Publishers table");

                String authorISBNTable = "CREATE TABLE authorISBN " +
                        "(authorID INTEGER REFERENCES Authors(authorID)," +
                        "isbn CHAR(10) REFERENCES TItles(isbn))";

                stmt.executeUpdate(authorISBNTable);
                System.out.println("Created authorISBN table");

                InsertTestData.updateTables();
            }
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } finally {
            // Finally block used to close resource
            if (stmt != null) {
                JDBC.close();
            }
        }
    }
}
