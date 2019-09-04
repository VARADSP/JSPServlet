package com.uks.varad.struts.day2.assignment2.logic;

import com.uks.varad.struts.commons.utils.CommonLogic;
import com.uks.varad.struts.day2.assignment2.bean.UserDataBean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 * @author: 	Varad Paralikar
 * Created Date:29/08/2019
 * Assignment:  Day 2
 * Task: 		Struts And Hibernate Skillup
 *
 */
/*
 * Class UserLogic is used to implement user logic
 * @author: Varad Parlikar
 * Created Date: 2019/08/29
 */
public class UserLogic {


	/*
	 * method fetchAllUsers fetches all users details from table
	 * return type : ArrayList<UserDataBean>
	 */
	public static ArrayList<UserDataBean> fetchAllUsers(String userName){

		UserDataBean userDataBean;
		ArrayList<UserDataBean> users = new ArrayList<>();
		//clearing user list initially
		users.clear();

		ResultSet resultSetOfAllUsers = CommonLogic.fetchData(userName);


		try {
			while(resultSetOfAllUsers.next()){
				userDataBean = new UserDataBean();
				//setting user properties
				userDataBean.setName(resultSetOfAllUsers.getString(2).trim());
				userDataBean.setCategory(resultSetOfAllUsers.getString(3).trim());
				userDataBean.setSex(resultSetOfAllUsers.getString(4).trim());
				userDataBean.setAddress(resultSetOfAllUsers.getString(5).trim());
				userDataBean.setEmailId(resultSetOfAllUsers.getString(6).trim());
				users.add(userDataBean);
			}
			return users;
		} catch (SQLException e) {
			return users;
		}
	}

}
