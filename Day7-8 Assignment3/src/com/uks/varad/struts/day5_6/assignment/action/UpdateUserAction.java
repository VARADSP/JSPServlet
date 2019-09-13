package com.uks.varad.struts.day5_6.assignment.action;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.uks.varad.struts.day5_6.assignment.bean.LoginBean;
import com.uks.varad.struts.day5_6.assignment.bean.UserDataBean;
import com.uks.varad.struts.day5_6.assignment.logic.UserLogic;

/**
 * @author: Varad Paralikar
 * Created Date:09/10/2019
 * Assignment: Day 5-6
 * Task: Struts And Hibernate Skillup
 *
 */

/*
 * Class UpdateUserAction is used to update user information
 * @author: Varad Parlikar
 * Created Date: 2019/9/09
 */
public class UpdateUserAction extends ActionSupport
		implements ModelDriven<LoginBean>, SessionAware, ServletRequestAware {
	private static final long serialVersionUID = 1L;
	// UserDataBean
	private UserDataBean userDataBean = new UserDataBean();
	// LoginBean
	private LoginBean loginBean = new LoginBean();
	// array of users data
	private ArrayList<LoginBean> users = new ArrayList<LoginBean>();
	private Map<String, Object> session;

	private HttpServletRequest request = null;

	private String idOfUser = null;

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
	 * @loginBean class object
	 * return type : void
	 */
	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}


	/*
	 * method execute implemented method for struts action class
	 * return type :String
	 */
	// all struts logic here
	public String execute() {

		return "update-success";

	}

	/*
	 * method updateUser updates the user from the database
	 * return type : String
	 */
	public String updateUser() {

		if (loginBean.getUserDataBean().getName() == ""  || loginBean.getUserDataBean().getAddress() == ""
				|| loginBean.getUserDataBean().getCategory() == null || loginBean.getUserDataBean().getEmailId() == ""
				|| loginBean.getPassword() == "" || loginBean.getUserDataBean().getSex() == null) {
			return "updateUserForm";

		} else {
			// updating new user
			Integer isSuccessfull = 0;
			loginBean.setUserid(Integer.parseInt(session.get("updateId").toString()));

			System.out.println("In loginBean Updating"+ loginBean);

			isSuccessfull = UserLogic.updateUser(loginBean);

			if (isSuccessfull == 1) {
				session.remove("updateId");
				return "update-success";

			} else {
				return "updateUserForm";
			}
		}

	}

	/*
	 * method update updates the user in the database
	 * return type : String
	 */
	public String update() {
		idOfUser = request.getParameter("id");

		loginBean = UserLogic.fillBean(idOfUser);

		session.put("updateId", idOfUser);

		return "updateUserForm";
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Override
	public LoginBean getModel() {
		return loginBean;
	}

	@Override
	public void setServletRequest(HttpServletRequest httpServletRequest) {
		this.request = httpServletRequest;
	}

}
