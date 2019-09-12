/**
 *
 */
package com.uks.varad.struts.commons.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.uks.varad.struts.commons.db.logic.DbLogic;
import com.uks.varad.struts.commons.db.logic.HibernateConnection;
import com.uks.varad.struts.day5_6.assignment.bean.LoginBean;
import com.uks.varad.struts.day5_6.assignment.bean.UserListBean;
/**
 * @author: 	Varad Paralikar
 * Created Date:09/10/2019
 * Assignment:  Day 5-6
 * Task: 		Struts And Hibernate Skillup
 *
 */
/*
 * Class CommonLogic is used to implement common logic
 * @author: Varad Parlikar
 * Created Date: 2019/09/9
 */
public class CommonLogic {
	static HibernateConnection hibernateConnection = new HibernateConnection();
	static Session session1 = hibernateConnection.getHbmConnection();
	static List<LoginBean> loginBean=null;
	static List<UserListBean> userDataBean=null;


	/*
	 * method fetchData fetches all data of given username from table and returns resultSet
	 * return type : ResultSet
	 */
	public static List<UserListBean> fetchData(String name){

		if(name.equalsIgnoreCase("struts_userlist")) {
			Query query2 = session1.createQuery("from UserListBean");
			userDataBean = query2.list();
		}
		else {
			Query query2 = session1.createQuery("from UserListBean where userId=:userid");
			query2.setInteger("userid",loginBean.get(0).getUserid());
			userDataBean = query2.list();
		}
		return userDataBean;
	}


	/*
	 * method login is used to login
	 * return type : String
	 */
public static String login(String userName,String password){
	try {
	// Query fire for insertion operation with column name and values
	Query query = session1.createQuery("from LoginBean where username=:username and password=:password");
	query.setString("username", userName);
	query.setString("password", password);

	loginBean = query.list();

	Query query2 = session1.createQuery("from UserDataBean where userId=:userid");
	query2.setInteger("userid",loginBean.get(0).getUserid());
	userDataBean = query2.list();


	if(userDataBean.get(0).getIsDisabled().equalsIgnoreCase("true")){
		return "disabled";
	}


	if(loginBean.size()==1){
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

	/*
	 * method addUser adds user  to database
	 * @UserListBean which is bean class for user data
	 * return type : Integer
	 */
	public static Integer addUser(UserListBean userDataBean){
		  session1.beginTransaction();

		  UserDataBean user = new UserDataBean();




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

	/*
	 * method fillUser fills user information
	 * @String id of the user
	 * return type : ResultSet
	 */
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
	/*
	 * method updateUser updates user information
	 * @UserListBean which contains user information
	 * return type : Integer
	 */
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
	/*
	 * method enableUser enables user from id passed
	 * @String id of user
	 * return type : Integer
	 */
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
	/*
	 * method disableUser disables user from id passed
	 * @String id of user
	 * return type : Integer
	 */
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
	/*
	 * method deleteUser deletes users from database
	 * @String ids of the users
	 * return type : Integer
	 */
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