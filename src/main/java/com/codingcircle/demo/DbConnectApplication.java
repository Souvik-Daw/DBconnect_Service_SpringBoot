package com.codingcircle.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DbConnectApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(DbConnectApplication.class, args);
		System.out.println("Server Started at port 8080");
		
	}

}
