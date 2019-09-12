package com.uks.varad.struts.day2.assignment1.bean;

/**
 * @author: 	Varad Paralikar
 * Created Date:29/08/2019
 * Assignment:  Day 2
 * Task: 		Struts And Hibernate Skillup
 *
 */

/*
 * Class LogicBean is used as bean class
 * @author: Varad Parlikar
 * Created Date: 2019/08/29
 */
public class LoginBean {
	
	private Integer userid;
	
	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	private String userName;
	private String password;



	/*
	 * method getUserName is used to return user name
	 * return type : String
	 */
	public String getUserName() {
		return userName;
	}

	/*
	 * method setUserName is used to set user name
	 * @String as username
	 * return type : void
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/*
	 * method getPassword returns password
	 * return type : String
	 */
	public String getPassword() {
		return password;
	}

	/*
	 * method setPassword sets the password
	 * @String as password
	 * return type : void
	 */
	public void setPassword(String password) {
		this.password = password;
	}





}
