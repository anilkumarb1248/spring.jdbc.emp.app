package com.spring.jdbc.emp.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.jdbc.emp.app.model.Employee;
import com.spring.jdbc.emp.app.repository.EmployeeDao;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	@Override
	public Employee getEmployee(Long id) {
		return employeeDao.getEmployee(id);
	}

	@Override
	public List<Employee> getAll() {
		return employeeDao.getAll();
	}

	@Override
	public boolean addEmployee(Employee employee) {
		return employeeDao.addEmployee(employee);
	}

	@Override
	public boolean deleteEmployee(Long id) {
		return employeeDao.deleteEmployee(id);
	}

	@Override
	public boolean updateEmployee(Long id, Employee employee) {
		return employeeDao.updateEmployee(id, employee);
	}
}
