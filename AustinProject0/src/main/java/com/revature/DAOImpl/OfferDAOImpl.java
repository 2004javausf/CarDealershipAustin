package com.revature.DAOImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.bean.Offer;
import com.revature.dao.OfferDAO;
import com.revature.util.ConnFactory;

public class OfferDAOImpl implements OfferDAO {
	public static ConnFactory cf = ConnFactory.getInstance();
	
	@Override
	public void createOffer(String username, int carVin, double offerAmount) throws SQLException {
		double offerMonthlyPmt = 0;
		int offerPmtsLeft = 0;
		String answer1;
		
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs;
		Scanner scanStr = new Scanner(System.in);
		System.out.println("Would you like to make an offer? ('Yes' or 'No')");
		answer1 = scanStr.nextLine();
		if (answer1.equalsIgnoreCase("Yes")) {
			rs = stmt.executeQuery("SELECT * FROM OFFER WHERE CUSTOMER_USERNAME = '" + username + "' AND CAR_VIN = " + carVin );
			rs = stmt.executeQuery("INSERT INTO OFFER VALUES(MYSEQ.NEXTVAL,'" + username + "'," + carVin + "," + offerMonthlyPmt + "," + offerAmount + "," + offerPmtsLeft + ",'NotAccepted')");
			System.out.println("Awesome! We have received your offer!");
			}
		} 

	@Override
	public void acceptDenyOffer(String username, int carVin) throws SQLException {
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM OFFER WHERE CUSTOMER_USERNAME = '" + username + "' AND CAR_VIN = " + carVin + "AND OFFER_STATUS = 'NotAccepted'");
		Scanner s = new Scanner(System.in);
		String offerInStringForm = "";
		if(rs.next() == false) {
			System.out.println("Offer not found!");
			return;
		}
		ResultSet rss = stmt.executeQuery("SELECT * FROM OFFER WHERE CUSTOMER_USERNAME = '" + username + "' AND CAR_VIN = " + carVin);
		while(rss.next()) {
			Offer offer = new Offer(rss.getInt(1), rss.getString(2), rss.getInt(3), rss.getDouble(4), rss.getDouble(5), rss.getInt(6), rss.getString(7));
			offerInStringForm = offer.toString();
			System.out.println(offerInStringForm);
		}
		System.out.println("Would you like to accept or deny the offer? ('A' for accept and 'D' for deny)");
		String answer = s.nextLine();
		if(answer.equals("A")) {
			//USING PROCEDURE TO UPDATE INFORMATION ON PURCHASE
			String sql = "{ call NEWCARACCEPTED(?,?)";
			CallableStatement callable = conn.prepareCall(sql);
			callable.setString(1, username);
			callable.setInt(2, carVin);
			callable.execute();
			System.out.println("You have successfully confirmed the offer!");
	
		} else if(answer.equals("D")) {
			rs = stmt.executeQuery("DELETE FROM OFFER WHERE CUSTOMER_USERNAME = '" + username + "' AND CAR_VIN = " + carVin);
			System.out.println("Offer successfully declined!");
		}
		
	}

	@Override
	//USING A PREPARED STATEMENT
	public void viewOffers(String username) throws SQLException {
		// TODO Auto-generated method stub
		List<Offer> offers = new ArrayList<Offer>();
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM OFFER WHERE CUSTOMER_USERNAME = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		Offer offer = null;
		while(rs.next()) {
			offer = new Offer(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getDouble(5), rs.getInt(6), rs.getString(7));
			offers.add(offer);
		}
		for(int i = 0; i < offers.size(); i++) {
			System.out.println(offers.get(i));
		}
	}

	@Override
	public void viewAllOffers() throws SQLException {
		List<Offer> offers = new ArrayList<Offer>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM OFFER");
		Offer offer = null;
		while(rs.next()) {
			offer = new Offer(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getDouble(5), rs.getInt(6), rs.getString(7));
			offers.add(offer);
		}
		for(int i = 0; i < offers.size(); i++) {
			System.out.println(offers.get(i));
		}	
	}
}
