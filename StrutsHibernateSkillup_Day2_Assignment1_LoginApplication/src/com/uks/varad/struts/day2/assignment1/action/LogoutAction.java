package com.uks.varad.struts.day2.assignment1.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class LogoutAction extends ActionSupport {

	// all struts logic here
	public String execute() {

		ServletActionContext.getRequest().getSession().invalidate();
		addActionMessage("You are successfully logout!");
		return "logout";

	}
}