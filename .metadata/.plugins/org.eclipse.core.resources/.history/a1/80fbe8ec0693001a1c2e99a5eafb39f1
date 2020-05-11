package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnFactory {

	
	//Singleton Factory
	
	//private static instance of itself
	private static ConnFactory cf = new ConnFactory();
	
	//private no args constructor
	private ConnFactory() { 	
	}

	//public static synchronized "getter" method
	public static synchronized ConnFactory getInstance() {
		if (cf == null) {
			cf = new ConnFactory();
		}
		return cf;
	}

	//Let's get a connection to the database
	public Connection getConnection() {
		String url = "jdbc:oracle:thin:@cardealership.c3ifxokhfy35.us-east-2.rds.amazonaws.com:1521:ORCL";
		String user = "austincoburn2";
		String password = "Atc94330";
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
