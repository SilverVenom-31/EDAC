//Created by @AkhilD on 28/01/2021.
package com.app.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface DbUtils {

	static Connection fetchDbConnection() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		// get the fixed connection to DB
		String url = "jdbc:mysql://localhost:3306/acts?useSSL=false&allowPublicKeyRetrieval=true";
		return DriverManager.getConnection(url, "akhil", "Akhil123");

	}

}
