/**
 *
 */
package com.uks.varad.struts.commons.utils;

import java.util.ResourceBundle;

/**
 * @author Varad Paralikar
 *
 */
public class Constants {

	//Static final String variables
	public static final String DB_DriverName = "DBname";
	public static final String DB_URL="URL";
	public static final String DB_username  = "Username" ;
	public static final String DB_password = "Password";


	public static String db_URL,db_username,db_password,db_driver;

	public static void getPropertyValue() {

		// Passing the property file location
		ResourceBundle myBundle = ResourceBundle.getBundle("com.uks.varad.struts.commons.utils.database");
		db_URL = myBundle.getString(Constants.DB_URL);
		db_driver = myBundle.getString(Constants.DB_DriverName);
		db_username = myBundle.getString(Constants.DB_username);
		db_password = myBundle.getString(Constants.DB_password);
	}



}
