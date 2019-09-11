/**
 *
 */
package com.uks.varad.struts.commons.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.uks.varad.struts.commons.db.logic.HibernateConnection;
import com.uks.varad.struts.day2.assignment1.bean.LoginBean;
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
				ex.printStackTrace();
			}
			return size;
		}



		/*
		 * method login is used to login
		 * return type : String
		 */
	public static String login(String userName,String password){
		try {
		HibernateConnection hibernateConnection = new HibernateConnection();
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