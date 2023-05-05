package com.codingcircle.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codingcircle.demo.dao.crudDao;
import com.codingcircle.demo.bean.testBean;

@Service("crudService")
public class crudServiceImpl implements crudService{
	
	@Autowired
	crudDao crudDao;

	public String createTest(testBean testBean) 
	{
		return crudDao.createTest(testBean);
	}

	public String updateTest(testBean testBean) 
	{
		return crudDao.updateTest(testBean);
	}

	public List<testBean> readTest() 
	{
		return crudDao.readTest();
	}

	public String deleteTest(testBean testBean) 
	{
		return crudDao.deleteTest(testBean);
	}

	public List<testBean> restReadTest() 
	{
		return crudDao.restReadTest();
	}

	public String restCreateTest(testBean testBean) 
	{
		return crudDao.restCreateTest(testBean);
	}

	
	
}
