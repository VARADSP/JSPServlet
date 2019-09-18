package com.uks.varad.jdbc.day01.assignment1;

/**
 *
 */

/**
 * @author: Varad Paralikar
 * Created Date:2019/07/22
 * Assignment: Day 1
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
			// for closing the connection
			objRecordDisplay.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
