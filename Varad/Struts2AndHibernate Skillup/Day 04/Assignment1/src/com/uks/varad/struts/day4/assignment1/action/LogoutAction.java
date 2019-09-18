package com.uks.varad.struts.day4.assignment1.action;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author: 	Varad Paralikar
 * Created Date:02/09/2019
 * Assignment:  Day 4
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
		try{
		HttpServletResponse httpResponse= ServletActionContext.getResponse();
		httpResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		httpResponse.addHeader("Cache-Control", "post-check=0, pre-check=0");
		httpResponse.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		httpResponse.setDateHeader("Expires", 0); // Proxies.
		 HttpSession session = ServletActionContext.getRequest().getSession();
          session.invalidate();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return "logout";
	}
}