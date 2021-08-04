package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.java.service.LogService;

@Controller
public class LogController {

	@Autowired
	private LogService logService;
	

}
