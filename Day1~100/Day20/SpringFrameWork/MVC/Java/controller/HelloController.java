package com.javaclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping("start.do")
	public ModelAndView test() {
		System.out.println("start.do 요청");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("start");
		mv.addObject("test", "하이염");
		return mv;
	}
}
