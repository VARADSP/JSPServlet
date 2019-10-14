package com.uks.varad.jdbc.day02.assignment1;

/**
 * @author: Varad Paralikar
 * Created Date:2019/07/23
 * Assignment: Day 2 assignment1
 * Task: JDBC
 */

/*
 * Class EmpData contains fields and methods required to implement employee
 * object.
 *
 * @author: Varad Parlikar
 * Created Date: 2019/07/23
 */
public class EmpData {
	private String employeeId, name, title, address, homePhone;

	// parameterised constructor
	public EmpData(String employeeId, String name, String title, String address, String homePhone) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.title = title;
		this.address = address;
		this.homePhone = homePhone;
	}

	/*
	 * method getEmployeeId returns employee id.
	 * return type : String
	 */
	public String getEmployeeId() {
		return employeeId;
	}

	/*
	 * method setEmployeeId sets employee id.
	 *
	 * @String employeeId which is to be set
	 * return type : void
	 */
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	/*
	 * method getName returns employee name.
	 * return type : String
	 */
	public String getName() {
		return name;
	}

	/*
	 * method setName sets employee name.
	 *
	 * @String name which is to be set
	 * return type : void
	 */
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * method getTitle returns employee title.
	 * return type : String
	 */
	public String getTitle() {
		return title;
	}

	/*
	 * method setTitle sets employee title.
	 *
	 * @String title which is to be set
	 * return type : void
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/*
	 * method getAddress returns employee address.
	 * return type : String
	 */
	public String getAddress() {
		return address;
	}

	/*
	 * method setAddress sets employee address.
	 *
	 * @String address which is to be set
	 * return type : void
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/*
	 * method getHomePhone returns employee homephone.
	 * return type : String
	 */
	public String getHomePhone() {
		return homePhone;
	}

	/*
	 * method setHomePhone sets employee home phone.
	 *
	 * @String homePhone which is to be set
	 * return type : void
	 */
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

}
