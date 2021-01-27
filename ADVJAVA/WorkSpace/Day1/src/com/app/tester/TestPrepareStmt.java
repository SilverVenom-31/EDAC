package com.app.tester;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import static com.app.utils.DbUtils.fetchDBConnection;

public class TestPrepareStmt {

	public static void main(String[] args) {
		String sql = "select empid,name,salary,join_date from my_emp where deptid=? and join_date between ? and ?";
		try (// get connection to DB
				Connection cn = fetchDBConnection();
				// input from user
				Scanner sc = new Scanner(System.in);
				// create pre-parsed and pre-compiled stmt
				PreparedStatement pst = cn.prepareStatement(sql);

		) {
			System.out.println("Enter deptID, start, end join date(yr-mn-day),quit to exit");

			while (true) {
				String deptId = sc.next();
				if (deptId.equalsIgnoreCase("quit"))
					break;

				// Set in parameters : dept , strt, end

				pst.setString(1, deptId); // deptId
				pst.setDate(2, Date.valueOf(sc.next())); // strt date
				pst.setDate(3, Date.valueOf(sc.next())); // end date

				// execution: executeQuery()

				try (ResultSet rst = pst.executeQuery()) {

					while (rst.next()) {
						System.out.printf("ID %d Name %s Salary %.1f Joined on %s%n", rst.getInt(1), rst.getString(2),
								rst.getDouble(3), rst.getDate(4));
					}
					

				} catch (Exception e) {
					e.printStackTrace();
				}

			}

			// System.out.println(cn);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
