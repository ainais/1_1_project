package com.java.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.ProductDAOImpl;
import com.java.domain.ProductVO;
import com.java.domain.StringVO;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAOImpl productDAO;
	
	// 상품 목록을 가져오는 select 문
	@Override
	public List<ProductVO> selectProduct(ProductVO vo) {
		return productDAO.selectProduct(vo);
	}
	@Override
	public List<ProductVO> selectGradeProduct(ProductVO vo) {
		return productDAO.selectGradeProduct(vo);
	}
	@Override
	public List<ProductVO> selectNormalProduct(ProductVO vo) {
		return productDAO.selectNormalProduct(vo);
	}
	
	@Override
	public List<ProductVO> selectProductOrder(StringVO stringVO) {
		return productDAO.selectProductOrder(stringVO);
	}
	
	@Override
	public List<ProductVO> selectBrandWhere(StringVO stringVO) {
		return productDAO.selectBrandWhere(stringVO);
	}
	
	@Override
	public void addProduct(ProductVO productVO) {
		productDAO.addProduct(productVO);
	}
	
	@Override
	public List<ProductVO> selectCompanyOrder(StringVO stringVO) {
		return productDAO.selectCompanyOrder(stringVO);
	}
	
	@Override
	public void updateProduct(ProductVO productVO) {
		productDAO.updateProduct(productVO);
	}
	
	
}
