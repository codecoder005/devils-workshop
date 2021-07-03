package com.devil.unittestcases;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestCasesRunner {
	private static final Logger LOGGER = LoggerFactory.getLogger(TestCasesRunner.class);
	@Test
	public void testCase1() {
		LOGGER.info("TEST PASSED!");
	}
}
