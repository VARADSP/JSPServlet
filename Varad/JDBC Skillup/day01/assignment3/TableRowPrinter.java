package com.uks.varad.jdbc.day01.assignment3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author: Varad Paralikar
 * Created Date:2019/07/22
 * Assignment: Day 1
 * Task: JDBC
 */

/*
 * Class TableRowPrinter defines methods to connect to the database using JDBC ,
 * print rows from table and filter them by Employee ID
 *
 * @author: Varad Parlikar
 * Created Date: 2019/07/22
 */
public class TableRowPrinter {
	Connection connection;

	/*
	 * method connect for creating the connection to the database.
	 * return type :void
	 */
	public void connect() {
		try {
			// creating object of PropertyUtil class
			new PropertyUtil();
			// searching for mysql driver class
			Class.forName(PropertyUtil.databaseDriverClass);
			System.out.println("Database Connecting...");
			System.out.println("......................");
			// connecting to the database
			connection = DriverManager.getConnection(PropertyUtil.databaseUrl, PropertyUtil.databaseUsername,
					PropertyUtil.databasePassword);
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
	void disconnect() throws SQLException {
		System.out.println("......................");
		System.out.println("Database DisConnected...");
		// closing the connection
		connection.close();
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
	 * method printRows for Display the details of the employee class.
	 * return type : void
	 */
	public void printRows() {
		try {
			connect();
			Statement statement = connection.createStatement();
			// fire query and store result in resultSet
			ResultSet resultSet = statement.executeQuery(
					"SELECT EmployeeID, concat(FirstName,' ', LastName) as FullName,Title,concat(Address ,',',city,',' ,country) as Address,HomePhone FROM employees");
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

			//closing connection
			disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
