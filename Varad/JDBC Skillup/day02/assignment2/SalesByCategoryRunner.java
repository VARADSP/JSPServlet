package com.uks.varad.jdbc.day02.assignment2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.CallableStatement;

import com.uks.varad.jdbc.day02.assignment1.EmpData;
import com.uks.varad.jdbc.day02.assignment2.SalesByCatData;


/**
 * @author: Varad Paralikar
 * Created Date:2019/07/24
 * Assignment: Day 2 assignment2
 * Task: JDBC
 */

/*
 * Class SalesByCategoryRunner class reads from table returned by procedure execution and stores the data in
 * a collection to iterate the list based on user choice.
 * @author: Varad Parlikar
 * Created Date: 2019/07/24
 */
public class SalesByCategoryRunner {
	private Integer rowsPerPage = 5;

	private ArrayList<SalesByCatData> sales = new ArrayList<>();
	private Connection connection;
	private int position;
	private static int pageNo = 1;
	private boolean isLastPage, isFirstPage;

	// parameterised constructor which sets connection and rowsPerPage
	public SalesByCategoryRunner(Integer rowsPerPage, Connection connection) {
		this.connection = connection;
		this.rowsPerPage = rowsPerPage;
	}

	// parameterised constructor which sets connection
	public SalesByCategoryRunner(Connection connection) {
		this.connection = connection;
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
	 * method fetchRecords which returns sales collection list by fetching
	 * data from table returned by procedure execution
	 * @String scroll which is choice for forward and previous page scrolling
	 * @String orderYear which is orderYear to be passed to the procedure execution
	 * @String categoryName which is cateogoryName to be passed to the procedure execution
	 * return type : ArrayList<SalesByCatData>
	 */
	public ArrayList<SalesByCatData> fetchRecords(String scroll,String orderYear,String categoryName){
		try {
				// query for calling procedure SalesByCategory
				String query = "{ CALL SalesByCategory(?,?) }";
		        ResultSet resultSet;

		        CallableStatement callableStatement = connection.prepareCall(query);



		        //setting procedure IN variables
		        callableStatement.setString(1, orderYear);
		        callableStatement.setString(2, categoryName);
		        //getting result set returned from procedure execution
		        resultSet = callableStatement.executeQuery();

			int size = getRowCount(resultSet);

			if(size==0){
				System.out.println("Table is empty");
				System.exit(0);
			}
			// printing headers
			if (scroll.equals("P") || scroll.equals("N") || scroll.equals("F")) {
				// for formatting of the Headers
				System.out.printf("%5s %75s \n", "ProductName", "TotalPurchase");
				System.out.println(
						"==============================================================================================================================================================");
			}
			// exiting system
			if (scroll.equals("X")) {
				System.out.println("Exiting System...");
				return new ArrayList<SalesByCatData>();
			}

			// if forward scrolling is chosen
			if (scroll.equals("N")) {
				System.out.println("Page No " + (isLastPage ? pageNo : ++pageNo));
				if (position >= size) {
					// last page condition
					System.out.println("You are on last page");
					isLastPage = true;
					isFirstPage = false;
				} else {
					isLastPage = false;
					resultSet.absolute(position);
					iterate(resultSet, false);
					// incrementing page position by rowsPerPage for forward
					// scrolling
					position += rowsPerPage;

					if (position > size) {
						System.out.println("You are on last page");
						isLastPage = true;
						isFirstPage = false;
						position -= rowsPerPage;
					}
				}
				return sales;
			} else if (scroll.equals("P")) {
				System.out.println("Page No " + (isFirstPage ? pageNo : --pageNo));

				if (position <= rowsPerPage) {
					// checking if user is on first page
					isFirstPage = true;
					isLastPage = false;
					System.out.println("You are on first page");
					resultSet.beforeFirst();
					iterate(resultSet, false);
				} else {
					// decrementing page position by rowsPerPage
					isFirstPage = false;
					position -= rowsPerPage;
					resultSet.absolute(position);
					iterate(resultSet, false);
				}
				return sales;
			} else if (scroll.equals("F")) {
				// for initial condition if user is on first page
				isFirstPage = true;
				System.out.println("Page No " + pageNo);
				resultSet.beforeFirst();
				iterate(resultSet, false);
				position += rowsPerPage;
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sales;
	}

	/*
	 * method iterate which iterates over the resultset and stores table data returned from procedure execution
	 * in collection list.
	 *
	 * @ResultSet which is the resultset to be passed
	 *
	 * @isLastPage which detects if its a last page
	 * return type : void
	 */
	public void iterate(ResultSet resultSet, Boolean isLastPage) {
		try {
			if (isLastPage == false) {
				sales.clear();
			}

			int count = 0;
			while (resultSet.next()) {
				// adding rows to sales collection list by rows per page
				sales.add(new SalesByCatData(resultSet.getString(1),resultSet.getString(2)));
				++count;
				if (count == rowsPerPage) {
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}