package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionUtil {

	// Define the database properties
	private static final String URL = "jdbc:mysql://localhost:3306/communication";
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String PASSWORD = "MySuperPassword";
	private static final String USERNAME = "root";
	private static Connection connection = null;

	public static Connection openConnection() {
		// Check the connection
		if (connection != null) {
			return connection;
		} else {
			try {
				// Load the driver
				Class.forName(DRIVER);

				// Get the connection
				connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			} catch (Exception e) {
				e.printStackTrace();
			}

			return connection;
		}
	}

}
