/**
 *
 */
package com.uks.varad.struts.commons.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import com.uks.varad.struts.commons.db.logic.DbLogic;
import com.uks.varad.struts.day5_6.assignment.bean.UserListBean;

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
				//admin and normal user query detects if admin returns all rows
					preparedStatement = connection.prepareStatement("SELECT ul.UserId,(SELECT username FROM struts_users WHERE userid = ul.UserId),ul.Name,ul.Category,ul.Sex,ul.Address,ul.EmailId FROM struts_userlist AS ul INNER JOIN struts_users AS u ON u.username = ? WHERE ul.UserId = u.userid OR 1 = EXISTS(SELECT Category FROM struts_userlist AS ul1 WHERE ul1.Category = 'Admin' AND ul1.UserId = u.userid)");

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

			} catch (Exception e) {
				e.printStackTrace();
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
	public static Integer addUser(UserListBean userDataBean){

		//connecting to database
		connection = DbLogic.connect();

		// Query fire for insertion operation with column name and values
		PreparedStatement preparedStatement1,preparedStatement2;
		try {
			preparedStatement1 = connection.prepareStatement("INSERT INTO struts_users(username, PASSWORD) VALUES(?, ?)");
			preparedStatement2 = connection.prepareStatement("INSERT INTO struts_userlist (userid,NAME, category, sex,address,emailid)VALUES((SELECT userid FROM struts_users WHERE username = ?),?,?,?,?,?)");

			preparedStatement1.setString(1, userDataBean.getUserId());
			preparedStatement1.setString(2, userDataBean.getPassword());

			preparedStatement2.setString(1, userDataBean.getUserId());
			preparedStatement2.setString(2, userDataBean.getName());
			preparedStatement2.setString(3, userDataBean.getCategory());
			preparedStatement2.setString(4, userDataBean.getSex());
			preparedStatement2.setString(5, userDataBean.getAddress());
			preparedStatement2.setString(6, userDataBean.getEmailId());




			// executing the query for prapared statment
			 int i1 = preparedStatement1.executeUpdate();
				// executing the query for prapared statment
			 int i2 = preparedStatement2.executeUpdate();

			//disconnecting the database
				DbLogic.disconnect();
				connection.close();

			 if (i1 > 0 && i2 > 0) {
		            System.out.println("User added successfully !");
		            return 1;
		        } else {
		            System.out.println("User adding operation unsuccessfull !");
		            return 0;
		        }

			//successfully added user

		} catch (Exception e) {

			return 0;
		}
	}


	public static Integer updateUser(UserListBean userDataBean){

		//connecting to database
		connection = DbLogic.connect();

		// Query fire for insertion operation with column name and values
		PreparedStatement preparedStatement1,preparedStatement2;
		try {
			preparedStatement1 = connection.prepareStatement("UPDATE struts_users SET username = ?,password=? WHERE userid = ?");
			preparedStatement2 = connection.prepareStatement("UPDATE struts_userlist SET Name=?,Category=?,Sex=?,Address=?,EmailId=? WHERE UserId=?");

			preparedStatement1.setString(1, userDataBean.getUserId());
			preparedStatement1.setString(2, userDataBean.getPassword());
			preparedStatement1.setString(3, userDataBean.getId());


			preparedStatement2.setString(1, userDataBean.getName());
			preparedStatement2.setString(2, userDataBean.getCategory());
			preparedStatement2.setString(3, userDataBean.getSex());
			preparedStatement2.setString(4, userDataBean.getAddress());
			preparedStatement2.setString(5, userDataBean.getEmailId());
			preparedStatement2.setString(6, userDataBean.getId());


			// executing the query for prapared statment
			 int i1 = preparedStatement1.executeUpdate();
				// executing the query for prapared statment
			 int i2 = preparedStatement2.executeUpdate();

			//disconnecting the database
				DbLogic.disconnect();
				connection.close();

			 if (i1 > 0 && i2 > 0) {
		            System.out.println("User updated successfully !");
		            return 1;
		        } else {
		            System.out.println("User updation operation unsuccessfull !");
		            return 0;
		        }

			//successfully added user

		} catch (Exception e) {

			return 0;
		}
	}
}