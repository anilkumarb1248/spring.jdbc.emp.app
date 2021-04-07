package com.spring.jdbc.emp.app.repository;

import java.util.List;

import com.spring.jdbc.emp.app.model.Employee;

public interface EmployeeDao {

	public Employee getEmployee(Long id);

	public List<Employee> getAll();

	public boolean addEmployee(Employee employee);

	public boolean deleteEmployee(Long id);

	public boolean updateEmployee(Long id, Employee employee);

}
