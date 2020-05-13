package com.revature.screen;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.DAOImpl.CarDAOImpl;
import com.revature.DAOImpl.CustomerDAOImpl;
import com.revature.DAOImpl.OfferDAOImpl;

public class CustomerScreen {
	CustomerDAOImpl cdi = new CustomerDAOImpl();
	CarDAOImpl cadi = new CarDAOImpl();
	OfferDAOImpl odi = new OfferDAOImpl();
	static String username = "";
	boolean quit = false;
	
public void customerMenu() throws SQLException {
	@SuppressWarnings("resource")
	Scanner thescan = new Scanner(System.in);
	System.out.println("To login enter 'login'. To register enter 'register'");
	String answer = thescan.nextLine();
	
	switch (answer) {
		case "register" :
		try {
		cdi.newAccount();
		} catch (SQLException e) {
			System.out.println("Account already exists");
			System.exit(0);
		}
		break;
		case "login" :
		try {
		username = cdi.customerLogin();
		} catch (SQLException e) {
			e.printStackTrace();
		} break;
		default :
			System.out.println("Invalid");
			customerMenu();
			break;
			} 
do {
	@SuppressWarnings("resource")
	Scanner scan = new Scanner(System.in);
	System.out.println("Please select an option:");
	System.out.println("1: View cars on lot");
	System.out.println("2: Make offer on car");
	System.out.println("3: View my cars");
	System.out.println("4: View my offers and car payment info");
	System.out.println("5: Make car payment");
	System.out.println("6: Exit");
	int option = scan.nextInt();
	
	switch (option) {
	case 1:
		try { 
			cadi.getCars();
		} catch (SQLException e) {
			e.printStackTrace();
		} break;
	case 2:
		int carVin;
		double offerAmount;
		Scanner scanint = new Scanner(System.in);
		Scanner scandub = new Scanner(System.in);
		System.out.println("Please enter the car's VIN you would like to make an offer on");
		carVin = scanint.nextInt();
		System.out.println("Please enter the amount you would like to offer");
		offerAmount = scandub.nextDouble();
		System.out.println("Please enter your username to confirm");
		username = thescan.nextLine();
		try { odi.createOffer(username, carVin, offerAmount);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Invalid input");
		} break;
	case 3:
		try {
		cadi.getMyCars(username);
	} catch (SQLException e) {
		e.printStackTrace();
	} break;
	case 4:
		try {
			odi.viewOffers(username);
	}	catch (SQLException e) {
			e.printStackTrace();
	} break;
	case 5:
//		Scanner sci = new Scanner(System.in);
//		System.out.println("What is the VIN of the car you're making the payment for");
//		carVin = sci.nextInt();
//	try {
////	odi.makePayment(username, carVin);
////	} catch (SQLException e) {
////	System.out.println("Invalid");} 
//		break;
	case 6:
		quit = true;
		break;
	default :
		System.out.println("Invalid input");
		break;
		} 
	} while(!quit);
	System.out.println("Thanks!");
	System.exit(0);	
	}	
	
}

