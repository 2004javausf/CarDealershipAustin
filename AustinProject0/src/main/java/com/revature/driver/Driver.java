package com.revature.driver;

import java.sql.SQLException;

//import com.revature.DAOImpl.CustomerDAOImpl;
import com.revature.screen.LoginScreen;
import com.revature.util.ConnFactory;

public class Driver {
	
	
	public static void main(String[] args) throws SQLException {
		
		ConnFactory cf = ConnFactory.getInstance();
		cf.getConnection();
		
		LoginScreen ls = new LoginScreen();
		ls.mainScreen();
		
		System.exit(0);
	}
}
