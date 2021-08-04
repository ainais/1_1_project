package com.java.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.domain.BoardVO;
import com.java.domain.PagingVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

   @Autowired
   private SqlSessionTemplate mybatis;
   

   public int totalRow() {
	      System.out.println("===> Mybatis totalRow() 호출");
	      return mybatis.selectOne("board.totalRow");
	   }
   
   public int totalRowUser(String loginID) {
	      System.out.println("===> Mybatis totalRowUser() 호출");
	      return mybatis.selectOne("board.totalRowUser",loginID);
	   }
   
   
   public List<BoardVO> selectAllBoard(PagingVO pagingVO) {
	      System.out.println("===> Mybatis selectAllBoard() 호출");
	      return mybatis.selectList("board.selectAllBoard", pagingVO);
	   }
   public List<BoardVO> selectAllBoardUser(PagingVO pagingVO) {
	      System.out.println("===> Mybatis selectAllBoardUser() 호출");
	      return mybatis.selectList("board.selectAllBoardUser", pagingVO);
	   }
   
   public void insertBoard(BoardVO vo) {
      System.out.println("===> Mybatis insertBoard() 호출");
      mybatis.insert("board.insertBoard", vo);
      // mybatis namespace
   }

   public void updateBoard(BoardVO vo) {
      System.out.println("===> Mybatis updateBoard() 호출");
      mybatis.update("board.updateBoard", vo);
   }

   public void deleteBoard(BoardVO vo) {
      System.out.println("===> Mybatis deleteBoard() 호출");
      mybatis.delete("board.deleteBoard", vo);
   }

   public BoardVO getBoard(BoardVO vo) {
      //public BoardVO getBoard(String boardID) {
      System.out.println("===> Mybatis getBoard() 호출");
      return mybatis.selectOne("board.getBoard", vo);
   }

   public List<BoardVO> getBoardList(BoardVO vo) {
      System.out.println("===> Mybatis getBoardList() 호출");
      return mybatis.selectList("board.getBoardList", vo);
   }

   public void updateCount(String boardID) throws Exception {
      System.out.println("===> Mybatis updateCount() 호출");
      mybatis.update("board.updateCount", boardID);
   }

	// 후기 쓰기
	@Override
	public void writeReview(BoardVO vo) {
		System.out.println("==> mybatis writeReview 호출");
		mybatis.insert("board.writeReview", vo);
	}
	
	// 후기 목록 가져오기
	@Override
	public List<BoardVO> readReviewList(BoardVO vo) {
		System.out.println("==> mybatis readReviewList 호출");
		return mybatis.selectList("board.readReviewList", vo);
	}
	
	// 특정 후기 읽기 (안함..)
	@Override
	public BoardVO readReview(BoardVO vo) {
		System.out.println("==> mybatis readReview 호출");
		return mybatis.selectOne("board.readReview", vo);
	}
	
	// 특정 후기 삭제
	@Override
	public void deleteReview(BoardVO vo) {
		System.out.println("==> mybatis deleteReview 호출");
		mybatis.delete("board.deleteReview", vo);
	}
	
	// 특정 후기 수정
	@Override
	public void modifyReview(BoardVO vo) {
		System.out.println("==> mybatis modifyReview 호출");
		mybatis.update("board.modifyReview", vo);
	}
	
	// 특정 후기 좋아요
	public void likeThisReview(String boardID) {
		System.out.println("==> mybatis likeThisReview 호출");
		mybatis.update("board.likeThisReview", boardID);
	}

}