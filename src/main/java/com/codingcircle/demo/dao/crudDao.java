package com.codingcircle.demo.dao;

import java.util.List;

import com.codingcircle.demo.bean.testBean;

public interface crudDao {
	
	public String createTest(testBean testBean);
	
	public String updateTest(testBean testBean);
	
	public List<testBean> readTest();
	
	public String  deleteTest(testBean testBean);
	
	public List<testBean> restReadTest();
	
	public String restCreateTest(testBean testBean);

}
