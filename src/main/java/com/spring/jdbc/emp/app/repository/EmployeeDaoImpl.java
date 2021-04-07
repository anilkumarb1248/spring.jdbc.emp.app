package com.spring.jdbc.emp.app.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.jdbc.emp.app.model.Employee;
import com.spring.jdbc.emp.app.service.EmployeeRowMapper;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * @Override public Employee getEmployee(Long id) {
	 * 
	 *           String query = " select id,name,salary,role,email from employee
	 *           where id = ?"; return jdbcTemplate.queryForObject(query, new
	 *           Object[] { id }, new RowMapper<Employee>() {
	 * 
	 * @Override public Employee mapRow(ResultSet rs, int rowNum) throws
	 *           SQLException { Employee employee = new Employee();
	 *           employee.setId(rs.getLong("id"));
	 *           employee.setName(rs.getString("name"));
	 *           employee.setSalary(rs.getLong("salary"));
	 *           employee.setRole(rs.getString("role"));
	 *           employee.setEmail(rs.getString("email"));
	 * 
	 *           return employee; }
	 * 
	 *           }); }
	 */

	@Override
	public Employee getEmployee(Long id) {

		String query = " select id,name,salary,role,email from employee where id = ?";
		return jdbcTemplate.queryForObject(query, new Object[] { id }, new EmployeeRowMapper());
	}

	/**
	 * @Override public List<Employee> getAll() {
	 * 
	 *           String query = " select id,name,salary,role,email from employee";
	 * 
	 *           return jdbcTemplate.query(query, new RowMapper<Employee>() { public
	 *           Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
	 *           Employee employee = new Employee();
	 *           employee.setId(rs.getLong("id"));
	 *           employee.setName(rs.getString("name"));
	 *           employee.setSalary(rs.getLong("salary"));
	 *           employee.setRole(rs.getString("role"));
	 *           employee.setEmail(rs.getString("email")); return employee; } });
	 * 
	 *           }
	 */

	@Override
	public List<Employee> getAll() {
		String query = " select id,name,salary,role,email from employee";
		return jdbcTemplate.query(query, new EmployeeRowMapper());
	}

	@Override
	public boolean addEmployee(Employee employee) {
		String query = "insert into employee(id,name,salary,role,email) values(?,?,?,?,?)";
		int i = jdbcTemplate.update(query, employee.getId(), employee.getName(), employee.getSalary(),
				employee.getRole(), employee.getEmail());
		if (i >= 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean deleteEmployee(Long id) {
		String query = "delete from employee where id=" + id;
		int i = jdbcTemplate.update(query);
		if (i >= 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updateEmployee(Long id, Employee employee) {
		String query = "update employee set name=?, salary=?,role=?,email=? where id = ?";
		int i = jdbcTemplate.update(query, employee.getName(), employee.getSalary(), employee.getRole(),
				employee.getEmail(), employee.getId());
		if (i >= 1) {
			return true;
		} else {
			return false;
		}
	}
}
