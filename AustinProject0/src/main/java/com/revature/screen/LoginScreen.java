package com.revature.screen;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.DAOImpl.CustomerDAOImpl;
import com.revature.DAOImpl.EmployeeDAOImpl;

public class LoginScreen {
	CustomerDAOImpl cdi = new CustomerDAOImpl();
	EmployeeDAOImpl edi = new EmployeeDAOImpl();
	CustomerScreen cs = new CustomerScreen();
	EmployeeScreen es = new EmployeeScreen();
	
	public void mainScreen () throws SQLException {
		@SuppressWarnings("resource")
		Scanner scanny = new Scanner(System.in);
		System.out.println("Welcome to Austin's Scammy Car Dealership");
		System.out.println("===========================================");
		System.out.println("Please enter an option: ");
		System.out.println("Enter 1 for Customer login");
		System.out.println("Enter 2 for Employee login");
		int option = scanny.nextInt();
		
		switch (option) {
			case 1 :
				cs.customerMenu();
			break;
			case 2 :
				es.employeeMenu();
			break;
			default :
				System.out.println("Not a valid option moron");
			break;
		}
		
		
	}
}


