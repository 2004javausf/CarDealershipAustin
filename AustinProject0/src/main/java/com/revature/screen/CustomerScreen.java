package com.revature.screen;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.DAOImpl.CarDAOImpl;

public class CustomerScreen {
	CarDAOImpl cadi = new CarDAOImpl();
	
public void customerMenu() throws SQLException {
	Scanner scan = new Scanner(System.in);
	System.out.println("Please select an option:");
	System.out.println("1: View cars on lot");
	System.out.println("2: Make offer on car");
	System.out.println("3: View cars on lot");
	System.out.println("4: View my cars");
	System.out.println("5: View my offers and car payment info");
	System.out.println("6: Make car payment");
	System.out.println("0: Exit");
	int option = scan.nextInt();
	
	switch (option) {
	case 1:
		cadi.getCars();
		customerMenu();
		break;
	}
	
	
	
	
}
}
