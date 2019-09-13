/**
 *
 */
package com.uks.varad.struts.commons.utils;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import com.uks.varad.struts.commons.db.logic.HibernateConnection;
import com.uks.varad.struts.day2.assignment2.bean.LoginBean;
import com.uks.varad.struts.day2.assignment2.bean.UserDataBean;
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
	static Session session1 = hibernateConnection.getHbmConnection();
	static List<LoginBean> loginBean=null;
	static List<UserDataBean> userDataBean=null;	
		/*
		 * method fetchData fetches all data of given username from table and returns resultSet
		 * return type : ResultSet
		 */
		public static List<UserDataBean> fetchData(String name){
			
			if(name.equalsIgnoreCase("struts_userdetails")) {
				Query query2 = session1.createQuery("from UserDataBean");
				userDataBean = query2.list();	
			}
			else {
				Query query2 = session1.createQuery("from UserDataBean where userId=:userid");
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

}