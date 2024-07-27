package com.javaweb.utils;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.cj.jdbc.Driver;

public class ConnectionJDBCUtil {
	static final String DB_URL = "jdbc:mysql://localhost:3306/estateadvance";
	static final String USER = "root";
	static final String PASS = "12345";
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(DB_URL , USER , PASS);
			return conn;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
