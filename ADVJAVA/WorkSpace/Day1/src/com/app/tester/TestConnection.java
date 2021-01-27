package com.app.tester;

import static com.app.utils.DbUtils.fetchDBConnection;

import java.sql.Connection;

public class TestConnection {

	public static void main(String[] args) {
		try (Connection cn = fetchDBConnection()) {
			System.out.println("connected to DB " + cn);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
