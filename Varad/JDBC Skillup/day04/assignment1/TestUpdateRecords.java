package com.uks.varad.jdbc.day04.assignment1;

/**
 * @author: 	Varad Paralikar
 * Created Date:2019/07/29
 * Assignment:  Day 4 assignment 1
 * Task:  	Updating records into table
 *
 */

/*
 * Class TestUpdateRecords creates object of UpdateRecords to update records of
 * table which is passed as command from the object constructor invocation.
 * @author: Varad Parlikar
 *  Created Date: 2019/07/29
 */
public class TestUpdateRecords {
	//main method
	public static void main(String[] args) {
		//calling InsertRecords class object method  to insert records into table employee
		new UpdateRecords().updateRecords("SELECT * from shippers");
	}

}
