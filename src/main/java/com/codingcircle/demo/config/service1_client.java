package com.codingcircle.demo.config;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="Service1") 
@LoadBalancerClient(name = "Service1")
public interface service1_client 
{
	@PostMapping(value = "/crud1/test", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<?> create();
}
