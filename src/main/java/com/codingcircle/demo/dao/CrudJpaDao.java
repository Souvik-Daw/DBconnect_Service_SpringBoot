package com.codingcircle.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codingcircle.demo.models.abcd;

public interface CrudJpaDao extends JpaRepository<abcd,Integer>{

}
