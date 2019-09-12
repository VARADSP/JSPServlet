package com.uks.varad.struts.day5_6.assignment.logic;

import com.uks.varad.struts.commons.utils.CommonLogic;
import com.uks.varad.struts.day5_6.assignment.bean.LoginBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
	public static ArrayList<LoginBean> fetchAllUsers(String userName){
		try {
		ArrayList<LoginBean> resultSetOfAllUsers = (ArrayList<LoginBean>) CommonLogic.fetchData(userName);
			return resultSetOfAllUsers;
		} catch (Exception e) {
			return null;
		}
	}
	/*
	 * method addUser adds the user to the database and returns user id of that user
	 * @UserListBean which is userlist bean class
	 * return type : Integer
	 */
	public static Integer addUser(LoginBean userDataBean){
		Integer isSuccessfull=0;
		isSuccessfull = CommonLogic.addUser(userDataBean);
		return isSuccessfull;
	}
	/*
	 * method updateUser updates user from the database
	 * @UserListBean which is user list bean
	 * return type : Integer
	 */
	public static Integer updateUser(LoginBean userDataBean){
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
	public static LoginBean fillBean(String id){
		LoginBean userDataBean = CommonLogic.fillUser(id);
		try {
			return userDataBean;
		} catch (Exception e) {
			return userDataBean;
		}
	}
}
