package com.uks.varad.jdbc.day03.assignment1_trial;

/**
*
*/


import java.sql.SQLException;
import java.util.Scanner;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.WebRowSet;

/**
 * @author: 	Varad Paralikar
 * Created Date:2019/07/25
 * Assignment:  Day 3
 * Task:  	Understanding RowSet
 *
 */


/*
 * Class RowSetDisplayer which displays data returned by DataFetcher in cached row set and web row set.
 * @author: Varad Parlikar
 *  Created Date: 2019/07/25
 */
public class RowSetDisplayer {

	//Cretaing object of DataFetcher class
	DataFetcher dataFetcher = new DataFetcher("select EmployeeID, LastName, FirstName, Title, DATE(BirthDate) from Employees","Northwind");
	private String employeeId,firstName,lastName,title,birthDate;



	//main method
	public static void main(String[] args) {
		try{

			//Creating object and calling the DisplayEmpData method
			RowSetDisplayer rowSetDisplayer = new RowSetDisplayer();
			rowSetDisplayer.displayEmpData();

		}
		catch(Exception e){
			System.out.println("Wrong input provided");
		}
	}

	/*
	 * method displayEmpData which displays employee data as cached row set or web row set based on
	 * input provided.
	 * return type : void
	 */
	public void displayEmpData() throws SQLException{
		try{

		//Getting the input from user
		System.out.println("Enter the input 1 for Cached");
		System.out.println("Enter the input 2 for XML");
		System.out.println("Enter the input 3 for exit");

		Scanner scanner = new Scanner(System.in);
		int choiceNumber = scanner.nextInt();
		//Establishing the connection
		dataFetcher.connect();
		//user enters 1 then Cached function is called
		if(choiceNumber == 1){
			CachedRowSet rowset = dataFetcher.executeInCached();
			displayCached(rowset);
		}
		//user enters 1 then Cached function is called
		else if(choiceNumber ==2){
			WebRowSet rowset = dataFetcher.executeInXML();
			displayXML(rowset);
		}
		else if(choiceNumber == 3){
			dataFetcher.disconnect();
			System.out.println("Exiting System");
			System.exit(0);
		}
		//Enter other than 0 or 1
		else{
			dataFetcher.disconnect();
			System.out.println("Entered wroung input");
		}

		displayEmpData();
		scanner.close();
		 return;
	}
		catch(Exception e){
			System.out.println("Wrong input provided");
			displayEmpData();
			return;
		}
	}


	/*
	 * method displayCached which displays cached row set data in table format.
	 * @CachedRowSet which is passed to the method to display data.
	 * return type : void
	 */
	public void displayCached(CachedRowSet rowSet) throws SQLException{
		//Default header is printing
		System.out.printf("%10s %20s %20s %30s %30s \n", "Employee ID","Last Name","First Name","Title","Birth Date");
		System.out.println("==========================================================================================================================");

		while(rowSet.next()){
			this.employeeId = rowSet.getString(1);
			this.lastName = rowSet.getString(2);
			this.firstName = rowSet.getString(3);
			this.title = rowSet.getString(4);
			this.birthDate = rowSet.getString(5);
			//checking for null values
			if(this.employeeId == null){
				this.employeeId = " ";
			}
			if(this.firstName == null){
				this.firstName = " ";
			}
			if(this.lastName == null){
				this.lastName = " ";
			}
			if(this.title == null){
				this.title = " ";
			}
			if(this.birthDate == null){
				this.birthDate = " ";
			}

			System.out.printf("%10s %20s %20s %30s %30s \n", this.employeeId,this.lastName,this.firstName,this.title,this.birthDate);
			System.out.println();
		}
		System.out.println("==========================================================================================================================");
	}

	/*
	 * method displayXML which displays web row set data in table format.
	 * @WebRowSet which is passed to the method to display data.
	 * return type : void
	 */
	public void displayXML(WebRowSet rowSet) throws SQLException{
		//Default header is printing
		System.out.printf("%10s %20s %20s %30s %30s \n", "Employee ID","Last Name","First Name","Title","Birth Date");
		System.out.println("==========================================================================================================================");
		while(rowSet.next()){
			this.employeeId = rowSet.getString(1);
			this.lastName = rowSet.getString(2);
			this.firstName = rowSet.getString(3);
			this.title = rowSet.getString(4);
			this.birthDate = rowSet.getString(5);

			if(this.employeeId == null){
				this.employeeId = " ";
			}
			if(this.firstName == null){
				this.firstName = " ";
			}
			if(this.lastName == null){
				this.lastName = " ";
			}
			if(this.title == null){
				this.title = " ";
			}
			if(this.birthDate == null){
				this.birthDate = " ";
			}

			System.out.printf("%10s %20s %20s %30s %30s \n", this.employeeId,this.lastName,this.firstName,this.title,this.birthDate);
			System.out.println();
		}
		System.out.println("==========================================================================================================================");
	}
}
