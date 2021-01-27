
package com.app.tester;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.app.dao.EmployeeDaoImpl;

import static com.app.utils.DbUtils.fetchDBConnection;

public class TestJDBLayer {

	public static void main(String[] args) {

		try (
				// input from user
				Scanner sc = new Scanner(System.in);) {
			// create DAO instance
			EmployeeDaoImpl dao = new EmployeeDaoImpl();

			System.out.println("Enter dept, start, end join date(yr-mn-day),quit to exit");

			while (true) {
				String dept = sc.next();
				if (dept.equalsIgnoreCase("quit"))
					break;

				dao.getAllEmpDets(dept, Date.valueOf(sc.next()), Date.valueOf(sc.next()))
						.forEach(System.out::println);
//clean up db resources
				dao.cleanUp();
			}

			// System.out.println(cn);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
