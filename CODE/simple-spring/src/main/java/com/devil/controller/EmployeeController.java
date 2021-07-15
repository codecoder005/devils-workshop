package com.devil.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devil.model.Employee;

@RestController
@CrossOrigin
@RequestMapping("/employee")
public class EmployeeController {
	private final static Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping
	public String employee() {
		return "I AM AN EMPLOYEE!";
	}

	@GetMapping("/{empId}")
	public Employee getEmployeeById(@PathVariable Integer empId) {
		Employee employee = null;
		try {
			final String sqlQuery = "SELECT * FROM employee WHERE EMP_ID = ?";
			employee = jdbcTemplate.queryForObject(sqlQuery, 
							new BeanPropertyRowMapper<>(Employee.class), 
							empId);
			employee.setAdditionalInfo("WE FOUND AN EMPLOYEE WITH ID: "+empId);
		}catch (Exception e) {
			LOGGER.error("NO EMPLOYEE FOUND WITH ID: "+empId);
			employee = new Employee();
			employee.setEmpId(empId);
			employee.setAdditionalInfo("INVALID EMPLOYEE ID!");
		}
		return employee;
	}
}
