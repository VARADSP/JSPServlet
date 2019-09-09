package com.uks.varad.struts.day5_6.assignment.action;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

/**
 * @author: 	Varad Paralikar
 * Created Date:29/08/2019
 * Assignment:  Day 2
 * Task: 		Struts And Hibernate Skillup
 *
 */
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.uks.varad.struts.day5_6.assignment.bean.LoginBean;
import com.uks.varad.struts.day5_6.assignment.bean.UserListBean;
import com.uks.varad.struts.day5_6.assignment.logic.UserLogic;

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
public class UserListAction extends ActionSupport implements ModelDriven<UserListBean>,SessionAware{
	//UserDataBean
	private UserListBean userDataBean = new UserListBean();
	//LoginBean
	private LoginBean loginBean = new LoginBean();
	// array of users data
	private ArrayList<UserListBean> users = new ArrayList<UserListBean>();
	//session map
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

		
		
		try {
			if(loginBean.getUserName() != null){
		
				
				users = UserLogic.fetchAllUsers(loginBean.getUserName());
				
		
				
			}
			else{ // user already logged in
				if(session.get("loggedInUserType").toString().equals("User")){
					users = UserLogic.fetchAllUsers(session.get("loggedInUser").toString());
				
				}
				else{
					users = UserLogic.fetchAllUsers(session.get("loginBean.userName").toString());

					System.out.println(users);
				}

			}
			if(users.size()==1){
				session.put("loggedInUserType", "User");
			}
			else{
				session.put("loggedInUserType", "Admin");
				if(loginBean.getUserName() != null){
					session.put("loginBean.userName", loginBean.getUserName());
					session.put("loginBean.password", loginBean.getPassword());
				}
				else{ // user already logged in
					session.put("loginBean.userName", session.get("loginBean.userName").toString());
					session.put("loginBean.password", session.get("loginBean.password").toString());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	/*
	 * method getModel returns logicBean
	 * return type : LogicBean
	 */
	@Override
	public UserListBean getModel() {
		return userDataBean;
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;

	}
}
