package com.uks.varad.struts.day2.assignment2.action;


import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

/**
 * @author: 	Varad Paralikar
 * Created Date:29/08/2019
 * Assignment:  Day 2
 * Task: 		Struts And Hibernate Skillup
 *
 */
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.uks.varad.struts.day2.assignment2.bean.LoginBean;
import com.uks.varad.struts.day2.assignment2.bean.UserDataBean;
import com.uks.varad.struts.day2.assignment2.logic.UserLogic;



/*
 * Class LogicAction is used as action class for login
 * @author: Varad Parlikar
 * Created Date: 2019/08/29
 */
@SuppressWarnings("serial")
public class UserDataAction extends ActionSupport implements ModelDriven<UserDataBean>{

	private UserDataBean userDataBean = new UserDataBean();
	private LoginBean loginBean = new LoginBean();



	public UserDataBean getUserDataBean() {
		return userDataBean;
	}


	public void setUserDataBean(UserDataBean userDataBean) {
		this.userDataBean = userDataBean;
	}


	public LoginBean getLoginBean() {
		return loginBean;
	}


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
		HttpSession session = ServletActionContext.getRequest().getSession();
		String username = session.getAttribute("loggedInUser").toString();
		setUserDataBean(UserLogic.fetchUser(username));
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
