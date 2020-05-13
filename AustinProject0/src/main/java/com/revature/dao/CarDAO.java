package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.bean.Car;

public interface CarDAO {

	//create
	public void insertCar() throws SQLException;
	
	//Customers list of available cars
	public String getCars() throws SQLException;
	
	//Employee's list of all cars
	public List<Car> getAllCars() throws SQLException;
	
	public void getMyCars(String username) throws SQLException;
}
