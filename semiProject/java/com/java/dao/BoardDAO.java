package com.java.dao;

import java.util.List;

import com.java.domain.BoardVO;
import com.java.domain.PagingVO;


public interface BoardDAO {
	public int totalRow();
	public int totalRowUser(String loginID);
	
	public List<BoardVO> selectAllBoard(PagingVO pagingVO);
	public List<BoardVO> selectAllBoardUser(PagingVO pagingVO);
   //입력하기
   public void insertBoard(BoardVO vo);
   
   //수정하기
   public void updateBoard(BoardVO vo) ;
   
   //삭제하기
   public void deleteBoard(BoardVO vo);
   
   //글상세조회
   public BoardVO getBoard(BoardVO vo) ;
   
   //글목록조회
   public List<BoardVO> getBoardList(BoardVO vo) ;
   
   //조회수 증가
   public void updateCount(String boardID) throws Exception;
   
   public void writeReview(BoardVO vo);
   
   public List<BoardVO> readReviewList(BoardVO vo);
   
   public BoardVO readReview(BoardVO vo);
   
   public void deleteReview(BoardVO vo);
   
   public void modifyReview(BoardVO vo);
   
   public void likeThisReview(String boardID);
}