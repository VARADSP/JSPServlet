package com.uks.varad.struts.day5_6.assignment.logic;

import com.uks.varad.struts.commons.utils.CommonLogic;
import com.uks.varad.struts.day5_6.assignment.bean.UserListBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 * @author: 	Varad Paralikar
 * Created Date:09/10/2019
 * Assignment:  Day 5-6
 * Task: 		Struts And Hibernate Skillup
 *
 */
/*
 * Class UserLogic is used to implement user logic
 * @author: Varad Parlikar
 * Created Date: 2019/09/9
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
	 * @UserListBean which is userlist bean class
	 * return type : Integer
	 */
	public static Integer addUser(UserListBean userDataBean){
		Integer isSuccessfull=0;
		isSuccessfull = CommonLogic.addUser(userDataBean);
		return isSuccessfull;
	}
	/*
	 * method updateUser updates user from the database
	 * @UserListBean which is user list bean
	 * return type : Integer
	 */
	public static Integer updateUser(UserListBean userDataBean){
		Integer isSuccessfull=0;
		isSuccessfull = CommonLogic.updateUser(userDataBean);
		return isSuccessfull;
	}
	/*
	 * method deleteUser deletes users from the database
	 * @String[] ids of users
	 * return type : Integer
	 */
	public static Integer deleteUser(String[] ids){
		Integer isSuccessfull=0;
		isSuccessfull = CommonLogic.deleteUser(ids);
		return isSuccessfull;
	}

	/*
	 * method disableUser disables users
	 * @String ids of users
	 * return type : Integer
	 */
	public static Integer disableUser(String id){
		Integer isSuccessfull=0;
		isSuccessfull = CommonLogic.disableUser(id);
		return isSuccessfull;
	}
	/*
	 * method enableUser enables users
	 * @String ids of users
	 * return type : Integer
	 */
	public static Integer enableUser(String id){
		Integer isSuccessfull=0;
		isSuccessfull = CommonLogic.enableUser(id);
		return isSuccessfull;
	}
	/*
	 * method fillBean fills userList bean
	 * @id of usere
	 * return type : UserDataBean
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
