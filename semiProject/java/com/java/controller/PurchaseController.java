package com.java.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.domain.CustomerVO;
import com.java.domain.ProductVO;
import com.java.domain.ShopBasketVO;
import com.java.service.PurchaseService;

@Controller
public class PurchaseController {
	
	@Autowired
	private PurchaseService purchaseService;
	
	@RequestMapping("confirmPay")
	public String confirmPay(HttpSession session, ShopBasketVO shopBasketVO, Model m) {
		// 
		String returnData = "error";
		if(session.getAttribute("loginSession") != null) {
			CustomerVO loginSession = (CustomerVO)session.getAttribute("loginSession");
			shopBasketVO.setUserID(loginSession.getUserID());
			session.invalidate();
			m.addAttribute("membershipMessage","결제가 완료되었습니다. 재 로그인 해주세요.");
			purchaseService.confirmPayDelete(shopBasketVO);
			
			returnData="purchase/confirmPay";
		}
		return returnData;
	}
	// -----------------------------------------------
	// 멤버쉽 신청
	@RequestMapping("subscribe")
	public String subscribe(CustomerVO customerVO, HttpSession session, Model m) {
		String returnData = "error";
		
		System.out.println(customerVO.getSubGrade());
		if(session.getAttribute("loginSession") != null) {
			String price = "";
			if(customerVO.getSubGrade().equals("best")) {
				price = "300000";
			}
			if(customerVO.getSubGrade().equals("ace")) {
				price = "500000";
			}
			else if(customerVO.getSubGrade().equals("premier")) {
				price = "700000";
			}
			m.addAttribute("grade",customerVO.getSubGrade());
			m.addAttribute("totalPrice",price);
			returnData = "membershipConfirm";
		}
		return returnData;

	}
	@RequestMapping("membershipConfirmPay")
	public String membershipConfirmPay(String grade, CustomerVO customerVO, HttpSession session,Model m) {
		String returnData = "error";
		if(session.getAttribute("loginSession") != null) {
			CustomerVO loginSession = (CustomerVO)session.getAttribute("loginSession");
			customerVO.setSubGrade(grade);
			customerVO.setUserID(loginSession.getUserID());
			
			System.out.println(customerVO.getSubGrade());
			System.out.println(customerVO.getUserID());
			
			session.invalidate();
			String membershipMessage = "결제가 완료되었습니다. 재 로그인 해주세요.";
			m.addAttribute("membershipMessage",membershipMessage);
			
			purchaseService.insertSubGrade(customerVO);
			returnData = "purchase/confirmPay";
		}
		

		return returnData;
	}

	
	// -----------------------------------------------
	// 장바구니 시작
	@RequestMapping("shopBasket")
	public String shopBasket(HttpSession session, Model m, ShopBasketVO shopBasketVO) {
		CustomerVO loginSession = (CustomerVO)session.getAttribute("loginSession");
		shopBasketVO.setUserID(loginSession.getUserID());
		m.addAttribute("shopBasketList", purchaseService.selectBasket(shopBasketVO));
		return "purchase/shopBasket";
	}
	
	@RequestMapping("purchaseProduct")
	public String purchaseProduct(HttpSession session, Model m, ShopBasketVO shopBasketVO) {
		String returnData = "error";
		if(session.getAttribute("loginSession") != null) {
			CustomerVO loginSession = (CustomerVO)session.getAttribute("loginSession");
			shopBasketVO.setUserID(loginSession.getUserID());
			List<ShopBasketVO> shopBasketList= purchaseService.selectBasket(shopBasketVO);
			int totalPrice = 0;
			for(ShopBasketVO vo : shopBasketList) {
				if(vo.getProductPrice().equals("가격정보없음")) {
					totalPrice += 0;
				}
				else {
					// 단위 환율 처리
					if(vo.getProductPrice().substring(vo.getProductPrice().length()-2,vo.getProductPrice().length()).equals("달러")) {
						String tempString = vo.getProductPrice().replaceAll(",","");
						tempString = tempString.replaceAll("달러","");
						String[] temp = tempString.split("~");
						totalPrice += (Integer.parseInt(temp[0]))/10;
					}
					else if(vo.getProductPrice().substring(vo.getProductPrice().length()-2,vo.getProductPrice().length()).equals("유로")) {
						String tempString = vo.getProductPrice().replaceAll(",","");
						tempString = tempString.replaceAll("유로","");
						String[] temp = tempString.split("~");
						totalPrice += (Integer.parseInt(temp[0]))/10;
					}
					
					else {
						if(vo.getProductPrice().contains("~")) {
							String tempString = vo.getProductPrice().replaceAll(",","").replaceAll("억", "");
							tempString = tempString.replaceAll("만원","");
							String[] temp = tempString.split("~");
							totalPrice += Integer.parseInt(temp[0]);
						}
						else {
							String temp = vo.getProductPrice().replaceAll(",","").replaceAll("억", "");
							temp = temp.replaceAll("만원","");
							totalPrice += Integer.parseInt(temp);
						}

					}

				}
			}
			m.addAttribute("totalPrice",totalPrice);
			if(shopBasketList.size() != 1) {				
				m.addAttribute("productName",shopBasketList.get(0).getProductID()+"외"+(shopBasketList.size()-1)+"개");
			}
			else {
				m.addAttribute("productName",shopBasketList.get(0).getProductID());
			}
			returnData ="purchase/purchaseProduct";
		}

		return returnData;
	}
	
	@ResponseBody
	@RequestMapping(value="addShopBasket",produces="application/text;charset=UTF-8")
	public String addShopBasket(ProductVO productVO,HttpSession session) {
		
		String message="권한이 없습니다.";
		if(session.getAttribute("loginSession") != null) {
			CustomerVO loginSession = (CustomerVO)session.getAttribute("loginSession");
			productVO.setProductViewPoint(loginSession.getUserID());
			Date date_now = new Date(System.currentTimeMillis());
			SimpleDateFormat fourteen_format = new SimpleDateFormat("yyyyMMddHHmmss");
			System.out.println(fourteen_format.format(date_now));
			
			productVO.setProductChar(fourteen_format.format(date_now));
			purchaseService.updateBasket(productVO);
			message="장바구니에 담겼습니다.";
		}

		return message;
	}
	
	@ResponseBody
	@RequestMapping(value="deleteShopBasket",produces="application/text;charset=UTF-8")
	public String deleteShopBasket(ShopBasketVO shopBasketVO,HttpSession session) {
		System.out.println(shopBasketVO.getUserID());
		System.out.println(shopBasketVO.getProductID());
		System.out.println(shopBasketVO.getBasketRegDate());
		
		String message="권한이 없습니다.";
		if(session.getAttribute("loginSession") != null) {
			CustomerVO loginSession = (CustomerVO)session.getAttribute("loginSession");
			shopBasketVO.setUserID(loginSession.getUserID());
			
			purchaseService.deleteBasket(shopBasketVO);
			message="해당 물품을 삭제하였습니다..";
		}

		return message;
	}
	// 장바구니 종료
	// -----------------------------------------------
}
