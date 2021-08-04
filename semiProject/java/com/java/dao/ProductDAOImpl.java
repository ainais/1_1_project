package com.java.dao;

import java.util.*;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.domain.ProductVO;
import com.java.domain.StringVO;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public List<ProductVO> selectProduct(ProductVO vo) {
		System.out.println("==>product의 selectProduct 호출");
		return mybatis.selectList("product.selectProduct",vo);
	}
	public List<ProductVO> selectGradeProduct(ProductVO vo) {
		System.out.println("==>product의 selectGradeProduct 호출");
		return mybatis.selectList("product.selectGradeProduct",vo);
	}
	
	public List<ProductVO> selectNormalProduct(ProductVO vo) {
		System.out.println("==>product의 selectNormalProduct 호출");
		return mybatis.selectList("product.selectNormalProduct",vo);
	}
	
	public List<ProductVO> selectProductOrder(StringVO stringVO) {
		System.out.println("==>product의 selectProductOrder 호출");
		return mybatis.selectList("product.selectProductOrder",stringVO);
	}
	
	public List<ProductVO> selectBrandWhere(StringVO stringVO) {
		System.out.println("==>product의 selectBrandWhere 호출");
		return mybatis.selectList("product.selectBrandWhere",stringVO);
	}
	
	public void addProduct(ProductVO productVO) {
		System.out.println("==>product의 addProduct 호출");
		mybatis.insert("product.addProduct",productVO);
	}
	
	public List<ProductVO> selectCompanyOrder(StringVO stringVO) {
		System.out.println("==>product의 selectCompanyOrder 호출");
		return mybatis.selectList("product.selectCompanyOrder",stringVO);
	}
	
	public void updateProduct(ProductVO productVO) {
		System.out.println("==>product의 updateProduct 호출");
		mybatis.update("product.updateProduct",productVO);
	}
	
}
