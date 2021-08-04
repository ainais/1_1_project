package com.java.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.domain.CustomerVO;
import com.java.domain.ProductVO;
import com.java.domain.StringVO;
import com.java.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("product.do")
	public void product(ProductVO vo,Model m, HttpSession session) {
		String message = "";
		if(session.getAttribute("loginSession") != null) {
			CustomerVO loginSession = (CustomerVO) session.getAttribute("loginSession");
			if(loginSession.getSubGrade()!=null) {
				if(loginSession.getSubGrade().equals("best")) {
					vo.setProductGrade("D");
				}
				else if(loginSession.getSubGrade().equals("ace")) {
					vo.setProductGrade("B");
				}
				else if(loginSession.getSubGrade().equals("premier")) {
					vo.setProductGrade("A");
				}
				System.out.println(vo.getProductGrade());
				
				m.addAttribute("productList",productService.selectGradeProduct(vo));
				message = "현재 고객님의 멤버쉽 등급은" + loginSession.getSubGrade() + "이며, "
						+ " 이용할 수 있는 차량 등급은 " + vo.getProductGrade() + "등급 까지입니다.";
				m.addAttribute("msessage",message);	
				System.out.println("========product.do 종료============");
			}
			else {
				System.out.println("========product.do 시작============");
				m.addAttribute("productList",productService.selectNormalProduct(vo));
				m.addAttribute("msessage","멤버쉽 가입 후 회원님께 맞는 등급의 차량을 확인할 수 있습니다.");	
				System.out.println("========product.do 종료============");
			}

		}
		else {
			System.out.println("========product.do 시작============");
			m.addAttribute("productList",productService.selectNormalProduct(vo));
			m.addAttribute("msessage","멤버쉽 가입 후 회원님께 맞는 등급의 차량을 확인할 수 있습니다.");	
			System.out.println("========product.do 종료============");
		}
	}
	
	
	@RequestMapping("allProduct.do")
	public void allProduct(ProductVO vo,Model m) {
		m.addAttribute("productList",productService.selectProduct(vo));
	}
	
	@RequestMapping("membership.do")
	public void membership(ProductVO vo,Model m) {
		m.addAttribute("productList",productService.selectProduct(vo));
	}
	
	@RequestMapping("viewPoint.do")
	public void viewPoint(ProductVO vo,Model m) {
		m.addAttribute("productList",productService.selectProduct(vo));
	}
	
	@RequestMapping("test.do")
	public void test(ProductVO vo,Model m) {
		m.addAttribute("productList",productService.selectProduct(vo));
	}
	
	@RequestMapping("carGradeOrder.do")
	public String carGradeOrder(StringVO stringVO, Model m) {
		System.out.println(stringVO.getStr());
		System.out.println(stringVO.getBrand());
		m.addAttribute("productList",productService.selectProductOrder(stringVO));
		return "allProduct";
	}
	
	@RequestMapping("carBrandWhere")
	public String carBrandWhere(StringVO stringVO, Model m) {
		System.out.println(stringVO.getBrand());
		m.addAttribute("productList",productService.selectBrandWhere(stringVO));
		return "allProduct";
	}
	
	//=====================================
	// 업체 관리자 시작
	// 게시물 관리 - 등록한 상품목록 조회
	@RequestMapping("showAddProduct")
	public String showAddProduct(StringVO stringVO, Model m, HttpSession session) {
		CustomerVO loginSession = (CustomerVO)session.getAttribute("loginSession");
		stringVO.setCompanyName(loginSession.getUserID());
		
		m.addAttribute("productList",productService.selectCompanyOrder(stringVO));
		return "companyCustomer/showAddProduct"; 
	}
	
	// 상품 수정하기
	@RequestMapping("companyViewPoint")
	public String companyViewPoint(ProductVO productVO, StringVO stringVO, Model m, HttpSession session) {
		CustomerVO loginSession = (CustomerVO)session.getAttribute("loginSession");
		System.out.println(productVO.getProductID());
		String returnData = "error";
		if(loginSession.getUserGrade().equals("관리자") || loginSession.getUserGrade().equals("업체")) {
			m.addAttribute("productCompanyList",productService.selectProduct(productVO));
			returnData = "companyCustomer/companyViewPoint";
		}

		
		m.addAttribute("productList",productService.selectCompanyOrder(stringVO));
		return  returnData;
	}
	
	@RequestMapping("updateProduct.do")
	public String updateProduct(ProductVO productVO, HttpSession session) {
		String returnData = "error";
		CustomerVO loginSession = (CustomerVO)session.getAttribute("loginSession");
		if(loginSession.getUserGrade().equals("관리자") || loginSession.getUserGrade().equals("업체")) {
			productService.updateProduct(productVO);
			returnData = "redirect:showAddProduct.do";
		}
		return returnData;
	}
	
	// 상품 등록 
	@RequestMapping("addProduct")
	public String addProduct(ProductVO productVO, Model m) {
		
		return "companyCustomer/addProduct";
	}
	
	@RequestMapping("addProductOK")
	public String addProductOK(ProductVO productVO, Model m, HttpSession session) {
		CustomerVO loginSession = (CustomerVO)session.getAttribute("loginSession");
		
		System.out.println("===============================");
		
		productVO.setProductColorCnt("0");		productVO.setProductSaleRate("0");		productVO.setProductCoupon("0");
		productVO.setProductDelivery("0");		productVO.setProductCnt("0");		productVO.setProductSaleCnt("0");
		
		productVO.setProductGrade("A");
		productVO.setProductCompanyName(loginSession.getUserID());

		System.out.println("===============================");
		productService.addProduct(productVO);
		//m.addAttribute("productList",productService.selectBrandWhere(stringVO));
		return "redirect:mypage.do";
	}
	// 업체 관리자 종료
	//=====================================
}
