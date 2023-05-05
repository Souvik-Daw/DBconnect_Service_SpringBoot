package com.codingcircle.demo;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableFeignClients
@Configuration
@EnableEurekaClient
@SpringBootApplication
@EnableScheduling
public class DbConnectApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(DbConnectApplication.class, args);
		System.out.println("Server Started at port 8080");
		
	}
	
	@Bean
	GroupedOpenApi DigifleetCrud() 
	{ 
	    return GroupedOpenApi.builder().group("Digifleet Crud").pathsToMatch("/**/crud/**").build();
	}
	
	@Bean
	GroupedOpenApi TestCrud() 
	{ 
	    return GroupedOpenApi.builder().group("Test").pathsToMatch("/**/getAllData/**").build();
	}
	
	@Bean
	GroupedOpenApi JPACrud() 
	{ 
	    return GroupedOpenApi.builder().group("JPA").pathsToMatch("/**/JPA/**").build();
	}

}
