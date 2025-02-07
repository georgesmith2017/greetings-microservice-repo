package com.autotrader.restservices.storefront.greetings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class GreetingsServiceApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(GreetingsServiceApplication.class, args);
	}
}
