package com.revature.dao;

import java.sql.SQLException;

public interface OfferDAO {
	public void createOffer(String username, int carVin, double offerAmount) throws SQLException;
	
	public void acceptDenyOffer(String username, int carVin) throws SQLException;
	
	public void viewOffers(String username) throws SQLException;
	
	public void makePayment(String username, int carVin) throws SQLException;
	
	public void viewAllOffers() throws SQLException;
}
