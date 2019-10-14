package com.uks.varad.struts.day1.assignment1.bean;

/**
 * @author: 	Varad Paralikar
 * Created Date:27/08/2019
 * Assignment:  Day 1
 * Task: 		Struts And Hibernate Skillup
 *
 */

/*
 * Class WelcomeBean class represents bean class for struts
 * @author: Varad Parlikar
 * Created Date: 2019/08/27
 */
public class WelcomeBean {

	private String message;

	/*
	 * constructor of bean class
	 */
	public WelcomeBean() {
		this.message = "Welcome To Struts 2 Application";
	}


	/*
	 * method getMessage returns message
	 * return type: String
	 */
	public String getMessage() {
		return message;
	}

	/*
	 *method setMessage sets message
	 *@String
	 *return type: void
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
