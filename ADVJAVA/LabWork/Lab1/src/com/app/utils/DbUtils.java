package com.app.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface DbUtils {

	static Connection fetchDbConnection() throws ClassNotFoundException, SQLException {
		// load Type IV MySql supplied JDBC driver class , under method area (meta
		// space)
		Class.forName("com.mysql.cj.jdbc.Driver");
		// get the fixed connection to DB
		String url = "jdbc:mysql://localhost:3306/acts?useSSL=false";
		return DriverManager.getConnection(url, "akhil", "@Akhil123");

	}

}
