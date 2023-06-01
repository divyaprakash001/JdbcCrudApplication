package com.divya.utilities;

import java.sql.Connection;
import java.util.*;
import java.io.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtill {

	private JdbcUtill() {

	}

	public static Connection getJdbcConnection() throws IOException {
		Connection connection = null;

		Properties p = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\DIVYAPRAKASH\\java 28 may eclipse\\JdbcRevision28May\\src\\jdbc.properties");
		p.load(fis);

		String url = p.getProperty("url");
		String user = p.getProperty("user");
		String password = p.getProperty("password");

		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (connection != null) {
			return connection;
		}
		return connection;
	}

	public static void closeConnection(ResultSet resultSet, Statement statement, Connection connection) {

		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
