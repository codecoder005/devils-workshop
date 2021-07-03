package com.devil.service;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@PostConstruct
	public void postConstruct() {
		LOGGER.info("INITIATING DATABASE SETUP!");
		try {
			try {
				jdbcTemplate.execute("DROP TABLE employee");
				LOGGER.info("employee TABLE DROPED");
			}catch (Exception e) {
				LOGGER.error("ERROR OCCURRED WHILE DROPPING employee table");
				LOGGER.error(e.getMessage());
				e.printStackTrace();
			}
			String tableCreateQeury = new StringBuilder("create table employee(")
												.append("	emp_id int primary key,")
												.append("	first_name varchar(20),")
												.append("	dept varchar(10)")
												.append(")")
												.toString();
			jdbcTemplate.execute(tableCreateQeury);
			LOGGER.info("EMPLOYEE TABLE CREATED!");
			jdbcTemplate.update("insert into employee(emp_id,first_name,dept) values(1,'Ram','TECH')");
			jdbcTemplate.update("insert into employee(emp_id,first_name,dept) values(2,'Venu','GOV')");
			jdbcTemplate.update("insert into employee(emp_id,first_name,dept) values(3,'Raghav','ML')");
			LOGGER.info("SAMPLE DATA INSERTED INTO EMPLOYEE!");
			LOGGER.info("DATABASE SETUP DONE.");
		}catch (Exception e) {
			LOGGER.error("ERROR OCCURRED WHILE INITIATING DB SETUP!");
			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
	}
}
