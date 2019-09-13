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
import com.uks.varad.struts.commons.db.logic.HibernateConnection;
import com.uks.varad.struts.day5_6.assignment.bean.LoginBean;
import com.uks.varad.struts.day5_6.assignment.bean.UserDataBean;
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
	HibernateConnection hibernateConnection = new HibernateConnection();
	 Session session1 = hibernateConnection.getHbmConnection();
	static List<LoginBean> loginBeans=null;
	static List<UserDataBean> userDataBeans=null;


	/*
	 * method fetchData fetches all data of given username from table and returns resultSet
	 * return type : ResultSet
	 */
	public static List<LoginBean> fetchData(String name){
		HibernateConnection hibernateConnection = new HibernateConnection();
		 Session session1 = hibernateConnection.getHbmConnection();


		System.out.println("In list function from common logic name="+name);

		session1.beginTransaction();

		loginBeans = session1.createQuery("FROM LoginBean").list();

		System.out.println("In List function from common logic loginBeans=" + loginBeans);

		session1.getTransaction().commit();
		return loginBeans;
	}


	/*
	 * method login is used to login
	 * return type : String
	 */
public static String login(String userName,String password){
	HibernateConnection hibernateConnection = new HibernateConnection();
	 Session session1 = hibernateConnection.getHbmConnection();

	try {
	session1.beginTransaction();
	// Query fire for insertion operation with column name and values
	Query query = session1.createQuery("from LoginBean where username=:username and password=:password");
	query.setString("username", userName);
	query.setString("password", password);

	loginBeans = query.list();
	if(loginBeans.get(0).getUserDataBean().getIsDisabled().equalsIgnoreCase("true")){
		return "disabled";
	}
	session1.getTransaction().commit();


	if(loginBeans.size()==1){
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
	public static Integer addUser(LoginBean userDataBean){
		HibernateConnection hibernateConnection = new HibernateConnection();
		 Session session1 = hibernateConnection.getHbmConnection();



		  	session1.beginTransaction();
		  	//Save the user data bean in database
	        session1.save(userDataBean);
	      //Commit the transaction
	        session1.getTransaction().commit();
	        return 1;
	}

	/*
	 * method fillUser fills user information
	 * @String id of the user
	 * return type : ResultSet
	 */
	public static LoginBean fillUser(String id){
		HibernateConnection hibernateConnection = new HibernateConnection();
		 Session session1 = hibernateConnection.getHbmConnection();

	  	session1.beginTransaction();

		Query query = session1.createQuery("from LoginBean where userid=:userId");
		query.setString("userId", id);

		session1.getTransaction().commit();

		return (LoginBean) query.list().get(0);

	}
	/*
	 * method updateUser updates user information
	 * @UserListBean which contains user information
	 * return type : Integer
	 */
	public static Integer updateUser(LoginBean userDataBean){

		System.out.println("In update user " + userDataBean);


		HibernateConnection hibernateConnection = new HibernateConnection();
		 Session session1 = hibernateConnection.getHbmConnection();



		session1.beginTransaction();

		LoginBean loginBeanOfUser = (LoginBean) session1.get(LoginBean.class, userDataBean.getUserid());

		loginBeanOfUser.setPassword(userDataBean.getPassword());
		loginBeanOfUser.setUserName(userDataBean.getUserName());

		System.out.println("In update function ");
		System.out.println(loginBeanOfUser);

		UserDataBean userDataBeanOfUser = (UserDataBean) session1.get(UserDataBean.class, userDataBean.getUserid());

		userDataBeanOfUser.setAddress(userDataBean.getUserDataBean().getAddress());
		userDataBeanOfUser.setCategory(userDataBean.getUserDataBean().getCategory());
		userDataBeanOfUser.setSex(userDataBean.getUserDataBean().getSex());
		userDataBeanOfUser.setEmailId(userDataBean.getUserDataBean().getEmailId());
		userDataBeanOfUser.setName(userDataBean.getUserDataBean().getName());
		userDataBeanOfUser.setIsDisabled(userDataBean.getUserDataBean().getIsDisabled());


		session1.getTransaction().commit();
		return 1;
	}
	/*
	 * method enableUser enables user from id passed
	 * @String id of user
	 * return type : Integer
	 */
	public static Integer enableUser(String id){
		HibernateConnection hibernateConnection = new HibernateConnection();
		 Session session1 = hibernateConnection.getHbmConnection();

		session1.beginTransaction();
		LoginBean loginBean = (LoginBean)session1.get(LoginBean.class,Integer.parseInt(id));
		loginBean.getUserDataBean().setIsDisabled("false");
		session1.update(loginBean);
		session1.getTransaction().commit();
		return 1;
	}
	/*
	 * method disableUser disables user from id passed
	 * @String id of user
	 * return type : Integer
	 */
	public static Integer disableUser(String id){
		HibernateConnection hibernateConnection = new HibernateConnection();
		 Session session1 = hibernateConnection.getHbmConnection();

		session1.beginTransaction();
		LoginBean loginBean = (LoginBean)session1.get(LoginBean.class,Integer.parseInt(id));
		loginBean.getUserDataBean().setIsDisabled("true");
		session1.update(loginBean);
		session1.getTransaction().commit();
		return 1;
	}
	/*
	 * method deleteUser deletes users from database
	 * @String ids of the users
	 * return type : Integer
	 */
	public static Integer deleteUser(String[] ids){
		HibernateConnection hibernateConnection = new HibernateConnection();
		 Session session1 = hibernateConnection.getHbmConnection();

		session1.beginTransaction();
		for(String id:ids) {
			LoginBean loginBean = (LoginBean)session1.get(LoginBean.class, Integer.parseInt(id));
			session1.delete(loginBean);
		}
		session1.getTransaction().commit();
		return 1;
	}
}