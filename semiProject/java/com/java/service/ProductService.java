package com.java.service;

import java.util.*;

import com.java.domain.ProductVO;
import com.java.domain.StringVO;

public interface ProductService {

	public List<ProductVO> selectProduct(ProductVO vo);
	public List<ProductVO> selectProductOrder(StringVO stringVO);
	public List<ProductVO> selectGradeProduct(ProductVO vo);
	public List<ProductVO> selectBrandWhere(StringVO stringVO);
	public void addProduct(ProductVO productVO);
	public List<ProductVO> selectCompanyOrder(StringVO stringVO);
	public void updateProduct(ProductVO productVO);
	public List<ProductVO> selectNormalProduct(ProductVO vo);
}
