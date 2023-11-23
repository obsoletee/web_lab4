package com.iliaz_mamedov.Connection;

import com.iliaz_mamedov.Connection.JDBC;
import java.util.*;
import java.sql.*;
public class TestDatabase {
    public static void main(String[] args) {
        System.out.println("---- MySQL JDBC Connection Testing ----");

        try {
            JDBC.connect();
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
            return;
        }

        JDBC.close();
    }

}
