/**
 *
 */
package com.uks.varad.struts.commons.utils;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.uks.varad.struts.commons.db.logic.DbLogic;
import com.uks.varad.struts.commons.db.logic.HibernateConnection;
import com.uks.varad.struts.day2.assignment2.bean.LoginBean;

/**
 * @author: 	Varad Paralikar
 * Created Date:29/08/2019
 * Assignment:  Day 2
 * Task: 		Struts And Hibernate Skillup
 *
 */


/*
 * Class CommonLogic is used to implement common logic
 * @author: Varad Parlikar
 * Created Date: 2019/08/29
 */
public class CommonLogic {
	static HibernateConnection hibernateConnection = new HibernateConnection();
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
				Session session1 = hibernateConnection.getHbmConnection();
				// Query fire for insertion operation with column name and values
				Query query = session1.createQuery("from "+name);
				System.out.println(query.list().size());

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
		try {

		Session session1 = hibernateConnection.getHbmConnection();
		// Query fire for insertion operation with column name and values
		Query query = session1.createQuery("from LoginBean where username=:username and password=:password");
		query.setString("username", userName);
		query.setString("password", password);
		List<LoginBean> fetchedData = query.list();


		if(fetchedData.size()==1){
			//successfully authenticated user
			return "authenticated";

		}
		else{
			return "notAuthenticated";
		}
		} catch (Exception e) {
			System.out.println(e);
			return "exception";
		}
	}

}