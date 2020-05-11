package com.revature.bean;

public class Car {
	private int carVin;
	private String carMake;
	private String carModel;
	private int carYear;
	private String carOwner;
	private String carStatus;
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Car(int carVin, String carMake, String carModel, int carYear, String carOwner, String carStatus) {
		super();
		this.carVin = carVin;
		this.carMake = carMake;
		this.carModel = carModel;
		this.carYear = carYear;
		this.carOwner = carOwner;
		this.carStatus = carStatus;
	}
	
	public Car(int carVin, String carMake, String carModel, int carYear, String carStatus) {
		super();
		this.carVin = carVin;
		this.carMake = carMake;
		this.carModel = carModel;
		this.carYear = carYear;
		this.carStatus = carStatus;
	}
	public Car(int carVin, String carMake, String carModel, int carYear) {
		super();
		this.carVin = carVin;
		this.carMake = carMake;
		this.carModel = carModel;
		this.carYear = carYear;
	}
	public int getCarVin() {
		return carVin;
	}
	public void setCarVin(int carVin) {
		this.carVin = carVin;
	}
	public String getCarMake() {
		return carMake;
	}
	public void setCarMake(String carMake) {
		this.carMake = carMake;
	}
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	public int getCarYear() {
		return carYear;
	}
	public void setCarYear(int carYear) {
		this.carYear = carYear;
	}
	public String getCarOwner() {
		return carOwner;
	}
	public void setCarOwner(String carOwner) {
		this.carOwner = carOwner;
	}
	public String getCarStatus() {
		return carStatus;
	}
	public void setCarStatus(String carStatus) {
		this.carStatus = carStatus;
	}
	
	@Override
	public String toString() {
		return "Car [carVin=" + carVin + ", carMake=" + carMake + ", carModel=" + carModel + ", carYear=" + carYear
				+ ", carOwner=" + carOwner + ", carStatus=" + carStatus + "]";
	}
	public String toString2() {
		return "Car [carVin=" + carVin + ", carMake=" + carMake + ", carModel=" + carModel + ", carYear=" + carYear
				+ "]";
	}

	
	
}
