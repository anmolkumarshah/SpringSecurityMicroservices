package com.anmol.spring_security.CouponService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CouponServiceApplication implements CommandLineRunner {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(CouponServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String encode = bCryptPasswordEncoder.encode("test123");
		logger.info("encode -> {}",encode);
		boolean matches = bCryptPasswordEncoder.matches("test123", "$2a$10$.4ObaacLfE5e.Tk.laYrS..Y1HlNGuPD8P9OIgYShg6Sgh5xHz7fO");
		logger.info("matches -> {}",matches);
	}
}

