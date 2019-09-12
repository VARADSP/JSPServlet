package com.uks.varad.struts.day2.assignment2.action;


import java.util.ArrayList;

/**
 * @author: 	Varad Paralikar
 * Created Date:29/08/2019
 * Assignment:  Day 2
 * Task: 		Struts And Hibernate Skillup
 *
 */
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.uks.varad.struts.commons.utils.CommonLogic;
import com.uks.varad.struts.day2.assignment2.bean.LoginBean;
import com.uks.varad.struts.day2.assignment2.bean.UserDataBean;
import com.uks.varad.struts.day2.assignment2.logic.UserLogic;

/**
 * @author: 	Varad Paralikar
 * Created Date:29/08/2019
 * Assignment:  Day 2
 * Task: 		Struts And Hibernate Skillup
 *
 */


/*
 * Class UserDataAction is used to maintain user data action
 * @author: Varad Parlikar
 * Created Date: 2019/08/29
 */
@SuppressWarnings("serial")
public class UserDataAction extends ActionSupport implements ModelDriven<UserDataBean>{

	//UserDataBean
	private UserDataBean userDataBean = new UserDataBean();
	//LoginBean
	private LoginBean loginBean = new LoginBean();
	// array of users data
	private ArrayList<UserDataBean> users = new ArrayList<UserDataBean>();


	/*
	 * method getUsers returns array of user list
	 * return type : ArrayList
	 */
	public ArrayList<UserDataBean> getUsers() {
		return users;
	}


	/*
	 * method setUsers sets user list
	 * @users list of arraylist
	 * return type : void
	 */
	public void setUsers(ArrayList<UserDataBean> users) {
		this.users = users;
	}


	/*
	 * method getUserDataBean returns user data bean
	 * return type : UserDataBean
	 */
	public UserDataBean getUserDataBean() {
		return userDataBean;
	}


	/*
	 * method setUserDataBean sets user data bean
	 * @userDataBean class object
	 * return type : void
	 */
	public void setUserDataBean(UserDataBean userDataBean) {
		this.userDataBean = userDataBean;
	}


	/*
	 * method getloginBean returns login bean
	 * return type : LoginBean
	 */
	public LoginBean getLoginBean() {
		return loginBean;
	}

	/*
	 * method setLoginBean sets login bean
	 * @loginBean class object
	 * return type : void
	 */
	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}


	/*
	 * method getUserName is used to return user name
	 * return type : String
	 */
	public String getUserName() {
		return loginBean.getUserName();
	}


	/*
	 * method setUserName is used to set user name
	 * @String as username
	 * return type : void
	 */
	public void setUserName(String userName) {
		loginBean.setUserName(userName);
	}




	/*
	 * method execute implemented method for struts action class
	 * return type : String
	 */
	// all struts logic here
	public String execute() {
	CommonLogic.fetchData(loginBean.getUserName());
	
		if(loginBean.getUserName().equals("admin")){
			users = UserLogic.fetchAllUsers();
		}		else{
			setUserDataBean(UserLogic.fetchUser(loginBean.getUserName()));
			users.add(getUserDataBean());
		}
		return "success";
	}




	/*
	 * method getModel returns logicBean
	 * return type : LogicBean
	 */
	@Override
	public UserDataBean getModel() {
		return userDataBean;
	}

}
