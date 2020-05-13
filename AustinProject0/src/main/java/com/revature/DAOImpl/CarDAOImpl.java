package com.revature.DAOImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.bean.Car;
import com.revature.dao.CarDAO;
import com.revature.util.ConnFactory;

public class CarDAOImpl implements CarDAO {
	ConnFactory cf = ConnFactory.getInstance();
	@Override
	public void insertCar() throws SQLException {
		String owner = null;
		Scanner scan1 = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		System.out.println("Enter the make");
		String make = scan1.nextLine();
		System.out.println("Enter the model");
		String model = scan1.nextLine();
		System.out.println("Enter the year");
		int year = scan2.nextInt();
		
				
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		String sql = "INSERT INTO CAR VALUES(MYSEQ2.NEXTVAL" + ",'" + make + "','" + model + "','" + year + "','" + owner + "', 'Available')";
		stmt.executeUpdate(sql);
	}

	//returns all available cars for the customer
	@Override
	public String getCars() throws SQLException {
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT CAR_VIN, CAR_MAKE, CAR_MODEL, CAR_YEAR FROM CAR WHERE CAR_STATUS = 'Available'");
		Car c = null;
		String theCars = "";
		while(rs.next()) {
			c = new Car(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			theCars = c.toString2();
			System.out.println(theCars);
		}
		return theCars;
	}

	//returns the list of cars for employee
	@Override
	public List<Car> getAllCars() throws SQLException {
		List<Car> carList = new ArrayList<Car>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM CAR");
		Car c = null;
		while(rs.next()) {
			c = new Car(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6));
			carList.add(c);
			String theCars = c.toString();
			System.out.println(theCars);
		}
		return carList;
	}

	//returns the cars that the customer owns
	@Override
	public void getMyCars(String username) throws SQLException {
		System.out.println(username);
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT CAR_VIN, CAR_MAKE, CAR_MODEL, CAR_YEAR FROM CAR WHERE CAR_OWNER = '" + username +"'" );
		Car c = null;
		String carList = "";
		while(rs.next()) {
			c = new Car(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			carList = c.toString2();
			System.out.println(carList);
		}
	}

}
