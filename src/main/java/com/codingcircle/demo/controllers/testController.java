package com.codingcircle.demo.controllers;

import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/JPA")
public class testController {
	
	@GetMapping("/testHashMap")
	public HashMap<String,String> getAllData() {
		HashMap<String,String> map=new HashMap<String,String>();
		map.put("test", "Success");
		return map;
	}
	
	@GetMapping("/testJson")
	public HashMap<String,String> getAllDataJson() {
		JSONObject jo=new JSONObject();
		JSONArray ja=new JSONArray();
		HashMap<String,String> map=new HashMap<String,String>();
		map.put("test", "Success");
		return map;
	}

}
