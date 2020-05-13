package com.revature.screen;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.DAOImpl.CarDAOImpl;

public class EmployeeScreen {
	CarDAOImpl cadi = new CarDAOImpl();
	
	public void employeeMenu() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter an option:");
		System.out.println("1: Show all cars");
		System.out.println("2: Add new car");
		System.out.println("3: Get all customer info");
		System.out.println("4: View all offers");
		System.out.println("5: Accept/Deny offer");
		System.out.println("0: Exit");
		int option = scan.nextInt();
		
		switch (option) {
		case 1:
			
			break;
		case 2:
			try {
				cadi.insertCar();
				employeeMenu();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case 3:
		break;
		case 4:
		break;
		case 5:
		break;
		case 6:
		break;
		}
		
	}
	
}
