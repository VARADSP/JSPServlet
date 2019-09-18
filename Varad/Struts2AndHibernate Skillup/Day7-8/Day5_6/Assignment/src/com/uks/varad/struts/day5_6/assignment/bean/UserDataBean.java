package com.uks.varad.struts.day5_6.assignment.bean;
/**
 * @author: 	Varad Paralikar
 * Created Date:09/10/2019
 * Assignment:  Day 5-6
 * Task: 		Struts And Hibernate Skillup
 *
 */
/*
 * Class UserDataBean is used as bean class
 * @author: Varad Parlikar
 * Created Date: 2019/9/9
 */
public class UserDataBean {
	private String name,category,sex,address,emailId,isDisabled;
	private Integer userId;
	/*
	 * method getIsDisabled gets disabled value
	 * return type:String
	 */
	public String getIsDisabled() {
		return isDisabled;
	}
	/*
	 * method setIsDisabled sets the value
	 * @String isDisabled
	 * return type:String
	 */
	public void setIsDisabled(String isDisabled) {
		this.isDisabled = isDisabled;
	}
	/*
	 * method getName returns name
	 * return type:String
	 */
	public String getName() {
		return name;
	}
	/*
	 * method getUserId returns userid
	 * return type:String
	 */
	public Integer getUserId() {
		return userId;
	}
	/*
	 * method setUserId sets user id
	 * @Integer userId
	 * return type:void
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/*
	 * method setName sets the value
	 * @String isDisabled
	 * return type:String
	 */
	public void setName(String name) {
		this.name = name;
	}
	/*
	 * method getCategory gets the value
	 * @String isDisabled
	 * return type:String
	 */
	public String getCategory() {
		return category;
	}
	/*
	 * method setCategory sets the value
	 * @String isDisabled
	 * return type:String
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/*
	 * method getSex gets the value
	 * @String isDisabled
	 * return type:String
	 */
	public String getSex() {
		return sex;
	}
	/*
	 * method etSex sets the value
	 * @String isDisabled
	 * return type:String
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/*
	 * method getAddress gets the value
	 * @String isDisabled
	 * return type:String
	 */
	public String getAddress() {
		return address;
	}
	/*
	 * method setAddress sets the value
	 * @String isDisabled
	 * return type:String
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/*
	 * method getEmailId gets the value
	 * @String isDisabled
	 * return type:String
	 */
	public String getEmailId() {
		return emailId;
	}
	/*
	 * method setEmailId sets the value
	 * @String isDisabled
	 * return type:String
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	@Override
	public String toString() {
		return "UserListBean [userId=" + userId + ", name=" + name + ", category=" + category + ", sex="
				+ sex + ", address=" + address + ", emailId=" + emailId + "]";
	}
}
