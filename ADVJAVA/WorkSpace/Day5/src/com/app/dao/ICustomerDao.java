package com.app.dao;

import java.sql.Date;
import java.sql.SQLException;

import com.app.pojo.Customer;

public interface ICustomerDao {
//authenticating user input and if input is valid than displaying the data of customer
	Customer authenticatUser(String email,String password  ) throws SQLException;
	String registerCustomer(double depositAmt,String email,String name, String password, Date date,String role ) throws SQLException;
	String updatePassword(String email,String oldPass,String newPass ) throws SQLException;
	String unsubscribeCustomer(int id) throws SQLException;
}


/*

	private double depositAmt;
	private String email;
	private String name;
	private String password;
	private Date date;
	private String role;

*/