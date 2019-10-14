package com.uks.varad.core.day4.assignment1;
public class ProjectLeader extends Employee {
		private String mobileNumber;
		public ProjectLeader() { empType="PL"; mobileNumber="+918830256843";	}
		public void print(){ System.out.println("Employee First Name = "+firstName + "\nEmployee Last Name = "+lastName + "\nEmployee Type = "+empType + "\nEmployee Mobile Number = "+mobileNumber); }
}