package com.uks.varad.servlet.assignment7;

public class User {
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







	public User(String uid, String salutation, String firstName, String middleName, String lastName, String gender,
			String email, String dateOfBirth, String address, String username, String password, String interest,
			String otherInterest) {
		super();
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
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}

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


	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public String getOtherInterest() {
		return otherInterest;
	}

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
}
