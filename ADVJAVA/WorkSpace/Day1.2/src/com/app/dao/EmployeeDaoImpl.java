package com.app.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.pojos.Employee;
import static com.app.utils.DbUtils.fetchDBConnection;

public class EmployeeDaoImpl implements IEmployeeDao {
	// state/properties
	private Connection cn;
	private PreparedStatement pst1;

	// constructor : invoked by above layer (Tester/UI/servlet) exactly once at init
	// phase of app
	public EmployeeDaoImpl() throws ClassNotFoundException, SQLException {
		String sql = "select empid,name,salary,join_date from my_emp where deptid=? and join_date between ? and ?";
		// get db cn
		cn = fetchDBConnection();

		// pst
		pst1 = cn.prepareStatement(sql);
		System.out.println("emp dao created");
	}

	@Override
	public List<Employee> getAllEmpDets(String dept, Date strtDate, Date endDate) throws SQLException {
		List<Employee> emps = new ArrayList<>();
//set IN parameters
		pst1.setString(1, dept);
		pst1.setDate(2, strtDate);
		pst1.setDate(3, endDate);

		try (ResultSet rst = pst1.executeQuery()) {
			while (rst.next()) {
				emps.add(new Employee(rst.getInt(1), rst.getString(2), rst.getDouble(3), rst.getDate(4)));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return emps;
	}

	// invoked by tester: only once at ending phase of app
	public void cleanUp() throws SQLException {
		if (pst1 != null) {
			pst1.close();
		}
		if (cn != null) {
			cn.close();
		}
		System.out.println("emp dao cleaned up");

	}

}
