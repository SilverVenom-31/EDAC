package com.app.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface DbUtils {

	static Connection fetchDbConnection(String driveClass, String url, String userName, String password)
			throws ClassNotFoundException, SQLException {
		// load Type IV JDBC driver
		Class.forName(driveClass);

		return DriverManager.getConnection(url, userName, password);

	}

}
