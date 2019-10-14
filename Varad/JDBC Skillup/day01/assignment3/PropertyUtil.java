package com.uks.varad.jdbc.day01.assignment3;

import java.io.FileReader;
import java.util.Properties;

/**
 * @author: Varad Paralikar
 * Created Date:2019/07/22
 * Assignment: Day 1
 * Task: JDBC
 */

/*
 * Class PropertyUtil defines static string variables which are used in JDBC to
 * connect to the database. The properties are read from settings.properties
 * file
 *
 * @author: Varad Parlikar
 * Created Date: 2019/07/22
 */
public class PropertyUtil {
	public static String databaseUrl;
	public static String databaseName;
	public static String databaseUsername;
	public static String databasePassword;
	public static String databaseDriverClass;

	// constructor which sets properties of PropertyUtil class for database
	// connection
	public PropertyUtil() {
		try {
			FileReader reader = new FileReader(
					"D:\\PRTOT\\NEWWSPRTOT\\JDBC Skillup\\src\\com\\uks\\varad\\jdbc\\day01\\assignment3\\settings.properties");
			Properties properties = new Properties();
			properties.load(reader);

			databaseUrl = properties.getProperty("database.url");
			databaseName = properties.getProperty("database.name");
			databaseUsername = properties.getProperty("database.username");
			databasePassword = properties.getProperty("database.password");
			databaseDriverClass = properties.getProperty("database.driverClass");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
