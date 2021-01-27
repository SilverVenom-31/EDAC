package com.app.dao;

import static com.app.utils.DbUtils.fetchDbConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.app.pojo.Customer;

public class CustomerImpl implements ICustomerDao, AutoCloseable {

	private Connection cn;
	private PreparedStatement pst1, pst2, pst3, pst4;

	public CustomerImpl() throws SQLException, ClassNotFoundException {

		String sql1 = "select * from my_customers where email=? and password=?;";
		String sql2 = "insert into my_customers(deposit_amt,email,name,password,reg_date,role) values(?,?,?,?,?,?)";
		String sql3 = "update my_customers set password=? where email=? and password=?";
		String sql4 = "delete from my_customers where id=?";
		cn = fetchDbConnection();
		pst1 = cn.prepareStatement(sql1);
		pst2 = cn.prepareStatement(sql2);
		pst3 = cn.prepareStatement(sql3);
		pst4 = cn.prepareStatement(sql4);
	}

	@Override
	public Customer authenticatUser(String email, String password) throws SQLException {
		pst1.setString(1, email);
		pst1.setString(2, password);

		Customer c1 = null;
		try (ResultSet rst = pst1.executeQuery()) {

			if (rst.next()) {
				c1 = new Customer(rst.getInt(1), rst.getDouble(2), rst.getString(3), rst.getString(4), rst.getString(5),
						rst.getDate(6), rst.getString(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return c1;
	}

	public void cleanUp() throws SQLException {
		if (pst1 != null || pst2 != null || pst3 != null || pst4 != null) {
			pst1.close();
			pst2.close();
			pst3.close();
			pst4.close();
		}
		if (cn != null) {
			cn.close();
		}
		System.out.println("Customer DAO cleaning up resources...");

	}

	@Override
	public void close() throws Exception {
		if (pst1 != null || pst2 != null || pst3 != null || pst4 != null) {
			pst1.close();
			pst2.close();
			pst3.close();
			pst4.close();
		}
		if (cn != null) {
			cn.close();
		}
		System.out.println("Customer DAO cleaning up resources...");

	}

	@Override
	public String registerCustomer(double depositAmt, String email, String name, String password, Date date,
			String role) throws SQLException {
		pst2.setDouble(1, depositAmt);
		pst2.setString(2, email);
		pst2.setString(3, name);
		pst2.setString(4, password);
		pst2.setDate(5, date);
		pst2.setString(6, role);

		int check = pst2.executeUpdate();
		if (check > 0) {
			return "Customer registered successfully";
		} else {
			return "Customer not registered";
		}
	}

	@Override
	public String updatePassword(String email, String oldPass, String newPass) throws SQLException {

		pst3.setString(1, newPass);
		pst3.setString(2, email);
		pst3.setString(3, oldPass);
		int check = pst3.executeUpdate();
		if (check > 0) {
			return "Password updated successfully";
		} else {
			return "Password not updated";
		}
	}

	@Override
	public String unsubscribeCustomer(int id) throws SQLException {
		pst4.setInt(1, id);
		int check = pst4.executeUpdate();
		if (check > 0) {
			return "Unsubscribed Customer successfully";
		} else {
			return "Customer not unsubscribed";
		}

	}
}
