package com.spring.jdbc.emp.app.client;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.jdbc.emp.app.model.Employee;
import com.spring.jdbc.emp.app.service.EmployeeService;

@Component
public class JdbcClient {

	@Autowired
	EmployeeService employeeService;

	private Scanner scanner = null;

	public void performDBOperations() {
		int choice = 0;
		scanner = new Scanner(System.in);

		while (choice != 6) {
			System.out.println("1: Add Employee\n" + "2: Get Employee\n" + "3: Get All Employees\n"
					+ "4: Delete Employee\n" + "5: Update Employee\n" + "6: Exit");

			System.out.println("Enter your choice:\n");
			choice = scanner.nextInt();
			switch (choice) {
			case 1: {
				addEmployee();
				break;
			}
			case 2: {
				getEmployee();
				break;
			}
			case 3: {
				getAll();
				break;
			}
			case 4: {
				deleteEmployee();
				break;
			}
			case 5: {
				updateEmployee();
				break;
			}
			case 6: {
				if (scanner != null) {
					scanner.close();
					scanner = null;
				}
				System.out.println("Thank you for using the choices");
				break;

			}
			default: {
				System.out.println("Wrong Choice");
				break;
			}
			}
		}

	}

	private void addEmployee() {
		employeeService.addEmployee(getEmployeeDetailsFromUser());
		System.out.println("Employee saved successfully");
	}

	private void getEmployee() {
		System.out.println("Enter the employee id:\n");
		Long id = scanner.nextLong();
		Employee employee = employeeService.getEmployee(id);
		System.out.println(employee);
	}

	private void getAll() {
		List<Employee> employees = employeeService.getAll();
		employees.stream().forEach(emp -> System.out.println(emp));
	}

	private void deleteEmployee() {
		System.out.println("Enter the employee id to delete:\n");
		Long id = scanner.nextLong();
		boolean flag = employeeService.deleteEmployee(id);
		System.out.println("Employee is delete: " + flag);
	}

	private void updateEmployee() {
		Employee employee = getEmployeeDetailsFromUser();
		employeeService.updateEmployee(employee.getId(), employee);
		System.out.println("Employee updated successfully");
	}

	private Employee getEmployeeDetailsFromUser() {
		Employee employee = new Employee();

		System.out.println("Enter the employee id:\n");
		Long id = scanner.nextLong();

		System.out.println("Enter the employee name:\n");
		String name = scanner.next();

		System.out.println("Enter the employee salary:\n");
		Long salary = scanner.nextLong();

		System.out.println("Enter the employee role:\n");
		String role = scanner.next();

		System.out.println("Enter the employee email:\n");
		String email = scanner.next();

		employee.setId(id);
		employee.setName(name);
		employee.setSalary(salary);
		employee.setRole(role);
		employee.setEmail(email);
		return employee;
	}

	@Override
	protected void finalize() throws Throwable {
		if (scanner != null)
			scanner.close();
	}

}
