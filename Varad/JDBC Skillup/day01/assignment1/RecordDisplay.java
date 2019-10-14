package com.uks.varad.jdbc.day01.assignment1;

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
	 * method connection for creating the connection to the database using Type1 Driver.
	 *
	 * @String username which is username for database connection
	 *
	 * @String password which is password for database connection
	 * return type :void
	 */
	void connect(String username, String password) {
		try {
			// sun.jdbc.odbc.JdbcOdbcDriver Type 1 Driver
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("Database Connecting using Type 1 Driver...");
			System.out.println("......................");
			// connecting to the database
			connection = DriverManager.getConnection("jdbc:odbc:data1");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
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
	 * method displayRecords for Display the details of the employee class.
	 *
	 * @String query which contains query to be executed on the table specified
	 * return type : void
	 */
	void displayRecords(String query) throws SQLException {
		try {
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
			// fire query and store result in resultSet
			ResultSet resultSet = statement.executeQuery(query);

			//checking if table is empty
			if (getRowCount(resultSet)==0 ) {
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
