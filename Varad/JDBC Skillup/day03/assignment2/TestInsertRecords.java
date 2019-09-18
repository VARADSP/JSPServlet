package com.uks.varad.jdbc.day03.assignment2;

/**
 * @author: 	Varad Paralikar
 * Created Date:2019/07/26
 * Assignment:  Day 3 assignment 2
 * Task:  	Inserting reocords into table
 *
 */

/*
 * Class TestInsertRecords creates object of InsertRecords to insert records into the
 * table which is passed as command from the object constructor invokation.
 * @author: Varad Parlikar
 *  Created Date: 2019/07/26
 */
public class TestInsertRecords {
	//main method
	public static void main(String[] args) {
		//calling InsertRecords class object method  to insert records into table employee
		new InsertRecords().insertRecords("SELECT * from shippers");
	}

}
