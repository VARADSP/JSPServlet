package com.uks.varad.struts.day2.assignment2.bean;

/**
 * @author: 	Varad Paralikar
 * Created Date:29/08/2019
 * Assignment:  Day 2
 * Task: 		Struts And Hibernate Skillup
 *
 */

/*
 * Class UserDataBean is used as bean class
 * @author: Varad Parlikar
 * Created Date: 2019/08/29
 */
public class UserDataBean {
	private String firstName,middleName,lastName,gender,emailId,contactNo;

	/*
	 * method getFirstName returns first name
	 * return type : String
	 */
	public String getFirstName() {
		return firstName;
	}

	/*
	 * method setFirstName sets first name
	 * @String firstName
	 * return type : void
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/*
	 * method getMiddleName returns middle name
	 * return type : String
	 */
	public String getMiddleName() {
		return middleName;
	}

	/*
	 * method setMiddleName sets middle name
	 * @String firstName
	 * return type : void
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/*
	 * method getLastName returns last name
	 * return type : String
	 */
	public String getLastName() {
		return lastName;
	}

	/*
	 * method setlasttName sets last name
	 * @String firstName
	 * return type : void
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/*
	 * method getGender returns gender name
	 * return type : String
	 */
	public String getGender() {
		return gender;
	}

	/*
	 * method setGedner sets gender name
	 * @String gender
	 * return type : void
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/*
	 * method getEmailId returns email Id
	 * return type : String
	 */
	public String getEmailId() {
		return emailId;
	}

	/*
	 * method setEmailId sets email id
	 * @String email id
	 * return type : void
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/*
	 * method getContactNo returns contact no
	 * return type : String
	 */
	public String getContactNo() {
		return contactNo;
	}

	/*
	 * method setContactNo sets contact no
	 * @String contactNo
	 * return type : void
	 */
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}



}
