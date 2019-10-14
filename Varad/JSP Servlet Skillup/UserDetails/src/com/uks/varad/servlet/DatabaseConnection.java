package com.uks.varad.servlet;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 *
 *
 */


/**
 * @author: 	Varad Paralikar
 * Created Date:14/08/2019
 * Assignment:  Day 1
 * Task: 		Jsp & servlet
 *
 */

public class DatabaseConnection {

	// Intializing the connection
	Connection connection = null;


	public Connection connect() throws Exception {

			// Getting database url,bb,name and pass from properties file
			FileInputStream fis = new FileInputStream("D:\\PRTOT\\NEWWSPRTOT\\UserDetails\\src\\settings.properties");
			// Created ResourceBundle with parameter fileInputStream
			ResourceBundle myBundle = new PropertyResourceBundle(fis);
			// Storing the DB info into local variables
			String dbname = myBundle.getString("DBname");
			String url = myBundle.getString("URL");
			String db_user = myBundle.getString("Username");
			String db_pass = myBundle.getString("Password");
			// Intializing the dbname
			Class.forName(dbname);
			// establishmenting the connection
			connection = DriverManager.getConnection(url, db_user, db_pass);
			System.out.println("Database Connecting.....");

			return connection;

	}
}
