package com.codingcircle.demo.dao;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.transaction.SystemException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.codingcircle.demo.bean.testBean;

@SpringBootTest
public class crudDaoTest {
	
	@Mock SessionFactory sessionFactory;
	@Mock Query query;
	@Mock Session session;
	@Mock Transaction transaction;
	@Mock Exception exception;
	
	@InjectMocks crudDaoImpl crudDaoImpl;
	
	
	
	
//	@BeforeEach
//	public void setUp()
//	{
//		MockitoAnnotations.initMocks(this);
//		when(sessionFactory.openSession()).thenReturn(session);
//		when(session.getTransaction()).thenReturn(transaction);
//		
//	}
	
	
	@Test
	void contextLoads() {
	}
	
//	@Test
//	void createTest()
//	{
//		
//		testBean testBean = new testBean();
//		when(crudDaoImpl.createTest(testBean)).thenReturn("Created");
//		String status = crudDaoImpl.createTest(testBean);
//		verify(session).close();
//		assertEquals(status,"Created");
//	}

}
