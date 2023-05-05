package com.codingcircle.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codingcircle.demo.models.test;

public interface CrudJpaDao extends JpaRepository<test,Integer>{

}
