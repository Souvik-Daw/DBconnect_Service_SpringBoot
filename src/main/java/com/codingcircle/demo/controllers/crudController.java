package com.codingcircle.demo.controllers;

import com.codingcircle.demo.bean.testBean;
import com.codingcircle.demo.services.crudService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.codingcircle.demo.config.service1_client;

@RestController
@RequestMapping("/crud")
public class crudController 
{
	
	@Autowired
	crudService crudService;
	
	@Autowired
	service1_client service1_client; 
	
	@RequestMapping(value="/feignCreate",method=RequestMethod.POST)
	public ResponseEntity<?> feignCreate()
	{
		Map<String,String> testBean=(Map<String, String>) service1_client.create().getBody();
		return new ResponseEntity(testBean, HttpStatus.OK);
	}
	
	@RequestMapping(value="/restRead",method=RequestMethod.POST)
	public ResponseEntity<?> restRead()
	{
		List<testBean> testBean=crudService.restReadTest();
		return new ResponseEntity(testBean, HttpStatus.OK);
	}
	
	@RequestMapping(value="/restCreate",method=RequestMethod.POST)
	public ResponseEntity<?> restCreate(@RequestBody testBean testBean)
	{
		String status=crudService.restCreateTest(testBean);
		Map<String,String> map=new HashMap<String,String>();
		map.put("Status", status);
		return new ResponseEntity(map, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/read",method=RequestMethod.POST)
	public ResponseEntity<?> read()
	{
		List<testBean> testBean=crudService.readTest();
		return new ResponseEntity(testBean, HttpStatus.OK);
	}
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody testBean testBean)
	{
		String status=crudService.createTest(testBean);
		Map<String,String> map=new HashMap<String,String>();
		map.put("Status", status);
		return new ResponseEntity(map, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public ResponseEntity<?> update(@RequestBody testBean testBean)
	{
		String status=crudService.updateTest(testBean);
		Map<String,String> map=new HashMap<String,String>();
		map.put("Status", status);
		return new ResponseEntity(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public ResponseEntity<?> delete(@RequestBody testBean testBean)
	{
		String status=crudService.deleteTest(testBean);
		Map<String,String> map=new HashMap<String,String>();
		map.put("Status", status);
		return new ResponseEntity(map, HttpStatus.OK);
	}
	
	//@Scheduled(fixedDelay = 1000, initialDelay = 1000)
	@Scheduled(cron = "${scheduler.crons.test}")
	public void scheduleFixedDelayTask() {
	    System.out.println("Scheduler");
	}
}
