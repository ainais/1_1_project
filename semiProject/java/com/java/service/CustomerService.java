package com.java.service;

import java.util.List;

import com.java.domain.BoardVO;
import com.java.domain.CustomerVO;
import com.java.domain.LogVO;
import com.java.domain.ProductVO;

public interface CustomerService {

	public CustomerVO loginSelect(CustomerVO customerVO);
	public CustomerVO ajaxLoginCheck(CustomerVO customerVO);
	public void insertCustomer(CustomerVO customerVO);
	public List<CustomerVO> getCustomerList(CustomerVO customerVO);
	public CustomerVO customerDetail(CustomerVO customerVO);
	public void modifyCustomer(CustomerVO vo);
	public void deleteCustomer(CustomerVO vo);
	public void cancleSUB(CustomerVO vo);
	public boolean checkPW(CustomerVO vo);
	public void updateCustomer(CustomerVO customerVO);
	public void deleteCustomer2(CustomerVO vo);
	public List<CustomerVO> selectCustomerList();
	public List<BoardVO> selectBestBoardList();
	public List<ProductVO> selectRecentBoardList();
	public List<CustomerVO> selectTodayCustomerList();
	public void logInsert(LogVO logVO);
	public List<LogVO> selectAllLog();
}
