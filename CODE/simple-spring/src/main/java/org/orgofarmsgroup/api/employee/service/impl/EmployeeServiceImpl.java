package org.orgofarmsgroup.api.employee.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.orgofarmsgroup.api.employee.model.Employee;
import org.orgofarmsgroup.api.employee.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class EmployeeServiceImpl implements EmployeeService {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private final String qryGetEmployeeById = new StringBuilder("SELECT ")
														.append("EMP_ID INT,FIRST_NAME,MIDDLE_NAME,LAST_NAME, ")
														.append("MANAGER_ID,DEPT,SALARY,GENDER,DATE_OF_JOINING, ")
														.append("STATUS,LAST_MOD_USER,LAST_MOD_TIME_DATE,ADDITIONAL_INFO ").append("FROM EMPLOYEE ")
														.append("WHERE EMP_ID = ? ").toString();

	@Override
	public Employee getEmployeeById(Integer empId) {
		Employee employee = null;
		try {
			LOGGER.info("SEARCHING FOR EMPLOYEE: "+empId);
			employee = jdbcTemplate.queryForObject(qryGetEmployeeById, new BeanPropertyRowMapper<>(Employee.class), empId);
			LOGGER.info("EMPLOYEE FOUND.");
			employee.setAdditionalInfo("SUCCESS");
		}catch (EmptyResultDataAccessException e) {
			employee = new Employee();
			employee.setEmpId(empId);
			employee.setAdditionalInfo(e.getMessage());
			e.printStackTrace();
		}catch (Exception e) {
			employee = new Employee();
			employee.setEmpId(empId);
			employee.setAdditionalInfo(e.getMessage());
			e.printStackTrace();
		}
		return employee;
	}

	private final String qryGetAllEmployees = new StringBuilder("SELECT ")
														.append("EMP_ID INT,FIRST_NAME,MIDDLE_NAME,LAST_NAME, ")
														.append("MANAGER_ID,DEPT,SALARY,GENDER,DATE_OF_JOINING, ")
														.append("STATUS,LAST_MOD_USER,LAST_MOD_TIME_DATE,ADDITIONAL_INFO ")
														.append("FROM EMPLOYEE ").toString();
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> allEmployees = null;
		try {
			allEmployees = new ArrayList<Employee>();
			SqlRowSet rowSet = jdbcTemplate.queryForRowSet(qryGetAllEmployees);
			while(rowSet.next()) {
				Employee employee = new Employee();
				employee.setEmpId(rowSet.getInt(1));
				employee.setFirstName(rowSet.getString(2));
				employee.setDept(rowSet.getString("DEPT"));
				allEmployees.add(employee);
			}
		}catch (Exception e) {
			allEmployees = new ArrayList<Employee>();
			LOGGER.warn(e.getMessage());
			e.printStackTrace();
		}
		return allEmployees;
	}
}
