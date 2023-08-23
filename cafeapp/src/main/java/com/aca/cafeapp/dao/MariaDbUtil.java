package com.aca.cafeapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDbUtil {

	private static String connectionUrl = 
			"jdbc:mariadb://localhost:3306/cafeitems?user=root&password=buizel418";
	
	static Connection getConnection() {
		Connection connection = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			connection = DriverManager.getConnection(connectionUrl);
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
	
// - This was to test if the connection was successful	
//	public static void main(String[] args) {
//		Connection connection = MariaDbUtil.getConnection();
//		if (null != connection) {
//			System.out.println("you have a connection");
//		} else {
//			System.out.println("connection is null...");
//		}
//
//	}

}
