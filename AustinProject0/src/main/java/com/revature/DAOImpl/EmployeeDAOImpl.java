package com.revature.DAOImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.revature.dao.EmployeeDAO;
import com.revature.util.ConnFactory;

public class EmployeeDAOImpl implements EmployeeDAO {
	public static ConnFactory cf = ConnFactory.getInstance();
	
	@Override
	public String employeeLogin() throws SQLException {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter your employee ID: ");
		String username1 = scan.nextLine();
		System.out.println("Please enter your password: ");
		String password1 = scan.nextLine();
		String username = "austin";
		String password = "coburn";
		
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		String sql = "INSERT INTO EMPLOYEE VALUES('" + username + "', '" + password + "')";
		stmt.executeUpdate(sql);
		ResultSet rss = stmt.executeQuery("SELECT EMPLOYEE_USERNAME, EMPLOYEE_PASSWORD FROM EMPLOYEE WHERE EMPLOYEE_USERNAME = '" + username1 + "' AND EMPLOYEE_PASSWORD = '" + password1 + "'");
		
		if(rss.next() == false) {
			System.out.println("Please try to login again. Wrong credentials.");
			username1 = null;
			employeeLogin();
		} else {
			System.out.println("Successful login.");
		}
		return username1;
	}

}
