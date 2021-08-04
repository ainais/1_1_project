package com.java.service;

import java.util.List;

import com.java.domain.BoardVO;
import com.java.domain.PagingVO;

public interface BoardService {
   // CRUD 기능의 메소드 구현
	public int totalRow();
	public int totalRowUser(String loginID);
	public List<BoardVO> selectAllBoard(PagingVO pagingVO);
	public List<BoardVO> selectAllBoardUser(PagingVO pagingVO);
	
   // 글 등록
   public void insertBoard(BoardVO vo);

   // 글 수정
   public void updateBoard(BoardVO vo);

   // 글 삭제
   public void deleteBoard(BoardVO vo);

   // 글 상세 조회
   public BoardVO getBoard(BoardVO vo);

   // 글 목록 조회
   public List<BoardVO> getBoardList(BoardVO vo);
   
   // 조회수 증가
   public BoardVO updateCount(BoardVO vo, String boardID) throws Exception;
   
   public void likeThisReview(String boardID);
   
   public void writeReview(BoardVO vo);
   
   public List<BoardVO> readReviewList(BoardVO vo);
   
   public BoardVO readReview(BoardVO vo);
   
   public void deleteReview(BoardVO vo);
   
   public void modifyReview(BoardVO vo);
}