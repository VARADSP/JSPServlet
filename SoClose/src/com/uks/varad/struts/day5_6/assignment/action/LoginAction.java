package com.uks.varad.struts.day5_6.assignment.action;


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
import com.uks.varad.struts.day5_6.assignment.bean.LoginBean;

import java.util.Map;
import org.apache.commons.lang.xwork.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

/*
 * Class LogicAction is used as action class for login
 * @author: Varad Parlikar
 * Created Date: 2019/08/29
 */
@SuppressWarnings("serial")
public class LoginAction extends ActionSupport implements ModelDriven<LoginBean>,SessionAware{

	private LoginBean loginBean = new LoginBean();
	private Map<String, Object> session;




	public LoginBean getLoginBean() {
		return loginBean;
	}



	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}



	/*
	 * method execute implemented method for struts action class
	 * return type : String
	 */
	// all struts logic here
	public String execute() {

		if(session.get("loginBean.userName") != null && session.get("loginBean.password") != null ){
			System.out.println("Already logged in !");
				loginBean.setUserName(session.get("loginBean.userName").toString());
				loginBean.setPassword(session.get("loginBean.password").toString());
				return "login-success";
		}
		else{


		System.out.println("In login action " + loginBean.getUserName() + " " + loginBean.getPassword());

		validate();

		if(session.get("loggedInUser") == null){

			//using session
			session.put("loggedInUser", loginBean.getUserName());

		}
		return "login-success";
		}
	}



	/*
	 * method validate validates the application form fields
	 * return type : void
	 */
	// simple validation
	public void validate() {

		System.out.println("In validate ");

		if(session.get("loginBean.userName") == null && session.get("loginBean.password") == null ){

		if (StringUtils.isNotEmpty(loginBean.getUserName())
				&& StringUtils.isNotEmpty(loginBean.getPassword())) {
			if(CommonLogic.login(loginBean.getUserName(), loginBean.getPassword()).equalsIgnoreCase("authenticated")){

				addActionMessage("You are valid user!");
			}
			else if(CommonLogic.login(loginBean.getUserName(), loginBean.getPassword()).equalsIgnoreCase("exception")){
				addActionError("Can not connect to database , Please try again !");
			}
			else if(CommonLogic.login(loginBean.getUserName(), loginBean.getPassword()).equalsIgnoreCase("disabled")){
				addActionError("You are disabled , Please contact administration !");
			}
			else if(CommonLogic.login(loginBean.getUserName(), loginBean.getPassword()).equalsIgnoreCase("usernameIncorrect")){
				addActionError("Username and Password is invalid !");
			}
			else if(CommonLogic.login(loginBean.getUserName(), loginBean.getPassword()).equalsIgnoreCase("passwordIncorrect")){
				addActionError("Password is invalid !");
			}
			else{
				addActionError("Username and Password is invalid !");
			}

		}
		else if(StringUtils.isEmpty(loginBean.getUserName()) && StringUtils.isEmpty(loginBean.getPassword()) ) {
			addActionError("Please enter username and password !");
		}
		else if(StringUtils.isEmpty(loginBean.getUserName())) {
			addActionError("Please enter username !");
		}
		else if(StringUtils.isEmpty(loginBean.getPassword())) {
			addActionError("Please enter password !");
		}
		}

	}


	/*
	 * method getModel returns logicBean
	 * return type : LogicBean
	 */
	@Override
	public LoginBean getModel() {
		return loginBean;
	}


	@Override
	public void setSession(Map<String, Object> session) {
		 this.session = session;
	}

}
