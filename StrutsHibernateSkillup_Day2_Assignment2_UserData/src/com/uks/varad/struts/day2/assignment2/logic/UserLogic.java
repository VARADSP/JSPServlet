package com.uks.varad.struts.day2.assignment2.logic;

import com.uks.varad.struts.commons.utils.CommonLogic;
import com.uks.varad.struts.day2.assignment2.bean.UserDataBean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserLogic {


	public static UserDataBean fetchUser(String username){
		UserDataBean userDataBean = new UserDataBean();
		ResultSet resultSetOfUser = CommonLogic.fetchData(username);

		try {
			while(resultSetOfUser.next()){
				userDataBean = new UserDataBean();
				//setting user properties
				userDataBean.setFirstName(resultSetOfUser.getString(2).trim());
				userDataBean.setMiddleName(resultSetOfUser.getString(3).trim());
				userDataBean.setLastName(resultSetOfUser.getString(3).trim());
				userDataBean.setGender(resultSetOfUser.getString(4).trim());
				userDataBean.setEmailId(resultSetOfUser.getString(5).trim());
				userDataBean.setContactNo(resultSetOfUser.getString(6).trim());


			}
			return userDataBean;
		} catch (SQLException e) {
			return userDataBean;
		}
	}

	public static ArrayList<UserDataBean> fetchAllUsers(){

		UserDataBean userDataBean;
		ArrayList<UserDataBean> users = new ArrayList<>();
		//clearing user list initially
		users.clear();

		ResultSet resultSetOfAllUsers = CommonLogic.fetchData("struts_userdetails");
		try {
			while(resultSetOfAllUsers.next()){
				userDataBean = new UserDataBean();
				//setting user properties
				userDataBean.setFirstName(resultSetOfAllUsers.getString(2).trim());
				userDataBean.setMiddleName(resultSetOfAllUsers.getString(3).trim());
				userDataBean.setLastName(resultSetOfAllUsers.getString(3).trim());
				userDataBean.setGender(resultSetOfAllUsers.getString(4).trim());
				userDataBean.setEmailId(resultSetOfAllUsers.getString(5).trim());
				userDataBean.setContactNo(resultSetOfAllUsers.getString(6).trim());

				users.add(userDataBean);
			}
			return users;
		} catch (SQLException e) {
			return users;
		}
	}

}
