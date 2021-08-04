package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.LogDAOImpl;

@Service
public class LogServiceImpl implements LogService {

	@Autowired
	private LogDAOImpl logDAO;
}
