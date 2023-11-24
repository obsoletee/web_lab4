package com.iliaz_mamedov.Query;
import com.iliaz_mamedov.Connection.JDBC;

import java.sql.*;
import java.util.Scanner;

public class Query6 {
    public static void main(String[] args) {
        Statement stmt = null;
        try {

            JDBC.connect();

            stmt = JDBC.connection.createStatement();
            System.out.println("Введите ID автора:");
            Scanner scanner = new Scanner(System.in);
            int chosenID = scanner.nextInt();
            System.out.println("Введите новое имя автора:");
            scanner.nextLine();
            String newAuthorFirstName = scanner.nextLine();
            try {
                String updateAuthorsTable = "UPDATE Authors SET firstName = '" + newAuthorFirstName + "' WHERE authorID = '" + chosenID + "'";
                stmt.executeUpdate(updateAuthorsTable);
                System.out.println("Author's first name was changed");
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