package com.uks.varad.jdbc.day02.assignment1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import com.uks.varad.jdbc.day01.assignment3.PropertyUtil;

/**
 * @author: 	Varad Paralikar
 * Created Date:2019/07/23
 * Assignment:  Day 2 assignment1
 * Task: 		JDBC
 */


/*
 * Class DisplayUI contains methods to display data from employee table in required format.
 * @author: Varad Parlikar
 *  Created Date: 2019/07/23
 */
public class DisplayUI {

	static Connection connection;
	static Scanner scanner;
	//set of input values
	static String[] setOfInputs = {"N","P","X"};


	/*
	 * static method connect which makes the connection to the database using PropertyUtil class variables for
	 * making the connection.
	 * return type : void
	 */
	public static void connect(){
		try {
			//creating object of PropertyUtil class
			new PropertyUtil();
			//searching for mysql driver class
			Class.forName(PropertyUtil.databaseDriverClass);
			System.out.println("Database Connecting...");
			System.out.println("......................");
			//connecting to the database
			connection = DriverManager.getConnection(PropertyUtil.databaseUrl,PropertyUtil.databaseUsername,PropertyUtil.databasePassword);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/*
	 * method disconnect for closing the conncetion.
	 * return type : void
	 */
	static void disconnect() throws SQLException {
		System.out.println("......................");
		System.out.println("Database DisConnected...");
		// closing the connection
		connection.close();
	}



	/*
	 * static method displayRowsPerPage fetches enployee data from the database and stores it in collection format to
	 * display on per page basis.
	 * return type : void
	 */
	static public void displayRowsPerPage(){

		//making connection to the database
		connect();

		//RowsFetcher class object 7 rows per page
		RowsFetcher rowsFetcher = new RowsFetcher(7,connection);
		ArrayList<EmpData> employees;
		String scroll="F";
		employees = rowsFetcher.getRowsPerPage("F");//initial front page printing

		System.out.println("==============================================================================================================================================================");
		display(employees);
		System.out.println("==============================================================================================================================================================");
		while(true){


			//input choice from user
			scanner = new Scanner(System.in);
			System.out.print("Press N for next page");
			System.out.print("     Press P for previous page");
			System.out.print("     Press X to exit");
			System.out.println();
			System.out.println("==============================================================================================================================================================");
			scroll = scanner.next();
			scanner.nextLine();

			if(!Arrays.asList(setOfInputs).contains(scroll)){
				System.out.println("Wrong Input Provided");
				displayRowsPerPage();
			}

			//get employee data after forward or previous scrolling
			employees = rowsFetcher.getRowsPerPage(scroll);
			//On Exit condition
			if(employees.isEmpty()){
				try {
					//closing database connection
					disconnect();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			}
			System.out.println("==============================================================================================================================================================");
			display(employees);
			System.out.println("==============================================================================================================================================================");

		}
	}

	/*
	 * static method display displays employee data which is passed through collection list of employees
	 * as a parameter to the function, it displays employeeId,name,title,address,homePhone.
	 * @String ArrayList<EmpData> which is list of employees collection.
	 * return type : void
	 */
	static public void display(ArrayList<EmpData> employees){
		for(EmpData employee : employees){
			String employeeId,name,title,address,homePhone;
			employeeId = employee.getEmployeeId();
			name = employee.getName();
			title = employee.getTitle();
			address = employee.getAddress();
			homePhone = employee.getHomePhone();

			if(employeeId == null){
				employeeId = " ";
			}
			if(name == null){
				name = " ";
			}
			if(title == null){
				title = " ";
			}
			if(address == null){
				address = " ";
			}
			if(homePhone == null){
				homePhone = " ";
			}



			System.out.format("%-20s %-30s %-30s %-50s %-25s \n",employeeId,name,title,address,homePhone);
			System.out.println();
		}
	}

	//main method
	public static void main(String[] args) {
		try{
			DisplayUI.displayRowsPerPage();
		}
		catch(Exception e){
			System.out.println(" ");
		}
	}
}
