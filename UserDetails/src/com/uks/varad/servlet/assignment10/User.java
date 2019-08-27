package com.uks.varad.servlet.assignment10;

/*
 * User class is used to manage data of user, this acts as POJO Class
 * @author: Varad Paralikar
 * @Created Date : 2019/08/21
 */
public class User {
<<<<<<< HEAD
	private String userNo;
=======
>>>>>>> 719ac6aeedbbf9c130e8c58ddda737edeb250faf
	private String uid;
	private String salutation;
	private String firstName;
	private String middleName;
	private String lastName;
	private String gender;
	private String email;
	private String dateOfBirth;
	private String address;
	private String username;
	private String password;
	private String interest;
	private String otherInterest;

<<<<<<< HEAD
	public User(String userNo,String uid, String salutation, String firstName, String middleName, String lastName, String gender,
			String email, String dateOfBirth, String address, String username, String password, String interest,
			String otherInterest) {
		super();
		this.userNo = userNo;
=======






	public User(String uid, String salutation, String firstName, String middleName, String lastName, String gender,
			String email, String dateOfBirth, String address, String username, String password, String interest,
			String otherInterest) {
		super();
>>>>>>> 719ac6aeedbbf9c130e8c58ddda737edeb250faf
		this.uid = uid;
		this.salutation = salutation;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.username = username;
		this.password = password;
		this.interest = interest;
		this.otherInterest = otherInterest;
	}
<<<<<<< HEAD
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
=======
>>>>>>> 719ac6aeedbbf9c130e8c58ddda737edeb250faf
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
<<<<<<< HEAD
	public String getSalutation() {
		return salutation;
	}
	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
=======

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}


	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


>>>>>>> 719ac6aeedbbf9c130e8c58ddda737edeb250faf
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
<<<<<<< HEAD
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	public String getOtherInterest() {
		return otherInterest;
	}
=======

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public String getOtherInterest() {
		return otherInterest;
	}

>>>>>>> 719ac6aeedbbf9c130e8c58ddda737edeb250faf
	public void setOtherInterest(String otherInterest) {
		this.otherInterest = otherInterest;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", salutation=" + salutation + ", firstName=" + firstName + ", middleName="
				+ middleName + ", lastName=" + lastName + ", gender=" + gender + ", email=" + email + ", dateOfBirth="
				+ dateOfBirth + ", address=" + address + ", username=" + username + ", password=" + password
				+ ", interest=" + interest + ", otherInterest=" + otherInterest + "]";
	}
<<<<<<< HEAD
}
=======
}
>>>>>>> 719ac6aeedbbf9c130e8c58ddda737edeb250faf
