package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.BoardDAOImpl;
import com.java.domain.BoardVO;
import com.java.domain.PagingVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

   @Autowired
   private BoardDAOImpl boardDAO;
   
   public int totalRow() {
	      return boardDAO.totalRow();
	   }
   
   public int totalRowUser(String loginID) {
      return boardDAO.totalRowUser(loginID);
   }
   
   public List<BoardVO> selectAllBoard(PagingVO pagingVO) {
	      return boardDAO.selectAllBoard(pagingVO);
	   }
   
   public List<BoardVO> selectAllBoardUser(PagingVO pagingVO) {
	      return boardDAO.selectAllBoardUser(pagingVO);
	   }
   
   //입력
   public void insertBoard(BoardVO vo) {
      boardDAO.insertBoard(vo);
   }
   //수정
   public void updateBoard(BoardVO vo) {
      boardDAO.updateBoard(vo);
   }
   //삭제
   public void deleteBoard(BoardVO vo) {
      boardDAO.deleteBoard(vo);
   }
   //글상세조회
   public BoardVO getBoard(BoardVO vo) {
      return boardDAO.getBoard(vo);
   }
   //리스트
   public List<BoardVO> getBoardList(BoardVO vo) {
      return boardDAO.getBoardList(vo);
   }
	// 특정 후기 좋아요
	@Override
	public void likeThisReview(String boardID) {
		boardDAO.likeThisReview(boardID);
	}
   
   //조회수 증가
     @Override 
     public BoardVO updateCount(BoardVO vo, String boardID) throws Exception{
        boardDAO.updateCount(boardID);
        return boardDAO.getBoard(vo); 
     }
     
 	// 후기 쓰기
 	@Override
 	public void writeReview(BoardVO vo) {
 		boardDAO.writeReview(vo);
 	}
 	
 	// 후기 목록 가져오기
 	@Override
 	public List<BoardVO> readReviewList(BoardVO vo){
 		return boardDAO.readReviewList(vo);
 	}
 	
 	// 특정 후기 읽기 (안함..)
 	@Override
 	public BoardVO readReview(BoardVO vo) {
 		return boardDAO.readReview(vo);
 	}	
 	
 	// 특정 후기 삭제
 	@Override
 	public void deleteReview(BoardVO vo) {
 		boardDAO.deleteReview(vo);
 	}
 	
 	// 특정 후기 수정
 	@Override
 	public void modifyReview(BoardVO vo) {
 		boardDAO.modifyReview(vo);
 	}
    

}