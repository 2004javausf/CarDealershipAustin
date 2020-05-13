package com.revature.DAOImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.bean.Customer;
import com.revature.dao.CustomerDAO;
import com.revature.util.ConnFactory;

public class CustomerDAOImpl implements CustomerDAO {
	
	public static ConnFactory cf = ConnFactory.getInstance();
	
	
	
	@Override
	public void insertCustomer(String username, String password) throws SQLException {
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		String sql = "INSERT INTO CUSTOMER VALUES('" + username + "', '" + password + "')";
		stmt.executeUpdate(sql);	
	}

	@Override
	public List<Customer> getCustomerList() throws SQLException {
		Connection conn = cf.getConnection();
		List<Customer> customerList = new ArrayList<Customer>();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM CUSTOMER");
		Customer c = null;
		while(rs.next()) {
			c =  new Customer(rs.getString(1), rs.getString(2));
			customerList.add(c);
			String ccc = c.toString();
			System.out.println(ccc);
		}
		return customerList;
	}

	@Override
	public void newAccount() throws SQLException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a username: ");
		String username = sc.nextLine();
		System.out.println("Please enter a password: ");
		String password = sc.nextLine();
		
		insertCustomer(username, password);
		
	}

	@Override
	public String customerLogin() throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter your login username: ");
		String username = sc.nextLine();
		System.out.println("Please enter your password: ");
		String password = sc.nextLine();
		
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT CUSTOMER_USERNAME, CUSTOMER_PASSWORD FROM CUSTOMER WHERE CUSTOMER_USERNAME = '" + username + "' AND CUSTOMER_PASSWORD = '" + password + "'");
		
		if(rs.next() == false) {
			System.out.println("Please try again");
			username = null;
			customerLogin();
		} else {
			System.out.println("You have successfully logged in!");
		}
		return username;
	}

}
