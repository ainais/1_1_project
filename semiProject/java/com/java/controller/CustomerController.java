package com.java.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.domain.BoardVO;
import com.java.domain.CustomerVO;
import com.java.domain.LogVO;
import com.java.domain.ProductVO;
import com.java.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	// 로그인 할 때 세션 부여
	@RequestMapping("login.do")
	public String login(CustomerVO customerVO, HttpSession session, Model m) {
		System.out.println(customerVO.getUserID());
		System.out.println(customerVO.getUserPW());
		System.out.println("===============================");
		
		if(customerService.loginSelect(customerVO)!=null) {
			CustomerVO dbVO = customerService.loginSelect(customerVO);
			
			System.out.println(dbVO.getUserID());
			System.out.println(dbVO.getUserPW());
			if(customerVO.getUserID().equals(dbVO.getUserID()) &&
					customerVO.getUserPW().equals(dbVO.getUserPW())) { // 로그인에 성공한다면
				session.setAttribute("loginSession", dbVO); // 세션을 부여하고
				
				//===========================================
				//로그인 할 때 세션 값 로그에 추가하기 시작
				LogVO logVO = new LogVO();
				logVO.setUserID(customerVO.getUserID());
				
				// 우리가 필요로 하는 데이터 양식으로 시간 데이터 import하기
				Date today = new Date();

				SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
				String todayDate = date.format(today);
				logVO.setLogCreateSessionDate(todayDate);
				logVO.setLogVisitPage("0");
				customerService.logInsert(logVO);
				//로그인 할 때 세션 값 로그에 추가하기 종료
				//===========================================
			}
		}
		else {
			m.addAttribute("loginMessage","로그인에 실패하였습니다.");
		}

		
		
		return "../../index";
	}
	
	// 로그아웃 시 세션만료
	@RequestMapping("logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "../../index";
	}
	
	// 회원가입
	@RequestMapping("insertCustomer.do")
	public String insertCustomer(CustomerVO customerVO) {
		
		customerService.insertCustomer(customerVO);
		return "../../index";
	}

	//아이디 유효성 검사
	@ResponseBody
	@RequestMapping(value="ajaxLoginCheck",produces="application/text;charset=UTF-8")
	public String ajaxLoginCheck(CustomerVO customerVO) {
		String message = "사용 가능한 아이디 입니다.";
		System.out.println(customerVO.getUserID());
		
		if(customerService.ajaxLoginCheck(customerVO) != null) {
			CustomerVO dbVO = customerService.ajaxLoginCheck(customerVO);
			System.out.println(dbVO.getUserID());
			message = "이미 사용중인 아이디 입니다.";
		}
		return message;
	}
	// 마이페이지
	@RequestMapping("mypage.do")
	public String mypage(HttpSession session,Model m) {
		String returnData = "../../index";
		if(session.getAttribute("loginSession") != null) {
			
			CustomerVO loginSession = (CustomerVO) session.getAttribute("loginSession");
			List<CustomerVO> dbCustomerList = customerService.selectCustomerList();
			
			//======================
			// 고객 평균 나이 계산 시작
			int totalAge = 0;
			double avgAge=0;
			
			for(CustomerVO customerVO : dbCustomerList) {
				String birthday = customerVO.getUserBirthday();
				if(birthday.substring(0,2).equals("19")) {
					totalAge += ((121-Integer.parseInt(birthday.substring(2,4)))+1);
				}
				else {
					totalAge += (21-Integer.parseInt(birthday.substring(2,4))+1);
				}
				avgAge= totalAge/(dbCustomerList.size());	
			} // end of for
			// 고객 평균 나이 계산 종료
			//======================

			//======================
			// 고객 남녀 성비 계산 시작
			int man = 0;
			int woman = 0;
			for(CustomerVO customerVO : dbCustomerList) {
				String gender = customerVO.getUserGender();
				if(gender.equals("man")) {
					man += 1;
				}
				else {
					woman += 1;
				}
			}
			double manRate = (man*100/dbCustomerList.size());
			double womanRate = (woman*100/dbCustomerList.size());
			String genderRate = manRate/10+"  :  "+womanRate/10;
			// 고객 남녀 성비 계산 종료
			//======================
			
			//======================
			// 베스트 후기 시작
			List<BoardVO> dbBestBoardList = customerService.selectBestBoardList();
			// 베스트 후기 종료
			//======================
			
			//======================
			// 최근 업체 물품 등록 시작
			List<ProductVO> dbRecentProductList = customerService.selectRecentBoardList();
			// 최근 업체 물품 등록 종료
			//======================
			
			//======================
			// 오늘 가입한 고객 불러오기 시작
			Date today = new Date();

			SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
			
			String todayDate = date.format(today);

			int todayCustomer = 0;
			List<CustomerVO> dbTodayCustomerList = customerService.selectTodayCustomerList();
			for(CustomerVO customerVO : dbTodayCustomerList) {
				if(todayDate.equals(customerVO.getUserRegdate().substring(0,10))) {
					todayCustomer++;
				}
			}
			// 오늘 가입한 고객 불러오기 종료
			//======================
			
			//======================
			// 최근 1주일 방문한 고객 수 계산 시작
			List<LogVO> todayLogVO = customerService.selectAllLog();
			int todayVisitCustomer = 0;
			
			String today1 = date.format(new Date(121,today.getMonth(),today.getDate()-1));
			String today2 = date.format(new Date(121,today.getMonth(),today.getDate()-2));
			String today3 = date.format(new Date(121,today.getMonth(),today.getDate()-3));
			String today4 = date.format(new Date(121,today.getMonth(),today.getDate()-4));
			String today5 = date.format(new Date(121,today.getMonth(),today.getDate()-5));
			String today6 = date.format(new Date(121,today.getMonth(),today.getDate()-6));
			
			int VisitCustomer1 = 0;
			int VisitCustomer2 = 0;
			int VisitCustomer3 = 0;
			int VisitCustomer4 = 0;
			int VisitCustomer5 = 0;
			int VisitCustomer6 = 0;

			for(LogVO logVO : todayLogVO) {
				if(todayDate.equals(logVO.getLogCreateSessionDate().substring(0,10))) {
					todayVisitCustomer++;
				}	
				else if(today1.equals(logVO.getLogCreateSessionDate().substring(0,10))) {
					VisitCustomer1++;
				}
				else if(today2.equals(logVO.getLogCreateSessionDate().substring(0,10))) {
					VisitCustomer2++;
				}
				else if(today3.equals(logVO.getLogCreateSessionDate().substring(0,10))) {
					VisitCustomer3++;
				}
				else if(today4.equals(logVO.getLogCreateSessionDate().substring(0,10))) {
					VisitCustomer4++;
				}
				else if(today5.equals(logVO.getLogCreateSessionDate().substring(0,10))) {
					VisitCustomer5++;
				}
				else if(today6.equals(logVO.getLogCreateSessionDate().substring(0,10))) {
					VisitCustomer6++;
				}
			}
			// 최근 1주일 방문한 고객 수 계산 종료
			//======================
			int MemberShipCustomer0 = 0;
			int MemberShipCustomer1 = 0;
			int MemberShipCustomer2 = 0;
			int MemberShipCustomer3 = 0;
			int MemberShipCustomer4 = 0;
			int MemberShipCustomer5 = 0;
			int MemberShipCustomer6 = 0;
			for(CustomerVO customerVO : dbCustomerList) {
				if(customerVO.getSubStartDate() != null) {
					if(todayDate.equals(customerVO.getSubStartDate().substring(0,10))) {
						MemberShipCustomer0++;
					}
					else if(today1.equals(customerVO.getSubStartDate().substring(0,10))) {
						MemberShipCustomer1++;
					}
					else if(today2.equals(customerVO.getSubStartDate().substring(0,10))) {
						MemberShipCustomer2++;
					}
					else if(today3.equals(customerVO.getSubStartDate().substring(0,10))) {
						MemberShipCustomer3++;
					}
					else if(today4.equals(customerVO.getSubStartDate().substring(0,10))) {
						MemberShipCustomer4++;
					}
					else if(today5.equals(customerVO.getSubStartDate().substring(0,10))) {
						MemberShipCustomer5++;
					}
					else if(today6.equals(customerVO.getSubStartDate().substring(0,10))) {
						MemberShipCustomer6++;
					}
				}
			}
			//======================
			// 최근 1주일 멤버쉽 가입한 고객 수 계산 시작
			
			// 최근 1주일 멤버쉽 가입한 고객 수 계산 종료
			//======================
			if(loginSession.getUserGrade().equals("관리자")) {
				m.addAttribute("avgAge",avgAge);
				m.addAttribute("genderRate",genderRate);
				m.addAttribute("dbBestBoardList",dbBestBoardList);
				m.addAttribute("dbRecentProductList",dbRecentProductList);
				m.addAttribute("todayNewCustomer",todayCustomer);
				
				m.addAttribute("todayVisitCustomer",todayVisitCustomer);
				m.addAttribute("VisitCustomer1",VisitCustomer1);
				m.addAttribute("VisitCustomer2",VisitCustomer2);
				m.addAttribute("VisitCustomer3",VisitCustomer3);
				m.addAttribute("VisitCustomer4",VisitCustomer4);
				m.addAttribute("VisitCustomer5",VisitCustomer5);
				m.addAttribute("VisitCustomer6",VisitCustomer6);
				
				m.addAttribute("MemberShipCustomer0",MemberShipCustomer0);
				m.addAttribute("MemberShipCustomer1",MemberShipCustomer1);
				m.addAttribute("MemberShipCustomer2",MemberShipCustomer2);
				m.addAttribute("MemberShipCustomer3",MemberShipCustomer3);
				m.addAttribute("MemberShipCustomer4",MemberShipCustomer4);
				m.addAttribute("MemberShipCustomer5",MemberShipCustomer5);
				m.addAttribute("MemberShipCustomer6",MemberShipCustomer6);
				returnData = "mypage/admin";
			}
			
			else if(loginSession.getUserGrade().equals("업체")) {
				m.addAttribute("avgAge",avgAge);
				m.addAttribute("genderRate",genderRate);
				m.addAttribute("dbBestBoardList",dbBestBoardList);
				m.addAttribute("dbRecentProductList",dbRecentProductList);
				m.addAttribute("todayNewCustomer",todayCustomer);
				
				m.addAttribute("todayVisitCustomer",todayVisitCustomer);
				m.addAttribute("VisitCustomer1",VisitCustomer1);
				m.addAttribute("VisitCustomer2",VisitCustomer2);
				m.addAttribute("VisitCustomer3",VisitCustomer3);
				m.addAttribute("VisitCustomer4",VisitCustomer4);
				m.addAttribute("VisitCustomer5",VisitCustomer5);
				m.addAttribute("VisitCustomer6",VisitCustomer6);
				
				m.addAttribute("MemberShipCustomer0",MemberShipCustomer0);
				m.addAttribute("MemberShipCustomer1",MemberShipCustomer1);
				m.addAttribute("MemberShipCustomer2",MemberShipCustomer2);
				m.addAttribute("MemberShipCustomer3",MemberShipCustomer3);
				m.addAttribute("MemberShipCustomer4",MemberShipCustomer4);
				m.addAttribute("MemberShipCustomer5",MemberShipCustomer5);
				m.addAttribute("MemberShipCustomer6",MemberShipCustomer6);
				returnData = "mypage/company";
			}
			
			else if(loginSession.getUserGrade().equals("고객")) {
				returnData = "mypage/customer";
			}
			
		}
		return returnData;
	} // end of mypage
	//==============================
	// 동현형 시작
	//회원 목록 보기
	@RequestMapping("/getCustomerList.do")
	public String getCustomerList(CustomerVO customerVO,Model model){
	model.addAttribute("customerList",customerService.getCustomerList(customerVO));
	return "info/getCustomerList";
	}
	
	//회원 목록 수정
	@RequestMapping("/updateCustomer.do")
	public String updateCustomer(CustomerVO customerVO,Model model) {
	customerService.updateCustomer(customerVO);	
	model.addAttribute("customerList",customerService.getCustomerList(customerVO));
		return "info/getCustomerList";		
	}
	
	//회원 목록 상세보기
	@RequestMapping("/updateForm.do")
	public String updateForm(CustomerVO customerVO,Model model){
	System.out.println(customerVO.getUserID());
	model.addAttribute("customerDetail", customerService.customerDetail(customerVO));
	return "info/updateForm";
	}
	
	//회원 목록 삭제 상세
	@RequestMapping("/deleteForm.do")
	public String deleteForm(CustomerVO customerVO,Model model){
	System.out.println(customerVO.getUserID());
	model.addAttribute("customerDetail", customerVO.getUserID());
	return "info/deleteForm";
	}
	
	//회원 목록탈퇴
	@RequestMapping("/deleteCustomer2.do")
	public String deleteCustomer2(CustomerVO customerVO,Model model) {
	String returnData = "error";
	if(customerService.loginSelect(customerVO) != null) {
		CustomerVO dbVO = customerService.loginSelect(customerVO);	
		
		if(customerVO.getUserPW().equals(dbVO.getUserPW())) {
			customerService.deleteCustomer2(customerVO);
			model.addAttribute("customerList",customerService.getCustomerList(customerVO));
			returnData = "info/getCustomerList";
		}
	}
		return returnData;		
	}
	// 동현형 종료
	//==============================
	// 마이페이지 -> 내 정보 관리 -> 회원정보수정 -> 비밀번호 일치 여부 확인

	@RequestMapping(value="modifyCustomer.do")
	public String modifyCustomer(CustomerVO vo, Model m, HttpSession session, String userNewPW) {
		System.out.println("=======ModiFy 시작=========");
		System.out.println(vo.getUserPW());
		System.out.println(userNewPW);
		
		String message = "비밀번호가 일치하지 않습니다.";
		
		String returnData ="error";
		
		boolean chenkPW = customerService.checkPW(vo);
		
		// 비밀번호가 일치한다면
		if(chenkPW) {
			if(userNewPW != "") {
				System.out.println(userNewPW);
				vo.setUserPW(userNewPW);
			}
			customerService.modifyCustomer(vo);
			CustomerVO dbVO = customerService.loginSelect(vo);
			session.setAttribute("loginSession", dbVO);
			message ="다시 로그인 해주세요";
			m.addAttribute("successMessage", message);
			returnData = "mypage/customer";
			
		// 비밀번호가 일치하지 않는다면
		} else {
			m.addAttribute("failMessage", message);
			returnData = "mypage/customer";
		}
		System.out.println(vo.getUserPW());
		System.out.println("=======ModiFy 종료=========");
		return returnData;
	}
	
	
	// 마이페이지 -> 내 정보 관리 -> 회원탈퇴
	// 메인 페이지로 돌아가고, 세션종료
	@RequestMapping("deleteCustomer.do")
	public String deleteCustomer(CustomerVO vo, HttpSession session) {
		customerService.deleteCustomer(vo);
		session.invalidate();
		return "../../index";
	}
	
												// ▼ 세션에서 속성을 하나만 제거한다
												// session.removeAttribute("~~");
												// ▼ 세션 종료
												// session.invalidate();
	// 마이페이지 -> 구독정보보기 -> 구독취소
	// 세션 새로고침..........................................................................
	@RequestMapping("cancleSUB.do")
	public String cancleSUB(CustomerVO vo, HttpSession session) {
		customerService.cancleSUB(vo);
		CustomerVO dbVO = customerService.loginSelect(vo);
		session.setAttribute("loginSession", dbVO);
		//session.removeAttribute("loginSession.subGrade");
		return "mypage/customer";
	}
	
}
