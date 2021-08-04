package com.java.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.domain.CustomerVO;
import com.java.domain.ProductVO;
import com.java.domain.ShopBasketVO;

@Repository
public class PurchaseDAOImpl implements PurchaseDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void updateBasket(ProductVO productVO) {
		System.out.println("==>purchase의 updateBasket 호출");
		mybatis.update("purchase.updateBasket",productVO);
	}
	public void insertSubGrade(CustomerVO customerVO) {
		System.out.println("==>purchase의 insertSubGrade 호출");
		mybatis.update("purchase.insertSubGrade",customerVO);
	}
	
	public void deleteBasket(ShopBasketVO shopBasketVO) {
		System.out.println("==>purchase의 deleteBasket 호출");
		mybatis.delete("purchase.deleteBasket",shopBasketVO);
	}
	
	public void confirmPayDelete(ShopBasketVO shopBasketVO) {
		System.out.println("==>purchase의 confirmPayDelete 호출");
		mybatis.delete("purchase.confirmPayDelete",shopBasketVO);
	}
	
	public List<ShopBasketVO> selectBasket(ShopBasketVO shopBasketVO) {
		System.out.println("==>purchase의 selectBasket 호출");
		return mybatis.selectList("purchase.selectBasket",shopBasketVO);
	}
}
