package com.java.dao;

import java.util.List;

import com.java.domain.BoardVO;
import com.java.domain.ProductVO;
import com.java.domain.StringVO;

public interface ProductDAO {

	public List<ProductVO> selectProduct(ProductVO vo);
	public List<ProductVO> selectProductOrder(StringVO stringVO);
	public List<ProductVO> selectGradeProduct(ProductVO vo);
	public List<ProductVO> selectBrandWhere(StringVO stringVO);
	public void addProduct(ProductVO productVO);
	public List<ProductVO> selectCompanyOrder(StringVO stringVO);
	public void updateProduct(ProductVO productVO);
	public List<ProductVO> selectNormalProduct(ProductVO vo);
}
