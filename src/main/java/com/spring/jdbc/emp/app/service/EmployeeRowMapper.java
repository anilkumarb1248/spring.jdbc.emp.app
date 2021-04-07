package com.spring.jdbc.emp.app.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.emp.app.model.Employee;

public class EmployeeRowMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee = new Employee();
		employee.setId(rs.getLong("id"));
		employee.setName(rs.getString("name"));
		employee.setSalary(rs.getLong("salary"));
		employee.setRole(rs.getString("role"));
		employee.setEmail(rs.getString("email"));
		
		return employee;
	}

}
