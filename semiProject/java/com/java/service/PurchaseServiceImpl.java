package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.PurchaseDAOImpl;
import com.java.domain.CustomerVO;
import com.java.domain.ProductVO;
import com.java.domain.ShopBasketVO;

@Service
public class PurchaseServiceImpl implements PurchaseService {

	@Autowired
	private PurchaseDAOImpl purchaseDAO;
	
	public void updateBasket(ProductVO productVO){
		purchaseDAO.updateBasket(productVO);
	}
	
	public void insertSubGrade(CustomerVO customerVO){
		purchaseDAO.insertSubGrade(customerVO);
	}
	
	public void deleteBasket(ShopBasketVO shopBasketVO){
		purchaseDAO.deleteBasket(shopBasketVO);
	}
	
	public void confirmPayDelete(ShopBasketVO shopBasketVO){
		purchaseDAO.confirmPayDelete(shopBasketVO);
	}
	
	public List<ShopBasketVO> selectBasket(ShopBasketVO shopBasketVO) {
		return purchaseDAO.selectBasket(shopBasketVO);
	}
	
	
}
