package com.app.utils;
import java.sql.*;

public interface DbUtils {
	//add a static method for getting a FIXED DB connection
		static Connection fetchDBConnection() throws ClassNotFoundException,SQLException
		{
			//load Type IV MySql supplied JDBC driver class , under method area (meta space)
			Class.forName("com.mysql.cj.jdbc.Driver"); //required in server side applications
			//get the fixed connection to DB
			String url="jdbc:mysql://localhost:3306/acts?useSSL=false";
			return DriverManager.getConnection(url, "akhil", "@Akhil123");
		}
		
	}