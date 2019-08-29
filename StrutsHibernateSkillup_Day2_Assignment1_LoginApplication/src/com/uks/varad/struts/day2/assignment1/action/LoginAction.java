package com.uks.varad.struts.day2.assignment1.action;

/**
 * @author: 	Varad Paralikar
 * Created Date:27/08/2019
 * Assignment:  Day 1
 * Task: 		Struts And Hibernate Skillup
 *
 */
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.uks.varad.struts.commons.utils.CommonLogic;
import com.uks.varad.struts.day2.assignment1.bean.LoginBean;
import org.apache.commons.lang.xwork.StringUtils;
import org.apache.struts2.ServletActionContext;


/*
 * Class WelcomeAction is used to implement action for struts
 * @author: Varad Parlikar
 * Created Date: 2019/08/27
 */
@SuppressWarnings("serial")
public class LoginAction extends ActionSupport implements ModelDriven<LoginBean>{

	private LoginBean loginBean = new LoginBean();



	public String getUserName() {
		return loginBean.getUserName();
	}

	public void setUserName(String userName) {
		loginBean.setUserName(userName);
	}

	public String getPassword() {
		return loginBean.getPassword();
	}

	public void setPassword(String password) {
		loginBean.setPassword(password);
	}

	// all struts logic here
	public String execute() {

		ServletActionContext.getRequest().getSession().setAttribute("loggedInUser", loginBean.getUserName());
		return "login-success";

	}

	// simple validation
	public void validate() {



		if (StringUtils.isNotEmpty(loginBean.getUserName())
				&& StringUtils.isNotEmpty(loginBean.getPassword())) {
			if(CommonLogic.login(loginBean.getUserName(), loginBean.getPassword())){
				addActionMessage("You are valid user!");
			}
			else{
				addActionError("Username and password is invalid !");
			}

		}
		else if(StringUtils.isEmpty(loginBean.getUserName()) && StringUtils.isEmpty(loginBean.getPassword()) ) {
			addActionError("Username and Password can not be blank !");
		}
		else if(StringUtils.isEmpty(loginBean.getUserName())) {
			addActionError("Username can not be blank !");
		}
		else if(StringUtils.isEmpty(loginBean.getPassword())) {
			addActionError("Password can not be blank !");
		}



	}

	@Override
	public LoginBean getModel() {
		return loginBean;
	}

}
