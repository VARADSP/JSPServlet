package com.uks.varad.jdbc.day04.assignment2;

/**
 *
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.uks.varad.jdbc.day01.assignment3.PropertyUtil;

/**
 * @author: 	Varad Paralikar
 * Created Date:2019/07/29
 * Assignment:  Day 4 assignment 2
 * Task:  	study of metadata of table
 *
 */


/*
 * Class MetaData contains methods to print metadata of the table,make connection,get total number of
 * rows in a table..
 * @author: Varad Parlikar
 *  Created Date: 2019/07/29
 */
public class MetaData {

	static Connection connection = null;
	static DatabaseMetaData databaseMetadata = null;
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
			databaseMetadata = connection.getMetaData();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	 /**
     * method printGeneralMetadata prints in the console the general meta data of the database.
     * return type : void
     */
    public static void printGeneralMetadata() throws SQLException {
        System.out.println("Database Product Name: "
                + databaseMetadata.getDatabaseProductName());
        System.out.println("Database Product Version: "
                + databaseMetadata.getDatabaseProductVersion());
        System.out.println("Logged User: " + databaseMetadata.getUserName());
        System.out.println("JDBC Driver: " + databaseMetadata.getDriverName());
        System.out.println("Driver Version: " + databaseMetadata.getDriverVersion());
        System.out.println();
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
	 * Method printMetaData which is used to print the meta data such as column names and types in a table.
	 * @ResultSet which is result set of the processed query
	 * return type : void
	 */
	public void printMetaData(ResultSet resultSet) throws SQLException{
		//table metadata
		ResultSetMetaData resultSetMetaData=null;
		int columnCount=0;
			 resultSetMetaData = resultSet.getMetaData();
			 columnCount = resultSetMetaData.getColumnCount();
				int i =1;
				while(i<=columnCount){
					  //getting column name and type
					  String name = resultSetMetaData.getColumnName(i);
					  String type = resultSetMetaData.getColumnTypeName(i);

					  System.out.println("Column Number "+ i + " Column Name "+ name +" Column Type "+type);
					  i++;
					}
	}

	/*
	 * Method to perform operations with result set meta data.
	 * @String which is query to be processed
	 * return type : void
	 */
	public void getMetadata(String command) {
		try {
			Statement statement = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
			ResultSet resultSet = statement.executeQuery(command);
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			System.out.println("Database Meta Data");
			System.out.println();
			printGeneralMetadata();
			System.out.println();
			System.out.println("Meta Data of Table " + resultSetMetaData.getTableName(1));
			System.out.println();
			System.out.println("Total No of columns in this table: " + resultSetMetaData.getColumnCount());
			printMetaData(resultSet);
			System.out.println("Total Number of Rows in the table = " + getRowCount(resultSet));
			if(getRowCount(resultSet)==0){
				System.out.println("Table is empty");
				disconnect();
				System.exit(0);
			}
			System.out.println("Table Data");
			display(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * method disconnect which is used to disconnect the database.
	 * return type : void
	 */
	public void disconnect() throws SQLException {
		connection.close();
		System.out.println("......................");
		System.out.println("Database Disconnected...");
	}
}
