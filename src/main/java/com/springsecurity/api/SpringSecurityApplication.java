package com.springsecurity.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.springsecurity.api.*"})
public class SpringSecurityApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}
}
