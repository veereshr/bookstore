package com.ooad.bookstore.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

	private static final String DATABASE_PROPERTY_FILE = "src/main/resources/Database.properties";
	public static Connection connection = null;

	public static Connection getConnection(String databaseName) throws SQLException, FileNotFoundException {

		Properties properties = new Properties();
		FileInputStream fileInputStream = null;
		try {

			fileInputStream = new FileInputStream(DATABASE_PROPERTY_FILE);

			if (fileInputStream != null) {
				properties.load(fileInputStream);
			}

			Class.forName(properties.getProperty("DB_DRIVER"));
			connection = DriverManager.getConnection(
					properties.getProperty("DB_URL") + databaseName + properties.getProperty("DB_USESSL"),
					properties.getProperty("DB_USERNAME"), properties.getProperty("DB_PASSWORD"));
		} catch (ClassNotFoundException ex) {
			System.err.println(ex);
		} catch (IOException ex) {
			System.err.println(ex);
		}
		return connection;
	}

}
