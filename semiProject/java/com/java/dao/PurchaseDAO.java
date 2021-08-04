package com.java.dao;

import java.util.List;

import com.java.domain.CustomerVO;
import com.java.domain.ProductVO;
import com.java.domain.ShopBasketVO;

public interface PurchaseDAO {

	public void updateBasket(ProductVO productVO);
	public void insertSubGrade(CustomerVO customerVO);
	public List<ShopBasketVO> selectBasket(ShopBasketVO shopBasketVO);
	public void deleteBasket(ShopBasketVO shopBasketVO);
	public void confirmPayDelete(ShopBasketVO shopBasketVO);
}
