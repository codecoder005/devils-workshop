package com.devil.service;

import java.sql.Timestamp;

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
		try {
			String sql = "SELECT CURRENT_TIMESTAMP";
			Timestamp time = jdbcTemplate.queryForObject(sql, Timestamp.class);
			LOGGER.info("CONNECTION SUCCESS!");
			LOGGER.info("SERVER TIME: "+time);
		}catch (Exception e) {
			LOGGER.warn("SQL SERVER CONNECTION ISSUE!");
		}
	}
}
