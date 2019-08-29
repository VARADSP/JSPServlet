/**
 *
 */
package com.uks.varad.struts.commons.db.logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.uks.varad.struts.commons.utils.Constants;

/**
 * @author Varad Paralikar
 *
 * Common Database class and returing the connection object
 *
 */
public class DbLogic {

	static Connection connection = null;


	@SuppressWarnings("finally")
	public static Connection connect(){
		try{

			//setting database variables
			Constants.getPropertyValue();
			//finding the class
			Class.forName(Constants.db_driver);
			//establishmenting the connection
			connection = DriverManager.getConnection(Constants.db_URL,Constants.db_username,Constants.db_password);
			System.out.println("Database Connecting.....");

		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			return connection;
			//returing connection object
		}
	}

	//Disconneting the connection of database
	public static void disconnect(){
		try {
			System.out.println("Database Disonnecting.....");
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
