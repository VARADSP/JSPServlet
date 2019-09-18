package com.uks.varad.jdbc.day04.assignment2;

/**
 * @author: 	Varad Paralikar
 * Created Date:2019/07/29
 * Assignment:  Day 4 assignment 2
 * Task:  	Printing meta data of table
 *
 */


/*
 * Class MetaDataMain which is used to call MetaData object and print the respective meta data.
 * @author: Varad Parlikar
 *  Created Date: 2019/07/29
 */
public class MetaDataMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MetaData objectMetaData=new MetaData();
		try {
			objectMetaData.connect();
			objectMetaData.getMetadata("select * from shippers");
			objectMetaData.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
