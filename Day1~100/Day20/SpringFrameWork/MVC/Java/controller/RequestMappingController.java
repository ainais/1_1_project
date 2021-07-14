package com.javaclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaclass.model.MemberVO;

@Controller
@RequestMapping("re")
public class RequestMappingController {
	
	@RequestMapping(value= {"/a.do","/b.do"})
	public String test() {
		System.out.println(".do 요청확인");
		// ModelAndView
		// *****************************
		// return 형이 String 인 경우 view page 지정임
		
		return "start";
	}
	
	@RequestMapping("/c.do")
	public void sample(String id) {
		// return 형이 void인 경우 자동으로 요청명(requestName)과 동일한 view페이지를 지정
		// 현재 페이지의 요청명 : re/c.do => 즉 void일 경우 view/re/c를 보여준다.
		System.out.println("이전 페이지(클라이언트)로 부터 받은 데이터 : " + id);
	}
	
	@RequestMapping(value="/request.do",method=RequestMethod.POST)
	// 이전화면의 Form 안의 입력값을 얻어와서 MemberVO 객체의 멤버로 저장
	public void request(MemberVO vo) {
		//public void request(@ModelAttribute("vo") MemberVO vo)=> memberVO가 아닌 vo로 사용하고 싶을 때
		System.out.println("멤버의 아이디 : " + vo.getId());
	}
	
	@RequestMapping(value="/model.do")
	public void model(Model m) { // view단으로 객체에 데이터를 저장해서 넘김 : 변수에 model을 선언한다
		m.addAttribute("message", "오늘도 우리조 화이팅");
		m.addAttribute("data", "스프링 만세");
	}

}
