package com.uks.varad.jdbc.day01.assignment2;

import java.util.Scanner;

/**
 *
 */

/**
 * @author: Varad Paralikar
 * Created Date:2019/07/22 Assignment: Day 1
 * Task: JDBC
 */

/*
 * Class DisplayRecords uses object of RecordDisplay class to display records
 * from database by using JDBC
 *
 * @author: Varad Parlikar
 * Created Date: 2019/07/22
 */
public class DisplayRecords {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			// creating an object and passing user name and password
			RecordDisplay objRecordDisplay = new RecordDisplay();
			objRecordDisplay.connect("varad", "varad@654");
			// passing query to the method
			objRecordDisplay.displayRecords(
					"SELECT EmployeeID, concat(FirstName,' ', LastName) as FullName,Title,concat(Address ,',',city,',' ,country) as Address,HomePhone FROM employees");

			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter Employee ID");
			String employeeId = scanner.nextLine();

			if (employeeId.isEmpty()) {
				// passing query to the method
				objRecordDisplay.displayRecords(
						"SELECT EmployeeID, concat(FirstName,' ', LastName) as FullName,Title,concat(Address ,',',city,',' ,country) as Address,HomePhone FROM employees");
				System.out.println("Enter was pressed");
			} else {
				// passing query to the method
				objRecordDisplay.displayRecords(
						"SELECT EmployeeID, concat(FirstName,' ', LastName) as FullName,Title,concat(Address ,',',city,',' ,country) as Address,HomePhone FROM employees",
						employeeId);
			}
			// closing scanner object
			scanner.close();
			// for closing the connection
			objRecordDisplay.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
