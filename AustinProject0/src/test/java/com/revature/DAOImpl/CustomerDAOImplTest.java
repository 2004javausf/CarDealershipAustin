package com.revature.DAOImpl;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class CustomerDAOImplTest {

	
	@Test
	void getCustomerCarsTest() {
		CarDAOImpl cardi = new CarDAOImpl(); 
			try {
				String st = cardi.getCars();
				Assert.assertTrue(st != null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

}
