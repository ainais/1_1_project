package com.java.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LogDAOImpl implements LogDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
}
