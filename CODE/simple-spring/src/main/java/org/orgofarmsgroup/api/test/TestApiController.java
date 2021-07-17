package org.orgofarmsgroup.api.test;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class TestApiController {
	private static final Logger LOGGER = LoggerFactory.getLogger(TestApiController.class);
	
	@Autowired
	private HttpServletRequest httpServletRequest;
	
	@GetMapping
	public String sayHello() {
		LOGGER.info("got a request to /hello from: "+httpServletRequest.getRequestURL());
		return "Hello. Welcome to OrogfarmsGroup!";
	}
}