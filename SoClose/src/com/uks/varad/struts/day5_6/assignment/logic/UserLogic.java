package com.uks.varad.struts.day5_6.assignment.logic;

import com.uks.varad.struts.commons.utils.CommonLogic;
import com.uks.varad.struts.day5_6.assignment.bean.UserListBean;

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
	public static ArrayList<UserListBean> fetchAllUsers(String userName){

		UserListBean userDataBean;
		ArrayList<UserListBean> users = new ArrayList<>();
		//clearing user list initially
		users.clear();

		ResultSet resultSetOfAllUsers = CommonLogic.fetchData(userName);
		try {
			while(resultSetOfAllUsers.next()){
				userDataBean = new UserListBean();
				//setting user properties
				userDataBean.setId(resultSetOfAllUsers.getString(1).trim());
				userDataBean.setUserId(resultSetOfAllUsers.getString(2).trim());
				userDataBean.setName(resultSetOfAllUsers.getString(3).trim());
				userDataBean.setCategory(resultSetOfAllUsers.getString(4).trim());
				userDataBean.setSex(resultSetOfAllUsers.getString(5).trim());
				userDataBean.setAddress(resultSetOfAllUsers.getString(6).trim());
				userDataBean.setEmailId(resultSetOfAllUsers.getString(7).trim());
				if(resultSetOfAllUsers.getString(8) == null){
					userDataBean.setIsDisabled("false");
				}
				else if(resultSetOfAllUsers.getString(8).equalsIgnoreCase("false")){
					userDataBean.setIsDisabled("false");
				}
				else if(resultSetOfAllUsers.getString(8).equalsIgnoreCase("true")){
					userDataBean.setIsDisabled("true");
				}
				else{
					userDataBean.setIsDisabled("false");
				}
				users.add(userDataBean);
			}
			return users;
		} catch (SQLException e) {
			return users;
		}
	}

	/*
	 * method addUser adds the user to the database and returns user id of that user
	 * return type : String which is user id
	 */
	public static Integer addUser(UserListBean userDataBean){
		Integer isSuccessfull=0;

		isSuccessfull = CommonLogic.addUser(userDataBean);

		return isSuccessfull;

	}

	public static Integer updateUser(UserListBean userDataBean){
		Integer isSuccessfull=0;

		isSuccessfull = CommonLogic.updateUser(userDataBean);

		return isSuccessfull;

	}

	public static Integer deleteUser(String[] ids){
		Integer isSuccessfull=0;

		isSuccessfull = CommonLogic.deleteUser(ids);

		return isSuccessfull;

	}

	public static Integer disableUser(String id){
		Integer isSuccessfull=0;

		isSuccessfull = CommonLogic.disableUser(id);

		return isSuccessfull;

	}

	public static Integer enableUser(String id){
		Integer isSuccessfull=0;

		isSuccessfull = CommonLogic.enableUser(id);

		return isSuccessfull;

	}

	public static Integer deleteUser(String id){
		Integer isSuccessfull=0;

		isSuccessfull = CommonLogic.enableUser(id);

		return isSuccessfull;

	}



	/*
	 * method fetchAllUsers fetches all users details from table
	 * return type : ArrayList<UserDataBean>
	 */
	public static UserListBean fillBean(String id){

		UserListBean userDataBean = new UserListBean();

		ResultSet resultSetOfUser = CommonLogic.fillUser(id);
		try {
			while(resultSetOfUser.next()){

				//setting user properties
				userDataBean.setId(id);
				userDataBean.setUserId(resultSetOfUser.getString(1).trim());
				userDataBean.setPassword(resultSetOfUser.getString(2).trim());
				userDataBean.setName(resultSetOfUser.getString(3).trim());
				userDataBean.setCategory(resultSetOfUser.getString(4).trim());
				userDataBean.setSex(resultSetOfUser.getString(5).trim());
				userDataBean.setAddress(resultSetOfUser.getString(6).trim());
				userDataBean.setEmailId(resultSetOfUser.getString(7).trim());

			}
			return userDataBean;
		} catch (SQLException e) {
			return userDataBean;
		}
	}
}
