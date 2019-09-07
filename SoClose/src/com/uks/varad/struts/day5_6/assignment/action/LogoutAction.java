package com.uks.varad.struts.day5_6.assignment.action;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author: 	Varad Paralikar
 * Created Date:29/08/2019
 * Assignment:  Day 2
 * Task: 		Struts And Hibernate Skillup
 *
 */

/*
 * Class LogoutAction is used as action class for logout
 * @author: Varad Parlikar
 * Created Date: 2019/08/29
 */
@SuppressWarnings("serial")
public class LogoutAction extends ActionSupport {
	/*
	 * method execute implemented method for action class
	 * return type : String
	 */
	// all struts logic here
	public String execute() {
		HttpServletResponse httpResponse= ServletActionContext.getResponse();
		httpResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		httpResponse.addHeader("Cache-Control", "post-check=0, pre-check=0");
		httpResponse.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		httpResponse.setDateHeader("Expires", 0); // Proxies.
		 HttpSession session = ServletActionContext.getRequest().getSession(false);
		  session.setAttribute("loggedInUser", null);
          session.invalidate();
		addActionMessage("You are successfully logout!");
		return "logout";
	}
}