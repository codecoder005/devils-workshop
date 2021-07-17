package org.orgofarmsgroup.api.employee;

import java.util.List;

import org.orgofarmsgroup.api.employee.model.Employee;
import org.orgofarmsgroup.api.employee.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/employee")
public class EmployeeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/get")
	public Employee getEmployeeById(@RequestParam Integer empId) {
		Employee employee = null;
		try {
			employee = employeeService.getEmployeeById(empId);
		}catch (Exception e) {
			LOGGER.warn(e.getMessage());
			e.printStackTrace();
		}
		return employee;
	}
	@GetMapping("/get/all")
	public List<Employee> getAllEmployees() {
		try {
			LOGGER.info("FETCHING ALL EMPLOYEES...");
			return employeeService.getAllEmployees();
		}catch (Exception e) {
			LOGGER.warn(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
}
