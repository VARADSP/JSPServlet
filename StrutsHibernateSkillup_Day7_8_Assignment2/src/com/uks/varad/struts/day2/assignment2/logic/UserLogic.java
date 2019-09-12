package com.uks.varad.struts.day2.assignment2.logic;

import com.uks.varad.struts.commons.utils.CommonLogic;
import com.uks.varad.struts.day2.assignment2.bean.UserDataBean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
	 * method fetchUser fetches user details from the table by given user name
	 * @String username of user
	 * return type : UserDataBean
	 */
	public static UserDataBean fetchUser(String username){
		List<UserDataBean> resultSetOfUser = CommonLogic.fetchData(username);
		try {
			return resultSetOfUser.get(0);
		} catch (Exception e) {
			return resultSetOfUser.get(0);
		}
	}
	/*
	 * method fetchAllUsers fetches all users details from table
	 * return type : ArrayList<UserDataBean>
	 */
	public static ArrayList<UserDataBean> fetchAllUsers(){
		ArrayList<UserDataBean> users = new ArrayList<>();
		//clearing user list initially
		users.clear();

		List<UserDataBean> resultSetOfAllUsers = CommonLogic.fetchData("struts_userdetails");
		try {
			for(UserDataBean userDataBean : resultSetOfAllUsers){
				users.add(userDataBean);
			}
			return users;
		} catch (Exception e) {
			return users;
		}
	}

}
