package com.uks.varad.struts.day5_6.assignment.action;
import com.opensymphony.xwork2.ActionSupport;
/**
 * @author: 	Varad Paralikar
 * Created Date:09/10/2019
 * Assignment:  Day 5-6
 * Task: 		Struts And Hibernate Skillup
 *
 */
/*
 * Class WelcomeAction is used to welcome user and change locale of the page
 * @author: Varad Parlikar
 * Created Date: 2019/9/09
 */
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
