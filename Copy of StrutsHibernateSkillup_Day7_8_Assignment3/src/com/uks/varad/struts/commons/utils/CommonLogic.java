package com.uks.varad.struts.commons.utils;



import org.hibernate.Query;
import org.hibernate.Session;

import com.uks.varad.struts.commons.db.logic.DbLogic;
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
	static HibernateConnection hibernateConnection = new HibernateConnection();
	static Session session1 = hibernateConnection.getHbmConnection();
	static List<LoginBean> loginBeans=null;
	static List<UserDataBean> userDataBeans=null;


	/*
	 * method fetchData fetches all data of given username from table and returns resultSet
	 * return type : ResultSet
	 */
	public static List<LoginBean> fetchData(String name){
		session1.beginTransaction();
		loginBeans = session1.createQuery("FROM LoginBean").list();
		session1.getTransaction().commit();
		return loginBeans;
	}


	/*
	 * method login is used to login
	 * return type : String
	 */
public static String login(String userName,String password){
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
		session1.beginTransaction();
		session1.update(userDataBean);
		session1.getTransaction().commit();
		return 1;
	}
	/*
	 * method enableUser enables user from id passed
	 * @String id of user
	 * return type : Integer
	 */
	public static Integer enableUser(String id){
		session1.beginTransaction();
		LoginBean loginBean = (LoginBean)session1.get(LoginBean.class,id);
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
		session1.beginTransaction();
		LoginBean loginBean = (LoginBean)session1.get(LoginBean.class,id);
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
		session1.beginTransaction();
		for(String id:ids) {
			LoginBean loginBean = (LoginBean)session1.get(LoginBean.class, id);
			session1.delete(loginBean);
		}
		session1.getTransaction().commit();
		return 1;
	}
}