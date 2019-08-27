package com.uks.kailas.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// This class can be used to initialize the database connection
public class DBConnection {
    public static Connection initializeDatabase()
        throws SQLException, ClassNotFoundException
    {
        // Initialize all the information regarding
        // Database Connection
        String dbDriver = "com.mysql.jdbc.Driver";
        String dbURL = "jdbc:mysql://172.16.1.15:3306/";
        // Database name to access
        String dbName = "northwind_kailas";
        String dbUsername = "kailas";
        String dbPassword = "kailas@523";

        Class.forName(dbDriver);
        Connection con = DriverManager.getConnection(dbURL + dbName,
                                                     dbUsername,
                                                     dbPassword);
        return con;
    }
}