/**
 *
 */
package com.uks.varad.struts.commons.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.uks.varad.struts.commons.db.logic.DbLogic;

/**
 * @author Varad Paralikar
 *
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
				ex.printStackTrace();
			}
			return size;
		}



	public static boolean login(String userName,String password){
		//connecting to database
		connection = DbLogic.connect();

		// Query fire for insertion operation with column name and values
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement("SELECT * from struts_users where username = ? and password = ?");

			preparedStatement.setString(1, userName.trim());
			preparedStatement.setString(2, password.trim());
			// executing the query for prapared statment
			ResultSet resultSet = preparedStatement.executeQuery();
			if(getRowCount(resultSet) == 0){
			//wrong username and password
			return false;
			}
			//successfully authenticated user
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}