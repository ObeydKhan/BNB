package com.cbt.Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {
	
//	public static void main(String[] args) {
//		createConnection();
//		String query= "select * from users where team_id=38;";
//		System.out.println(getColumnData(query, "firstname"));
//		
//		destroy();
//	}

	private static Connection connection;
	private static Statement statement;
	private static ResultSet resultSet;

	public static void createConnection() {
		String url = ConfigurationReader.getProperty("qa3_db_host");
		String user = ConfigurationReader.getProperty("qa3_db_username");
		String password = ConfigurationReader.getProperty("qa3_db_password");

		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void destroy() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
