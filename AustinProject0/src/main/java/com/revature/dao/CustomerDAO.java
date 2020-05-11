package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.bean.Customer;

public interface CustomerDAO {
	public void insertCustomer(String username, String password) throws SQLException;
	
	public List<Customer> getCustomerList() throws SQLException;
	
	public void newAccount() throws SQLException;
	
	public void customerLogin() throws SQLException;

}
