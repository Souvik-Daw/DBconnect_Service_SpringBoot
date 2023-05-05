package com.codingcircle.demo.dao;


import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.codingcircle.demo.bean.testBean;
import com.codingcircle.demo.config.DBConnect;
import com.codingcircle.demo.models.test;

@Repository
@Transactional
//@RibbonClient(name = "Service1")
public class crudDaoImpl implements crudDao
{
	
	RestTemplate restTemplate=new RestTemplate();
	
	@Autowired
	SessionFactory sessionFactory;
	
	DBConnect DBConnect;
	
	public SessionFactory getSessionfactory()
	{
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	public String createTest(testBean testBean) 
	{
		Session session=this.sessionFactory.openSession();
		String status="Created";
		try 
		{
			session.beginTransaction();
			test test=new test();
			test.setId(testBean.getId());
			test.setFirstName(testBean.getFirstName());
			session.save(test);
			session.getTransaction().commit();
		    session.close();
		}
		catch(Exception e)
		{
			status="Not Created";
		}
		return status;
	}

	public String updateTest(testBean testBean) 
	{
		Session session=this.sessionFactory.openSession();
		String status="Updated";
		try 
		{
			session.beginTransaction();
			test test=session.load(test.class, testBean.getId());
			test.setId(testBean.getId());
			test.setFirstName(testBean.getFirstName());
			session.save(test);
			session.getTransaction().commit();
		    session.close();
		}
		catch(Exception e)
		{
			status="Not Updated";
		}
		return status;
	}

	public List<testBean> readTest() 
	{
		
		Session session=this.sessionFactory.openSession();
		//Session session=DBConnect.getCurrentSession();
		List list=null;
		session.beginTransaction();
		List<testBean> responseList=new ArrayList();
		StringBuilder queryStr=new StringBuilder(0);
		try
		{	
			queryStr.append("select * from test where id>:id");
			Query query=session.createSQLQuery(queryStr.toString()).setParameter("id",1);
			list =  query.getResultList();
			if(list!=null && list.size()>0)
			{
				for(Iterator it=list.iterator();it.hasNext();)
				{
					Object[] obj=(Object[])it.next();
					testBean testBean=new testBean();
					testBean.setId(Integer.parseInt(obj[0]+""));
					testBean.setFirstName(obj[1]+"");
					responseList.add(testBean);
				}
			}
			session.getTransaction().commit();
		    session.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception at crudDaoImpl read function");
		}
		return responseList;
	}

	public String deleteTest(testBean testBean) 
	{
		Session session=this.sessionFactory.openSession();
		String status="Deleted";
		StringBuilder queryStr=new StringBuilder(0);
		try
		{	
			session.beginTransaction();
			queryStr.append("delete from test where id=:id");
			Query query=session.createSQLQuery(queryStr.toString()).setParameter("id",testBean.getId());
			query.executeUpdate();
			session.getTransaction().commit();
		    session.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception at crudDaoImpl update function");
			status="Not Deleted";
		}
		return status;
	}

	public List<testBean> restReadTest() 
	{
		String url="http://localhost:8080/crud/read";
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity<testBean> entity = new HttpEntity<testBean>(headers);
	    List<testBean> result=restTemplate.exchange(url, HttpMethod.POST, entity, List.class).getBody();
		return result;
	}

	public String restCreateTest(testBean testBean) 
	{
		String url="http://localhost:8080/crud/create";
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity<testBean> entity = new HttpEntity<testBean>(testBean,headers);
	    Map<String,String> result=restTemplate.exchange(url, HttpMethod.POST, entity,Map.class).getBody();
		return result.get("Status");
	}
	
	

}
