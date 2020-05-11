package com.revature.bean;

public class Offer {
	private int offerId;
	private String username;
	private int carVin;
	private double monthlyPmt;
	private double offerAmount;
	private int paymentsLeft;
	private String offerStatus;
	
	public Offer() {
		super();
	}
	
	public Offer(int offerId, String username, int carVin, double monthlyPmt, double offerAmount, int paymentsLeft,
			String offerStatus) {
		super();
		this.offerId = offerId;
		this.username = username;
		this.carVin = carVin;
		this.monthlyPmt = monthlyPmt;
		this.offerAmount = offerAmount;
		this.paymentsLeft = paymentsLeft;
		this.offerStatus = offerStatus;
	}
	
	
	
	public Offer(int offerId, String username, int carVin, double monthlyPmt, double offerAmount, int paymentsLeft) {
		super();
		this.offerId = offerId;
		this.username = username;
		this.carVin = carVin;
		this.monthlyPmt = monthlyPmt;
		this.offerAmount = offerAmount;
		this.paymentsLeft = paymentsLeft;
	}

	public int getOfferId() {
		return offerId;
	}
	
	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public int getCarVin() {
		return carVin;
	}
	
	public void setCarVin(int carVin) {
		this.carVin = carVin;
	}
	
	public double getMonthlyPmt() {
		return monthlyPmt;
	}
	
	public void setMonthlyPmt(double monthlyPmt) {
		this.monthlyPmt = monthlyPmt;
	}
	
	public double getOfferAmount() {
		return offerAmount;
	}
	
	public void setOfferAmount(double offerAmount) {
		this.offerAmount = offerAmount;
	}
	
	public int getPaymentsLeft() {
		return paymentsLeft;
	}
	
	public void setPaymentsLeft(int paymentsLeft) {
		this.paymentsLeft = paymentsLeft;
	}
	
	public String getOfferStatus() {
		return offerStatus;
	}
	
	public void setOfferStatus(String offerStatus) {
		this.offerStatus = offerStatus;
	}
	
	@Override
	public String toString() {
		return "Offer [offerId=" + offerId + ", username=" + username + ", carVin=" + carVin + ", monthlyPmt="
				+ monthlyPmt + ", offerAmount=" + offerAmount + ", paymentsLeft=" + paymentsLeft + ", offerStatus="
				+ offerStatus + "]";
	} 
}
