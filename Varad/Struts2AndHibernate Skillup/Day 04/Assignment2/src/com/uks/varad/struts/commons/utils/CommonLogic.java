/**
 *
 */
package com.uks.varad.struts.commons.utils;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import com.uks.varad.struts.commons.db.logic.DbLogic;

/**
 * @author: 	Varad Paralikar
 * Created Date:2/09/2019
 * Assignment:  Day 4
 * Task: 		Struts And Hibernate Skillup
 *
 */


/*
 * Class CommonLogic is used to implement common logic
 * @author: Varad Parlikar
 * Created Date: 2019/09/2
 */
public class CommonLogic {
	static Connection connection;
	   /*
		 * method getRowCount returns total number of rows in a table.
		 * return type : int
		 */
		public static int getRowCount(ResultSet resultSet){
			int size = 0;
			// calculating total resultset size
			try {
				resultSet.last();
				size = resultSet.getRow();
				resultSet.beforeFirst();

			} catch (Exception ex) {
			}
			return size;
		}

		/*
		 * method fetchData fetches all data of given username from table and returns resultSet
		 * return type : ResultSet
		 */
		public static ResultSet fetchData(String name){
			//connecting to database
			connection = DbLogic.connect();
			// Query fire for insertion operation with column name and values
			PreparedStatement preparedStatement;
			ResultSet resultSet;

			try {
			DatabaseMetaData databaseMetaData = connection.getMetaData();
			// check if "employee" table is there
			ResultSet tables = databaseMetaData.getTables(null, null, name, null);
			if (tables.next()) {
			  // Table exists
				preparedStatement = connection.prepareStatement("SELECT * from "+name);
				// executing the query for prapared statment
				resultSet = preparedStatement.executeQuery();
				if(getRowCount(resultSet) == 0){
					return null;
				}
				//disconnecting the database
				DbLogic.disconnect();
				connection.close();
				return resultSet;
			}
			else {
			  // Table does not exist

					preparedStatement = connection.prepareStatement("SELECT * from struts_userdetails where UserId = (SELECT userid from struts_users where username = ?)");

					preparedStatement.setString(1, name.trim());
				//	preparedStatement.setString(2, password.trim());
					// executing the query for prapared statment
					 resultSet = preparedStatement.executeQuery();
					if(getRowCount(resultSet) == 0){
						return null;
					}
					//disconnecting the database
					DbLogic.disconnect();
					connection.close();
					return resultSet;
			}
			} catch (Exception e) {

				return null;
			}
		}

		/*
		 * method login is used to login
		 * return type : String
		 */
	public static String login(String userName,String password){
		//connecting to database
		connection = DbLogic.connect();

		// Query fire for insertion operation with column name and values
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement("SELECT password from struts_users where username = ?");
			preparedStatement.setString(1, userName.trim());
		//	preparedStatement.setString(2, password.trim());
			// executing the query for prapared statment
			ResultSet resultSet = preparedStatement.executeQuery();
			if(getRowCount(resultSet) == 0){
			//wrong username and password
			return "notAuthenticated";
			}

			//disconnecting the database
			DbLogic.disconnect();
			connection.close();

			//successfully authenticated user
			if(resultSet.next() && resultSet.getString(1).trim().equals(password.trim())){
				return "authenticated";
			}
			else{
				return "passwordIncorrect";
			}
		} catch (Exception e) {
			return "exception";
		}
	}

}