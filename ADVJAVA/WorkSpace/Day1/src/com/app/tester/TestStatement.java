package com.app.tester;

import static com.app.utils.DbUtils.fetchDBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestStatement {

	public static void main(String[] args) {
		String sql = "select * from my_emp";
		try (//// get fixed database connection
				Connection cn = fetchDBConnection();
				// create empty statement object, to hold a query
				Statement st = cn.createStatement();
				// execute query: public ResultSet executeQuery(String sql) throws SQ
				ResultSet rst = st.executeQuery(sql);) {
			System.out.println("Employee data");
			while (rst.next()) {
				System.out.printf("ID %d Name %s Address %s Salary %.2f Dept %s Joined on %s%n", rst.getInt(1),
						rst.getString(2), rst.getString(3), rst.getDouble(4), rst.getString(5), rst.getDate(6));
			}

			// System.out.println("connected to DB " + cn);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
