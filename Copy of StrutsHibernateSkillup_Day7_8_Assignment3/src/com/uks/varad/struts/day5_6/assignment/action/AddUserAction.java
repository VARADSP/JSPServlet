package com.uks.varad.struts.day5_6.assignment.action;

import java.util.ArrayList;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.uks.varad.struts.day5_6.assignment.bean.LoginBean;
import com.uks.varad.struts.day5_6.assignment.bean.UserDataBean;
import com.uks.varad.struts.day5_6.assignment.logic.UserLogic;

/**
 * @author: Varad Paralikar
 * Created Date:09/10/2019
 *  Assignment: Day 5-6
 *  Task: Struts And Hibernate Skillup
 *
 */
/*
 * Class AddUserAction is used to register user into the database
 * @author: Varad Parlikar
 * Created Date: 2019/9/09
 */
public class AddUserAction extends ActionSupport implements ModelDriven<LoginBean>, SessionAware {

	private static final long serialVersionUID = 1L;
	// UserDataBean
	private UserDataBean userDataBean = new UserDataBean();
	// LoginBean
	private LoginBean loginBean = new LoginBean();
	// array of users data
	private ArrayList<LoginBean> users = new ArrayList<LoginBean>();
	private Map<String, Object> session;

	/*
	 * method getUsers returns array of user list
	 * return type : ArrayList
	 */
	public ArrayList<LoginBean> getUsers() {
		return users;
	}

	/*
	 * method setUsers sets user list
	 * @users list of arraylist
	 * return type : void
	 */
	public void setUsers(ArrayList<LoginBean> users) {
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
	/*
	 * method getloginBean returns login bean
	 * return type : LoginBean
	 */
	public LoginBean getLoginBean() {
		return loginBean;
	}

	/*
	 * method setLoginBean sets login bean
	 *
	 * @loginBean class object
	 * return type : void
	 */
	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	/*
	 * method execute implemented method for struts action class
	 * return type : String
	 */
	// all struts logic here
	public String execute() {

		System.out.println(
				"In register user " + session.get("loginBean.userName") + " " + session.get("loginBean.password"));

		return "addUserForm";
	}
	/*
	 * method register registers user into the database
	 * return type : String
	 */
	public String register() {
		System.out.println(
				"In add user  register " + session.get("loginBean.userName") + " " + session.get("loginBean.password"));
		System.out.println(loginBean);

		if (loginBean.getUserDataBean().getName() == "" || loginBean.getUserDataBean().getUserId() == "" || loginBean.getUserDataBean().getAddress() == ""
				|| loginBean.getUserDataBean().getCategory() == null || loginBean.getUserDataBean().getEmailId() == ""
				|| loginBean.getPassword() == "" || loginBean.getUserDataBean().getSex() == null || loginBean.getUserid() == "") {
			return "addUserForm";

		} else {
			// Addin new user
			Integer isSuccessfull = 0;

			isSuccessfull = UserLogic.addUser(loginBean);

			if (isSuccessfull == 1) {
				return "add-success";
			} else {
				return "addUserForm";
			}
		}

	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Override
	public LoginBean getModel() {
		return loginBean;
	}

}
