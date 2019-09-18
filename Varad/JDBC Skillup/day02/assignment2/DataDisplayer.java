package com.uks.varad.jdbc.day02.assignment2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import com.uks.varad.jdbc.day01.assignment3.PropertyUtil;
import com.uks.varad.jdbc.day02.assignment1.EmpData;

/**
 * @author: 	Varad Paralikar
 * Created Date:2019/07/24
 * Assignment:  Day 2 assignment2
 * Task: 		JDBC
 */

/*
 * Class DataDisplayer contains methods to display data from database tables by executing procedure in required format.
 * @author: Varad Parlikar
 *  Created Date: 2019/07/24
 */
public class DataDisplayer {

	static Connection connection;
	static Scanner scanner;

	//set of input values
	static String[] setOfInputs = {"N","P","X"};


	/*
	 * static method connect which makes the connection to the database using PropertyUtil class variables for
	 * making the connection.
	 * return type : void
	 */
		static public void connect(){
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
		 * static method displayRowsPerPage fetches table data returned from procedure execution
		 * from the database and stores it in collection format to
		 * display on per page basis.
		 * @String orderYear to be passed to procedure execution
		 * @String categoryName to be passed to procedure execution
		 * return type : void
		 */
		static public void displayRowsPerPage(String orderYear,String categoryName){
			//making connection to the database
			connect();
			//RowsFetcher class object 7 rows per page
			SalesByCategoryRunner salesByCategoryRunner = new SalesByCategoryRunner(7,connection);
			ArrayList<SalesByCatData> sales;
			String scroll="F";
			System.out.println("==============================================================================================================================================================");
			sales = salesByCategoryRunner.fetchRecords("F",orderYear,categoryName);//initial front page printing
			display(sales);
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
					displayRowsPerPage(orderYear,categoryName);
				}

				//get employee data after forward or previous scrolling
				sales = salesByCategoryRunner.fetchRecords(scroll,orderYear,categoryName);
				//On exit condition
				if(sales.isEmpty()){
					//closing the connection
					try {
						disconnect();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
				}
				System.out.println("==============================================================================================================================================================");
				display(sales);
				System.out.println("==============================================================================================================================================================");
			}

		}


		/*
		 * static method display displays sales data from sales collection, it displays product name and
		 * total purchase.
		 * @String ArrayList<SalesByCatData> which is list of sales collection.
		 * return type : void
		 */
		static public void display(ArrayList<SalesByCatData> sales){
			for(SalesByCatData sale : sales){
				String productName;
				Double totalPurchase;
				productName = sale.getProductName();
				totalPurchase = sale.getTotalPurchase();
				if(productName == null){
					productName = " ";
				}
				if(totalPurchase == 0){
					totalPurchase = (double) 0;
				}
				System.out.format("%-20s %60s \n",productName,totalPurchase);
				System.out.println();
				}
		}


		//main method
		public static void main(String[] args) {
			try{
				//calling displayRowsPerPage for procedure execution and display of returned data
				DataDisplayer.displayRowsPerPage("1996","Seafood");
			}
			catch(Exception e){
				System.out.println(" ");
				DataDisplayer.displayRowsPerPage("1996","Produce");
			}
		}
	}
