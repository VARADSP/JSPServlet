package com.uks.varad.jdbc.day04.assignment1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import com.uks.varad.jdbc.day01.assignment3.PropertyUtil;

/**
 * @author: 	Varad Paralikar
 * Created Date:2019/07/29
 * Assignment:  Day 4 assignment 1
 * Task:  	Updating records into table
 *
 */

/*
 * Class UpdateRecords connects to the database and updates data of the table
 * by iterating over the table column wise.
 * @author: Varad Parlikar
 *  Created Date: 2019/07/29
 */
public class UpdateRecords {

	Connection connection = null;
	Scanner scanner = new Scanner(System.in);
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
	 * method display displays table data in row wise fashion.
	 * @ResultSet which is result set of table which is being passed to the function
	 * return type : void
	 */
	public void display(ResultSet resultSet){
		try{
			resultSet.beforeFirst();
			//table metadata
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			int columnCount = resultSetMetaData.getColumnCount();

			int i1 =1;
			int rowNumber = 1;
			String separator = "=";
			System.out.printf("%15s","RowNumber");
			// The column count starts from 1
			while(i1<=columnCount){
			  //getting column name and type
			  String name = resultSetMetaData.getColumnName(i1++);
			  //printing  column
			  System.out.printf("%15s",name);
			  separator += "=====================";
			}
			System.out.println();
			System.out.println(separator);

			while (resultSet.next()) {
				System.out.printf("%15s", rowNumber++);
				for (int i = 1; i <= columnCount; i++) {

					if (i > 1)System.out.print(" ");
					String columnValue = resultSet.getString(i);
					// Removing null values
					if(columnValue == null){
						columnValue = " ";
					}
					System.out.printf("%15s",columnValue);
				}
				System.out.println("");
			}

		}catch(Exception e){
			e.printStackTrace();
		}
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
	 * method update which is used to update the table data based on row number passed to the function
	 * @ResultSet which is result set of the table
	 * @String which is row number for updating the data
	 * return type : boolean
	 */
	public boolean update(ResultSet resultSet , String rowNumber) throws NumberFormatException, SQLException{
		ArrayList<String> columnNames = new ArrayList<String>();
		ArrayList<String> columnTypes = new ArrayList<String>();
		//table metadata
		ResultSetMetaData resultSetMetaData=null;
		int columnCount=0;
			 resultSetMetaData = resultSet.getMetaData();
			 columnCount = resultSetMetaData.getColumnCount();
				int i =1;
				while(i<=columnCount){//printing column number,name,type
					  //getting column name and type
					  String name = resultSetMetaData.getColumnName(i);
					  String type = resultSetMetaData.getColumnTypeName(i);

					  System.out.println("Column Number "+ i + " Column Name "+ name +" Column Type "+type);
					  columnNames.add(name);
					  columnTypes.add(type);
					  i++;
					}
		if(rowNumber.equals("*")){
			//update all

			System.out.println("Enter column numbers to update separated by comma ");
			String input = scanner.next();    // get the entire line after the prompt
			scanner.nextLine();
			String[] stringNumbers = input.split(",");
			Integer[] numbers = new Integer[stringNumbers.length];
			//converting column names into integers
			for(int index = 0 ; index<stringNumbers.length;index++){
				numbers[index] = Integer.parseInt(stringNumbers[index])-1;
			}
			//adding input data to a list
			ArrayList<String> inputValues = new ArrayList<String>();
			for(int i2 = 0 ; i2< numbers.length;i2++){
				  System.out.println("Enter value for "+ columnNames.get((numbers[i2])) +" type ="+ columnTypes.get((numbers[i2])));
				  //taking multiple line input
				  String value="";
			      value+=scanner.nextLine();
				  inputValues.add(value);
			}
			//updating fields of the table
			while(resultSet.next()){
				for(int i1 =0;i1<numbers.length;i1++){
					 switch(columnTypes.get((numbers[i1]))){
					  case "INT": resultSet.updateInt(columnNames.get((numbers[i1])), Integer.parseInt(inputValues.get(i1)));break;
					  case "FLOAT":resultSet.updateDouble(columnNames.get((numbers[i1])), Double.parseDouble(inputValues.get(i1)));break;
					  case "VARCHAR" : resultSet.updateString(columnNames.get((numbers[i1])), inputValues.get(i1));break;
					  default: resultSet.updateString(columnNames.get((numbers[i1])), inputValues.get(i1));break;
				}
				  }
				//Use updateRow()
				resultSet.updateRow();
			}


			return true;
		}
		else{
			try{

				Integer row = Integer.parseInt(rowNumber);
				//moving to that row
				resultSet.absolute(row);

				System.out.println("Enter column numbers to update separated by comma ");
				String input = scanner.next();    // get the entire line after the prompt
				scanner.nextLine();
				String[] stringNumbers = input.split(",");
				Integer[] numbers = new Integer[stringNumbers.length];
				//converting input column numbers to integers
				for(int index = 0 ; index<stringNumbers.length;index++){
					numbers[index] = Integer.parseInt(stringNumbers[index])-1;
				}
				//updating fields of the table
				for(int i2 = 0 ; i2< numbers.length;i2++){
					  System.out.println("Enter value for "+ columnNames.get((numbers[i2])) +" type ="+ columnTypes.get((numbers[i2])) + " Previous Value "
				+ resultSet.getString(columnNames.get(numbers[i2])));
					  //taking multiple line input
					  String value="";
				      value+=scanner.nextLine();

				      switch(columnTypes.get((numbers[i2]))){
					  case "INT": resultSet.updateInt(columnNames.get((numbers[i2])), Integer.parseInt(value));break;
					  case "FLOAT":resultSet.updateDouble(columnNames.get((numbers[i2])), Double.parseDouble(value));break;
					  case "VARCHAR" : resultSet.updateString(columnNames.get((numbers[i2])), value);break;
					  default: resultSet.updateString(columnNames.get((numbers[i2])), value);break;
					  }

				}
				//Use updateRow()
				resultSet.updateRow();
				return true;
			}
			catch(Exception e){
				System.out.println("Error occurred during updation of data");
				return false;
			}
		}

	}

	/*
	 * method updateRecords which updates records of the table column wise iterating over the columns.
	 * @String command which is the select query passed to the function
	 * return type :void
	 */
	public void updateRecords(String command){
		Scanner scanner = new Scanner(System.in);
		try{
			//connecting to the database
		connect();
		Statement statement;
		ResultSet resultSet;
		statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		resultSet = statement.executeQuery(command);
		//checking for empty table
		if(getRowCount(resultSet)==0){
			System.out.println("Table is empty");
			System.exit(0);
		}

		System.out.println("Before Updating Records Table Data");
		display(resultSet);
		do{
			System.out.println("Enter Row Number to update a row or * for all rows");
			String choice = scanner.next();

			//skipping the nextLine
			scanner.nextLine();
			//check if update is possible
			boolean isSuccessful = update(resultSet,choice);

			if(isSuccessful == false){
				continue;
			}
			choice = null;

			System.out.println("Record updated successfully");
			System.out.println("After updating records table data");
			display(resultSet);

			System.out.println("Do you want to update another record (Y | N)");
			String answer = scanner.next();
			if(answer.equalsIgnoreCase("Y") || answer.contains("y") || answer.contains("Y") ){
				resultSet.beforeFirst();
				continue;
			}else{
				break;
			}
		}while(true);

		}catch(SQLException e){
			System.out.println("Error updating record");
			updateRecords(command);
			scanner.close();
			return;
		}
		//disconnected from the database
		try {
			disconnect();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		System.out.println("Exiting system...");
		try {
			//closing scanner
			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}