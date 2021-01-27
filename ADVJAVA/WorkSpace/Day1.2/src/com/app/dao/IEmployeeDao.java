package com.app.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.app.pojos.Employee;

public interface IEmployeeDao {
//add a method declaration for fetching employee details as per some criteria (where clause)
	List<Employee> getAllEmpDets(String deptId, Date strtDate, Date endDate ) throws SQLException;
	
	
}
