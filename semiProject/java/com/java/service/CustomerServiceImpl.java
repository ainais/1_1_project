package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.CustomerDAO;
import com.java.dao.CustomerDAOImpl;
import com.java.domain.BoardVO;
import com.java.domain.CustomerVO;
import com.java.domain.LogVO;
import com.java.domain.ProductVO;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAOImpl customerDAO;
	
	@Override
	public CustomerVO loginSelect(CustomerVO customerVO) {
		return customerDAO.loginSelect(customerVO);
	}
	
	@Override
	public CustomerVO customerDetail(CustomerVO customerVO) {
		return customerDAO.customerDetail(customerVO);
	}
	
	public CustomerVO ajaxLoginCheck(CustomerVO customerVO) {
		return customerDAO.ajaxLoginCheck(customerVO);
	}
	
	public void insertCustomer(CustomerVO customerVO) {
		customerDAO.insertCustomer(customerVO);
	}
	
	//===============================
	//로그인 로그 시작
	public void logInsert(LogVO logVO) {
		customerDAO.logInsert(logVO);
	}
	//로그인 로그 종료
	//===============================
	
	//==========================================================
	//===============마이페이지 데이터 시작
	//회원 목록
    @Override
    public List<CustomerVO> selectCustomerList() {
	return customerDAO.selectCustomerList();
	
    }
    //베스트 후기
    @Override
    public List<BoardVO> selectBestBoardList() {
	return customerDAO.selectBestBoardList();
	
    }
    //최근 물품
    @Override
    public List<ProductVO> selectRecentBoardList() {
	return customerDAO.selectRecentBoardList();
    }
    @Override
    public List<CustomerVO> selectTodayCustomerList() {
	return customerDAO.selectTodayCustomerList();
    }
    @Override
    public List<LogVO> selectAllLog() {
	return customerDAO.selectAllLog();
    }
    
    //===============마이페이지 데이터 종료
    //==========================================================
    
	// 마이페이지 -> 내 정보 관리 -> 회원탈퇴
	public void deleteCustomer2(CustomerVO vo) {
		customerDAO.deleteCustomer2(vo);
	}
	
	//회원 목록
    @Override
    public List<CustomerVO> getCustomerList(CustomerVO customerVO) {
	return customerDAO.getCustomerList(customerVO);
	
    }
	//회원 정보 수정
    @Override
	public void updateCustomer(CustomerVO customerVO) {
    customerDAO.updateCustomer(customerVO);
	}
    
	// 마이페이지 -> 내 정보 관리 -> 회원정보수정
	public void modifyCustomer(CustomerVO vo) {
		customerDAO.modifyCustomer(vo);
	}
	
	// 마이페이지 -> 내 정보 관리 -> 회원탈퇴
	public void deleteCustomer(CustomerVO vo) {
		customerDAO.deleteCustomer(vo);
	}
	
	// 마이페이지 -> 구독정보보기 -> 구독취소
	public void cancleSUB(CustomerVO vo) {
		customerDAO.cancleSUB(vo);
	}
	
	// 마이페이지 -> 내 정보 관리 -> 회원정보수정 -> 비밀번호 일치 여부 확인
	public boolean checkPW(CustomerVO vo) {
		return customerDAO.checkPW(vo);
	}
}
