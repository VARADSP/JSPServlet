package com.uks.varad.struts.day5_6.assignment.action;

import com.opensymphony.xwork2.ActionSupport;

public class WelcomeAction extends ActionSupport {

	@Override
	public String execute() {
		return SUCCESS;
	}

	private String username;
	private String address;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
