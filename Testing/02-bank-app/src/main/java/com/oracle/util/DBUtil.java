package com.oracle.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "your_user";
	private static final String PASSWORD = "your_password";

	public static Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}