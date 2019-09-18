package com.uks.varad.jdbc.day01.assignment2;

/**
 *
 */

import java.sql.*;

/**
 * @author: Varad Paralikar
 * Created Date:2019/07/22
 * Assignment: Day 1
 * Task: JDBC
 *
 */

/*
 * Class RecordDisplay uses JDBC to connect to northwind_varad database and
 * displays rows from employees table
 *
 * @author: Varad Parlikar
 * Created Date: 2019/07/22
 */
public class RecordDisplay {

	/**
	 * @param args
	 */

	// initializing the object of connection
	Connection connection;

	/*
	 * method connection for creating the connection to the database.
	 *
	 * @String username which is username for database connection
	 *
	 * @String password which is password for database connection
	 * return type : void
	 */
	void connect(String username, String password) {
		try {
			// searching for mysql driver class
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Database Connecting...");
			System.out.println("......................");
			// connecting to the database
			connection = DriverManager.getConnection("jdbc:mysql://172.16.1.15:3306/northwind_varad", username,
					password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * method displayRecords for Display the details of the employee class.
	 *
	 * @String query which contains query to be executed on the table specified
	 * return type : void
	 */
	void displayRecords(String query) throws SQLException {
		try {
			Statement statement = connection.createStatement();
			// fire query and store result in resultSet
			ResultSet resultSet = statement.executeQuery(query);

			//checking if table is empty
			if(getRowCount(resultSet)==0){
				System.out.println("Table is empty");
				disconnect();
				System.exit(0);
			}

			// for formatting of the Headers
			System.out.printf("%5s %15s %30s %40s %45s \n", "Employee ID", "Name", "Title", "Address", "HomePhone");
			System.out.println(
					"==============================================================================================================================================================");
			String employeeId,name,title,address,homePhone;
			// is executed until no more rows is there
			while (resultSet.next()) {
				employeeId = resultSet.getString(1);
				name = resultSet.getString(2);
				title = resultSet.getString(3);
				address = resultSet.getString(4);
				homePhone = resultSet.getString(5);

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

				// Printing the Result in tabular format
				System.out.format("%-20s %-30s %-30s %-50s %-25s \n", employeeId, name,
						title, address, homePhone);
			}
			System.out.println(
					"==============================================================================================================================================================");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	/*
	 * method getRowCount returns total number of rows in a table.
	 * return type : int
	 */
	public int getRowCount(ResultSet resultSet){
		int size = 0;
		// calculating total resultset size
		try {
			resultSet.last();
			size = resultSet.getRow();
			resultSet.beforeFirst();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return size;
	}


	/*
	 * method displayRecords for Display the details of the employees from
	 * Employee Table with filtering by Employee ID.
	 *
	 * @String query which contains query to be executed on the table specified
	 *
	 * @String EmployeeID which is used for filtering rows
	 * return type : void
	 */
	void displayRecords(String query, String employeeID) throws SQLException {
		try {

			Statement statement = connection.createStatement();
			// fire query and store result in resultSet
			ResultSet resultSet = statement.executeQuery(query);
			// for formatting of the Headers
			boolean isFound = false;

			String employeeId,name,title,address,homePhone;
			// is executed until no more rows is there
			while (resultSet.next()) {

				if (resultSet.getString(1).equals(employeeID)) {

					isFound = true;
					System.out.printf("%5s %15s %30s %40s %45s \n", "Employee ID", "Name", "Title", "Address", "HomePhone");
					System.out.println(
							"==============================================================================================================================================================");

					employeeId = resultSet.getString(1);
					name = resultSet.getString(2);
					title = resultSet.getString(3);
					address = resultSet.getString(4);
					homePhone = resultSet.getString(5);

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


					// Printing the Result in tabular format
					System.out.format("%-20s %-30s %-30s %-50s %-25s \n", employeeId, name,
							title, address, homePhone);
				}
			}
				if(!isFound){
					System.out.println("No Records found for Employee id = "+ employeeID);
					System.exit(0);
				}
			System.out.println(
					"==============================================================================================================================================================");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * method disconnect for closing the conncetion.
	 * return type : void
	 */
	void disconnect() throws SQLException {
		System.out.println("......................");
		System.out.println("Database DisConnected...");
		// closing the connection
		connection.close();
	}

}
