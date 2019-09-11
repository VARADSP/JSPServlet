package com.uks.varad.struts.day2.assignment2.action;


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
	 * method getPassword returns password
	 * return type : String
	 */
	public String getPassword() {
		return loginBean.getPassword();
	}


	/*
	 * method setPassword sets the password
	 * @String as password
	 * return type : void
	 */
	public void setPassword(String password) {
		loginBean.setPassword(password);
	}


	/*
	 * method execute implemented method for struts action class
	 * return type : String
	 */
	// all struts logic here
	public String execute() {

		if(session.get("loggedInUser") == null){

			//using session
			session.put("loggedInUser", loginBean.getUserName());
		}
		return "login-success";
	}



	/*
	 * method validate validates the application form fields
	 * return type : void
	 */
	// simple validation
	public void validate() {


		if (StringUtils.isNotEmpty(loginBean.getUserName())
				&& StringUtils.isNotEmpty(loginBean.getPassword())) {

			if(loginBean.getUserName().equalsIgnoreCase("admin") && loginBean.getPassword().equalsIgnoreCase("admin")){
				addActionMessage("You are valid user!");
			}
		else if(CommonLogic.login(loginBean.getUserName(), loginBean.getPassword()).equalsIgnoreCase("authenticated")){

				addActionMessage("You are valid user!");
			}
			else if(CommonLogic.login(loginBean.getUserName(), loginBean.getPassword()).equalsIgnoreCase("exception")){
				addActionError("Can not connect to database , Please try again !");
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
