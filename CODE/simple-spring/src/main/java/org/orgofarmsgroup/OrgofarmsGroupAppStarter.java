package org.orgofarmsgroup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/")
@CrossOrigin
public class OrgofarmsGroupAppStarter {
	private final Logger LOGGER = LoggerFactory.getLogger(OrgofarmsGroupAppStarter.class);
	
	public static void main(String[] args) {
		SpringApplication.run(OrgofarmsGroupAppStarter.class, args);
		//System.out.println(Sha512DigestUtils.shaHex("Orgo@12345"));
	}
	@GetMapping
	public String homePage() {
		LOGGER.info("WE GOT A REQUEST TO HOME PAGE");
		return "You are in Home page!";
	}
}