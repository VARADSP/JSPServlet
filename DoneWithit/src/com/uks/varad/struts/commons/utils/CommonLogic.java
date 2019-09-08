/**
 *
 */
package com.uks.varad.struts.commons.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
					preparedStatement = connection.prepareStatement("SELECT ul.UserId,(SELECT username FROM struts_users WHERE userid = ul.UserId),ul.Name,ul.Category,ul.Sex,ul.Address,ul.EmailId,ul.isDisabled FROM struts_userlist AS ul INNER JOIN struts_users AS u ON u.username = ? WHERE ul.UserId = u.userid OR 1 = EXISTS(SELECT Category FROM struts_userlist AS ul1 WHERE ul1.Category = 'Admin' AND ul1.UserId = u.userid)");

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
		try {
		connection = DbLogic.connect();

		// Query fire for insertion operation with column name and values
		PreparedStatement preparedStatement1,preparedStatement2;
		
			preparedStatement1 = connection.prepareStatement("SELECT userid,password from struts_users where username = ?");

			preparedStatement1.setString(1, userName.trim());
		//	preparedStatement.setString(2, password.trim());
			// executing the query for prapared statment
			ResultSet resultSet = preparedStatement1.executeQuery();

			if(getRowCount(resultSet) == 0){
			//wrong username and password
			return "notAuthenticated";
			}
			//successfully authenticated user
			if(resultSet.next() && resultSet.getString(2).trim().equals(password.trim())){


				String id = resultSet.getString(1).trim();



				preparedStatement2 = connection.prepareStatement("SELECT isDisabled from struts_userlist where UserId = ?");

				preparedStatement2.setString(1, id);
				// executing the query for prapared statment
				ResultSet resultSet1 = preparedStatement2.executeQuery();

				if(getRowCount(resultSet1) == 0){
					//wrong username and password
					//disconnecting the database
					DbLogic.disconnect();
					connection.close();
					return "notAuthenticated";
				}
				resultSet1.next();

				if(resultSet1.getString(1) != null && resultSet1.getString(1).trim().equalsIgnoreCase("true")){
					//disconnecting the database
					DbLogic.disconnect();
					connection.close();
					return "disabled";
				}
				else{
					System.out.println("Not disabled ");
				//disconnecting the database
				DbLogic.disconnect();
				connection.close();
				return "authenticated";
				}
				}
			else{
				//disconnecting the database
				DbLogic.disconnect();
				connection.close();
				return "passwordIncorrect";
			}


		}
		catch (Exception e) {
			e.printStackTrace();
			//disconnecting the database
			DbLogic.disconnect();
			try {
				connection.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

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

	public static ResultSet fillUser(String id){

		UserListBean userListBean = new UserListBean();


		//connecting to database
		connection = DbLogic.connect();
		// Query fire for insertion operation with column name and values
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		try {
			//admin and normal user query detects if admin returns all rows
				preparedStatement = connection.prepareStatement("SELECT u.username,u.password,ul.Name,ul.Category,ul.Sex,ul.Address,ul.EmailId FROM struts_users AS u JOIN struts_userlist AS ul ON u.userid=ul.UserId WHERE ul.userid = ?");
				preparedStatement.setString(1, id.trim());
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


	public static Integer enableUser(String id){

		//connecting to database
		connection = DbLogic.connect();

		// Query fire for insertion operation with column name and values
		PreparedStatement preparedStatement1;
		try {
			preparedStatement1 = connection.prepareStatement("UPDATE struts_userlist SET isDisabled=? WHERE UserId=?");

			preparedStatement1.setString(1, "false");

			preparedStatement1.setString(2, id);


			// executing the query for prapared statment
			 int i1 = preparedStatement1.executeUpdate();

			//disconnecting the database
				DbLogic.disconnect();
				connection.close();

			 if (i1 > 0) {
		            System.out.println("User enabled successfully !");
		            return 1;
		        } else {
		            System.out.println("User enable operation unsuccessfull !");
		            return 0;
		        }

			//successfully added user

		} catch (Exception e) {

			return 0;
		}
	}


	public static Integer disableUser(String id){

		//connecting to database
		connection = DbLogic.connect();

		// Query fire for insertion operation with column name and values
		PreparedStatement preparedStatement1;
		try {
			preparedStatement1 = connection.prepareStatement("UPDATE struts_userlist SET isDisabled=? WHERE UserId=?");

			preparedStatement1.setString(1, "true");

			preparedStatement1.setString(2, id);

			// executing the query for prapared statment
			 int i1 = preparedStatement1.executeUpdate();

			//disconnecting the database
				DbLogic.disconnect();
				connection.close();

			 if (i1 > 0) {
		            System.out.println("User disable successfully !");
		            return 1;
		        } else {
		            System.out.println("User disable operation unsuccessfull !");
		            return 0;
		        }

			//successfully added user

		} catch (Exception e) {

			return 0;
		}
	}


	public static Integer deleteUser(String[] ids){


		 int i1 = 0 ;


		//connecting to database
		connection = DbLogic.connect();

		// Query fire for insertion operation with column name and values
		PreparedStatement preparedStatement1;

		for(String id : ids){
				System.out.println("Deleting user no " + id);
		try {
			preparedStatement1 = connection.prepareStatement("DELETE FROM struts_users WHERE userid = ?");

			preparedStatement1.setString(1, id);
			// executing the query for prapared statment
			 i1 =+ preparedStatement1.executeUpdate();
				// executing the query for prapared statment

			//successfully deleted user

		} catch (Exception e) {

			return 0;
		}

		}

		//disconnecting the database
		DbLogic.disconnect();
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}


		if (i1 > 0) {
            System.out.println("User deleted successfully !");
            return 1;
        } else {
            System.out.println("User delete operation unsuccessfull !");
            return 0;
        }
	}
}