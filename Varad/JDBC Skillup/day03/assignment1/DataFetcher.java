package com.uks.varad.jdbc.day03.assignment1_trial;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;


import com.uks.varad.jdbc.day01.assignment3.PropertyUtil;


/**
 * @author: 	Varad Paralikar
 * Created Date:2019/07/25
 * Assignment:  Day 3
 * Task:  	Understanding RowSet
 *
 */


/*
 * Class DataFetcher uses multiple methods to connect to the database and return cached row set , web row set
 * of data and display it.
 * @author: Varad Parlikar
 *  Created Date: 2019/07/25
 */
public class DataFetcher {
	String command,dataSourceName;
	Connection connection = null;
	//variable for checking if table is empty
	private boolean isEmpty=false;

	//constructor for DataFetcher class which initialises class variables.
	public DataFetcher(String command, String dataSourceName) {
		this.command = command;
		this.dataSourceName = dataSourceName;
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
	 * method executeInCached for display the data using the CachedRowSet methods.
	 * return type : CachedRowSet
	 */
		CachedRowSet executeInCached() throws SQLException{
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(command);

			if(getRowCount(resultSet)==0){
				System.out.println("Table is empty");
				this.isEmpty = true;
				System.exit(0);
			}
			RowSetFactory factory = RowSetProvider.newFactory();
			CachedRowSet rowSet = factory.createCachedRowSet();
			rowSet.populate(resultSet);
			disconnect();
			return rowSet;
		}

		/*
		 * method executeInXML for display the data using the WebRowSet method.
		 * return type : WebRowSet
		 */
		WebRowSet executeInXML() throws SQLException{
			RowSetFactory factory = RowSetProvider.newFactory();
			WebRowSet webRowSet = factory.createWebRowSet();
			if(this.isEmpty){
				System.out.println("Table is empty");
				System.exit(0);
			}
			webRowSet.setCommand(command);
			webRowSet.execute(connection);
			disconnect();
			return webRowSet;
		}
}
