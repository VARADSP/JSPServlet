package com.uks.varad.jdbc.day02.assignment1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.uks.varad.jdbc.day02.assignment2.SalesByCatData;

/**
 * @author: Varad Paralikar
 * Created Date:2019/07/23
 * Assignment: Day 2 assignment1
 * Task: JDBC
 */

/*
 * Class RowsFetcher class reads from employee table and stores the employees in
 * a collection to iterate the list based on user choice.
 *
 * @author: Varad Parlikar
 * Created Date: 2019/07/23
 */
public class RowsFetcher {
	private Integer rowsPerPage = 5;
	private ArrayList<EmpData> employees = new ArrayList<>();
	private Connection connection;
	private int position;
	public static int pageNo = 1;
	private boolean isLastPage, isFirstPage;

	// parameterised constructor which sets connection and rowsPerPage
	public RowsFetcher(Integer rowsPerPage, Connection connection) {
		this.connection = connection;
		this.rowsPerPage = rowsPerPage;
	}

	// parameterised constructor which sets connection
	public RowsFetcher(Connection connection) {
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
	 * method getRowsPerPage which returns employee collection list by fetching
	 * data from employee table
	 *
	 * @String scroll which is choice for forward and previous page scrolling
	 * return type : ArrayList<EmpData>
	 */
	public ArrayList<EmpData> getRowsPerPage(String scroll) {
		try {
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet resultSet = statement.executeQuery(
					"SELECT EmployeeID, concat(FirstName,' ', LastName) as FullName,Title,concat(Address ,',',city,',' ,country) as Address,HomePhone FROM employees");

			int size = getRowCount(resultSet);
			// calculating total resultset size

			if(size == 0){
				System.out.println("Table is empty");
				System.exit(0);
			}
			// printing headers
			if (scroll.equals("P") || scroll.equals("N") || scroll.equals("F")) {
				// for formatting of the Headers
				System.out.printf("%5s %15s %30s %40s %45s \n", "Employee ID", "Name", "Title", "Address", "HomePhone");
				System.out.println(
						"==============================================================================================================================================================");
			}
			// exiting system
			if (scroll.equals("X")) {
				System.out.println("Exiting System...");
				return new ArrayList<EmpData>();
			}

			// if forward scrolling is chosen
			if (scroll.equals("N")) {


				if (position >= size) {
					// last page condition
					System.out.println("You are on last page ");
					isLastPage = true;
					isFirstPage = false;
				} else {

					isLastPage = false;
					// incrementing page position by rowsPerPage for forward
					// scrolling
					position += rowsPerPage;
					resultSet.absolute(position);
					iterate(resultSet, false);


					if (position > size) {
						System.out.println("You are on last page");
						isLastPage = true;
						isFirstPage = false;
						position -= rowsPerPage;
						resultSet.absolute(position);
						iterate(resultSet,true);
					}
					System.out.println("Page No " + (isLastPage ? pageNo : ++pageNo));
				}
				return employees;
			} else if (scroll.equals("P")) {

				if (position <= rowsPerPage) {
					// checking if user is on first page
					isFirstPage = true;
					isLastPage = false;
					position = 0;
					System.out.println("You are on first page");
					pageNo=1;
					resultSet.beforeFirst();
					iterate(resultSet, false);
				} else {
					// decrementing page position by rowsPerPage
					isFirstPage = false;
					position -= rowsPerPage;
					resultSet.absolute(position);
					iterate(resultSet, false);
				}
				System.out.println("Page No " + (isFirstPage ? pageNo : --pageNo));
				return employees;
			} else if (scroll.equals("F")) {
				// for initial condition if user is on first page
				System.out.println("Page No " + pageNo);
				resultSet.beforeFirst();
				iterate(resultSet, false);

			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	/*
	 * method iterate which iterates over the resultset and stores employee data
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
				employees.clear();
			}

			int count = 0;
			while (resultSet.next()) {
				// adding rows to employee collection list by rows per page
				employees.add(new EmpData(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getString(5)));
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