package org.orgofarmsgroup.api.employee.service;

import java.util.List;

import org.orgofarmsgroup.api.employee.model.Employee;

public interface EmployeeService {
	Employee getEmployeeById(Integer empId);
	List<Employee> getAllEmployees();
}
