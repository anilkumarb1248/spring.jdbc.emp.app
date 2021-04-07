package com.spring.jdbc.emp.app.service;

import java.util.List;

import com.spring.jdbc.emp.app.model.Employee;

public interface EmployeeService {

	public boolean addEmployee(Employee employee);

	public List<Employee> getAll();

	public Employee getEmployee(Long id);

	public boolean deleteEmployee(Long id);

	public boolean updateEmployee(Long id, Employee employee);

}
