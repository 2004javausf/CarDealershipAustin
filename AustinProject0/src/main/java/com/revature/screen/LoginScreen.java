package com.revature.screen;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.DAOImpl.CustomerDAOImpl;

public class LoginScreen {
	CustomerDAOImpl cdi = new CustomerDAOImpl();
	
	public void mainScreen () throws SQLException {
		Scanner scanny = new Scanner(System.in);
		System.out.println("Welcome to Austin's Scammy Car Dealership");
		System.out.println("===========================================");
		System.out.println("Please enter an option: ");
		System.out.println("Enter 1 for Customer login");
		System.out.println("Enter 2 for Employee login");
		System.out.println("Enter 3 to register for an account");
		int option = scanny.nextInt();
		
		switch (option) {
			case 1 :
				CustomerScreen.loginUser();
			break;
			case 2 :
				EmployeeScreen.employeeLogin();
			break;
			case 3 :
				cdi.newAccount();
			break;
			default :
				System.out.println("Not a valid option moron");
		}
		
		
	}
}

