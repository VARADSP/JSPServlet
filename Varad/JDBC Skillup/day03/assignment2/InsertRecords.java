package com.uks.varad.jdbc.day03.assignment2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import com.uks.varad.jdbc.day01.assignment3.PropertyUtil;

/**
 * @author: 	Varad Paralikar
 * Created Date:2019/07/26
 * Assignment:  Day 3 assignment 2
 * Task:  	Inserting records into table
 *
 */

/*
 * Class InsertRecords connects to the database and inserts data into the table
 * by iterating over the table column wise.
 * @author: Varad Parlikar
 *  Created Date: 2019/07/26
 */
public class InsertRecords {

	Connection connection = null;
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
	 * method disconnect for closing the connection.
	 * return type : void
	 */
	void disconnect() throws SQLException {
		System.out.println("......................");
		System.out.println("Database Disconnected...");
		// closing the connection
		connection.close();
	}

	/*
	 * method insertRecords which inserts records into the table column wise iterating over the columns.
	 * @String command which is the select query passed to the function
	 * return type :void
	 */
	public void insertRecords(String command){
		Scanner scanner = new Scanner(System.in);
		do{
		//connecting to the database
		connect();
		Statement statement;
		ResultSet resultSet;
		try{
			statement = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
			resultSet = statement.executeQuery(command);
			//checking for empty table
			if(getRowCount(resultSet)==0){
				System.out.println("Table is empty");
				System.exit(0);
			}
			//table metadata
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			int columnCount = resultSetMetaData.getColumnCount();

			//move the result set to insert row
			resultSet.moveToInsertRow();



			int i =1;
			// The column count starts from 1
			while(i<=columnCount){
			  //getting column name and type
			  String name = resultSetMetaData.getColumnName(i);
			  String type = resultSetMetaData.getColumnTypeName(i);
			  //Entering value for column
			  System.out.println("Enter value for "+ name +" type ="+ type);
			  String input = scanner.next();

			  try{//checking column type and inserting value type wise
				  switch(type){
				  case "INT": resultSet.updateInt(i, Integer.parseInt(input));break;
				  case "FLOAT":resultSet.updateDouble(i, Double.parseDouble(input));break;
				  case "VARCHAR" : resultSet.updateString(i, input);break;
				  default: resultSet.updateString(i, input);break;
				  }
			  }catch(Exception e){
				  System.out.println("Wrong input entered");
				  continue;
			  }
			  i++;
			}


			//Use insertRow()
			resultSet.insertRow();

			//Move the ResultSet to current row.
			resultSet.moveToCurrentRow();

			System.out.println("Record inserted successfully");
			//disconnected from the database
			disconnect();
			System.out.println("Do you want to enter another record (Y | N)");
			String answer = scanner.next();
			if(answer.equalsIgnoreCase("Y") || answer.contains("y") || answer.contains("Y") ){
				continue;
			}else{
				break;
			}
		}
		catch(SQLException e){
			System.out.println("Error inserting record");
			continue;
		}
		}while(true);
		System.out.println("Exiting system...");
		try {
			//closing scanner
			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
