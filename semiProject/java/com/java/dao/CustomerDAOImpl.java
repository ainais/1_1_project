package com.java.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.domain.BoardVO;
import com.java.domain.CustomerVO;
import com.java.domain.LogVO;
import com.java.domain.ProductVO;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public CustomerVO loginSelect(CustomerVO customerVO) {
		System.out.println("==>customer의 selectUser 호출");
		return mybatis.selectOne("customer.selectUser",customerVO);
	}
	public CustomerVO customerDetail(CustomerVO customerVO) {
		System.out.println("==>customer의 customerDetail 호출");
		return mybatis.selectOne("customer.customerDetail",customerVO);
	}
	public CustomerVO ajaxLoginCheck(CustomerVO customerVO) {
		System.out.println("==>customer의 ajaxLoginCheck 호출");
		return mybatis.selectOne("customer.ajaxLoginCheck",customerVO);
	}
	
	
	public void insertCustomer(CustomerVO customerVO) {
		System.out.println("==>customer의 insertCustomer 호출");
		mybatis.selectOne("customer.insertCustomer",customerVO);
	}
	//===============================
	//로그인 로그 시작
	public void logInsert(LogVO logVO) {
		System.out.println("==>customer의 logInsert 호출");
		mybatis.insert("customer.logInsert",logVO);
	}
	//로그인 로그 종료
	//===============================
	
	//==========================================================
	//===============마이페이지 데이터 시작
	@Override
	public List<CustomerVO> selectCustomerList() {
	System.out.println("===> customer의 selectCustomerList() 호출");
	return mybatis.selectList("customer.selectCustomerList");
	}
	
	@Override
	public List<BoardVO> selectBestBoardList() {
	System.out.println("===> customer의 selectBestBoardList() 호출");
	return mybatis.selectList("customer.selectBestBoardList");
	}
	
	@Override
	public List<ProductVO> selectRecentBoardList() {
	System.out.println("===> customer의 selectRecentBoardList() 호출");
	return mybatis.selectList("customer.selectRecentBoardList");
	}
	@Override
	public List<CustomerVO> selectTodayCustomerList() {
	System.out.println("===> customer의 selectTodayCustomerList() 호출");
	return mybatis.selectList("customer.selectTodayCustomerList");
	}
	@Override
	public List<LogVO> selectAllLog() {
	System.out.println("===> customer의 selectAllLog() 호출");
	return mybatis.selectList("customer.selectAllLog");
	}
	
    //===============마이페이지 데이터 종료
    //==========================================================
	//회원 목록 
	@Override
	public List<CustomerVO> getCustomerList(CustomerVO customerVO) {
	System.out.println("===> customer의 getCustomerList() 호출");
	return mybatis.selectList("customer.getCustomerList", customerVO);
	}
	
	//회원 정보 수정
	@Override
	public void updateCustomer(CustomerVO customerVO) {
		System.out.println("==>customer의 updateCustomer 호출");
		mybatis.update("customer.updateCustomer",customerVO);
	}
	//회원 탈퇴 
	@Override
	public void deleteCustomer2(CustomerVO customerVO) {
	System.out.println("==>customer의 deleteCustomer2 호출");    
    mybatis.delete("customer.deleteCustomer2",customerVO);
	}
	
	// 마이페이지 -> 내 정보 관리 -> 회원정보수정
	public void modifyCustomer(CustomerVO vo) {
		System.out.println("==> customer의 modifyCustomer 호출");
		mybatis.update("customer.modifyCustomer", vo);
	}
	
	// 마이페이지 -> 내 정보 관리 -> 회원탈퇴
	public void deleteCustomer(CustomerVO vo) {
		System.out.println("==> customer의 deleteCustomer 호출");
		mybatis.delete("customer.deleteCustomer", vo);
	}
	
	// 마이페이지 -> 구독정보보기 -> 구독취소
	public void cancleSUB(CustomerVO vo) {
		System.out.println("==> customer의 cancleSUB 호출");
		mybatis.update("customer.cancleSUB", vo);
	}
	// 마이페이지 -> 내 정보 관리 -> 회원정보수정 -> 비밀번호 일치 여부 확인
	public boolean checkPW(CustomerVO vo) {
		boolean result = false;
		int cnt = mybatis.selectOne("customer.checkPW", vo);
		if(cnt==1) {
			result = true;
		}
		return result;
	}
}
