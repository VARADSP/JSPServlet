/**
 *
 */
package com.uks.varad.struts.commons.db.logic;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.uks.varad.struts.commons.utils.Constants;

/**
 * @author: 	Varad Paralikar
 * Created Date:09/10/2019
 * Assignment:  Day 5-6
 * Task: 		Struts And Hibernate Skillup
 *
 */

/*
 * Class DBLogic is used to implement database logic
 * @author: Varad Parlikar
 * Created Date: 2019/9/09
 */
public class DbLogic {
	static Connection connection = null;
	/*
	 * method connect makes connection to database
	 * return type : Connection
	 */
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
	/*
	 * method disconnect closes database connection
	 * return type : void
	 */
	public static void disconnect(){
		try {
			System.out.println("Database Disonnecting.....");
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
