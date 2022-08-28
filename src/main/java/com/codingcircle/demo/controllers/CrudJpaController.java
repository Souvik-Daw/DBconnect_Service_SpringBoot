package com.codingcircle.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingcircle.demo.dao.CrudJpaDao;

@RestController
public class CrudJpaController {
	
	@Autowired
	CrudJpaDao crudJpaDao; 
	
	@RequestMapping("/getAllData")
	public List getAllData()
	{
		List s=crudJpaDao.findAll();
		return s;	
	}

}
