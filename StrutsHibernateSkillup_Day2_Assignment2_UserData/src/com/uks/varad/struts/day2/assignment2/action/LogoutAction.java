package com.uks.varad.struts.day2.assignment2.action;

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

		ServletActionContext.getRequest().getSession().invalidate();
		addActionMessage("You are successfully logout!");
		return "logout";

	}
}