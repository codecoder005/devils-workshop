package org.orgofarmsgroup.init;

import java.sql.Timestamp;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class StartUpServices {
	private static final Logger LOGGER = LoggerFactory.getLogger(StartUpServices.class);
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@PostConstruct
	public void postConstruct() {
		try {
			LOGGER.info("POST-CONSTRUCT Initiated...");
			Timestamp curentTimestamp = jdbcTemplate.queryForObject("SELECT CURRENT_TIMESTAMP", Timestamp.class);
			LOGGER.info("DATABASE CONNECTION SUCCESS. "+curentTimestamp.toString());
		}catch (Exception e) {
			LOGGER.warn(e.getMessage());
			LOGGER.error("DATABASE CONNECTION FAILED.");
			e.printStackTrace();
		}
	}
}
