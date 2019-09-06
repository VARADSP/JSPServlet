package com.uks.varad.struts.day5_6.assignment.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.uks.varad.struts.day5_6.assignment.bean.LoginBean;
import com.uks.varad.struts.day5_6.assignment.bean.UserListBean;
import com.uks.varad.struts.day5_6.assignment.logic.UserLogic;

public class UpdateUserAction extends ActionSupport implements ModelDriven<LoginBean>,SessionAware {

	private static final long serialVersionUID = 1L;
	//UserDataBean
	private UserListBean userDataBean = new UserListBean();
	//LoginBean
	private LoginBean loginBean = new LoginBean();
	// array of users data
	private ArrayList<UserListBean> users = new ArrayList<UserListBean>();
	private Map<String, Object> session;
	/*
	 * method getUsers returns array of user list
	 * return type : ArrayList
	 */
	public ArrayList<UserListBean> getUsers() {
		return users;
	}
	/*
	 * method setUsers sets user list
	 * @users list of arraylist
	 * return type : void
	 */
	public void setUsers(ArrayList<UserListBean> users) {
		this.users = users;
	}
	/*
	 * method getUserDataBean returns user data bean
	 * return type : UserDataBean
	 */
	public UserListBean getUserDataBean() {
		return userDataBean;
	}

	/*
	 * method setUserDataBean sets user data bean
	 * @userDataBean class object
	 * return type : void
	 */
	public void setUserDataBean(UserListBean userDataBean) {
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
	 * return type : String
	 */
	// all struts logic here
	public String execute() {

		System.out.println("In update user " + session.get("loginBean.userName") + " " + session.get("loginBean.password") );

		return "updateUserForm";
	}


	public String update(){
		System.out.println("In update user  register " + session.get("loginBean.userName") + " " + session.get("loginBean.password") );

		System.out.println(userDataBean);

		if(userDataBean.getName() == "" || userDataBean.getUserId() == "" || userDataBean.getAddress() == ""
				|| userDataBean.getCategory() == null || userDataBean.getEmailId() == "" ||
				userDataBean.getPassword() == "" ||
				userDataBean.getSex() == null){
			return "updateUserForm";

		}
		else{
		//Addin new user
		Integer isSuccessfull = 0;

		isSuccessfull = UserLogic.updateUser(userDataBean);

		if(isSuccessfull == 1){
			return "update-success";
		}
		else{
			return "updateUserForm";
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
