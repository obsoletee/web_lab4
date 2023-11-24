package com.iliaz_mamedov.Query;
import com.iliaz_mamedov.Connection.JDBC;

import java.sql.*;
import java.util.Scanner;

public class Query4 {
    public static void main(String[] args) {
        Statement stmt = null;
        try {

            JDBC.connect();

            stmt = JDBC.connection.createStatement();
            System.out.println("Введите ID издателя:");
            Scanner scanner = new Scanner(System.in);
            int chosenID = scanner.nextInt();
            try {
                String printTitlesByPublisher = "SELECT * FROM titles WHERE publisherID = " + chosenID + " ORDER BY title ASC";
                ResultSet rs4 = stmt.executeQuery(printTitlesByPublisher);
                while (rs4.next()) {
                    int isbn = rs4.getInt("isbn");
                    int id = rs4.getInt("publisherID");
                    String publisherName = rs4.getString("title");
                    System.out.println(id + "\t" + isbn + "\t" + publisherName);
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