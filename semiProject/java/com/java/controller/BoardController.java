package com.java.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.domain.BoardVO;
import com.java.domain.CustomerVO;
import com.java.domain.PagingVO;
import com.java.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@RequestMapping("faq.do")
	public String faq() {
		
		return "board/fAQ";
	}

	//================================================
	// 성연누나 시작
	// 후기 목록 가져오기
	@RequestMapping("postScript.do")
	public String postScript(BoardVO vo, Model m) {
		System.out.println("==> Controller postScript 메소드 호출해서 readReviewList 수행");
		m.addAttribute("readReviewList", boardService.readReviewList(vo));
		return "board/postScript";
	}

	// 후기 쓰기
	@RequestMapping(value = "/writeReview.do")
	public String writeReview(BoardVO vo, Model m) throws IOException{
		System.out.println("==> Controller writeReview 메소드 호출");
		boardService.writeReview(vo);
		m.addAttribute("readReviewList", boardService.readReviewList(vo));
		return "redirect:postScript.do";
	}
	
	// 특정 후기 읽기 (안함..)
	@RequestMapping("readReview.do")
	public void readReview(BoardVO vo, Model m) {
		System.out.println("==> Controller readReview 메소드 호출");
		m.addAttribute("readReviewList", boardService.readReview(vo));
	}
	
	// 특정 후기 수정
	@RequestMapping("modifyReview.do")
	public String modifyReview(BoardVO vo, Model m) {
		
		System.out.println(vo.getBoardID());
		System.out.println(vo.getBoardContent());
		boardService.modifyReview(vo);
		m.addAttribute("readReviewList", boardService.readReviewList(vo));
		return "board/postScript";
	}
	
	// 특정 후기 삭제
	@RequestMapping("deleteReview.do")
	public String deleteReview(BoardVO vo, Model m) {
		boardService.deleteReview(vo);
		m.addAttribute("readReviewList", boardService.readReviewList(vo));
		return "board/postScript";
	}
	
	// 특정 후기 좋아요
	@RequestMapping("likeThisReview.do")
	public String likeThisReview(BoardVO vo, Model m, String boardID) {
	System.out.println("likeThisReview.do 메소드 호출");
	System.out.println("보드아이디" + boardID);
	System.out.println("브이오쩜겟보드아이디" + vo.getBoardID());
	boardService.likeThisReview(boardID);
	m.addAttribute("readReviewList", boardService.readReviewList(vo));
	return "board/postScript";
	}
	
	// 성연누나 종료
	//================================================
    @RequestMapping("/freeBoard.do")
    public String getBoardList(BoardVO vo, Model m, PagingVO pagingVO) {
		String returnData = "error";
		
		PagingVO paging = new PagingVO();
		if(pagingVO != null) {
			paging.setPage(pagingVO.getPage());
		}
		paging.setTotalCount(boardService.totalRow());

		System.out.println(paging.getPage());
		
		List<BoardVO> list = boardService.selectAllBoard(paging);
		m.addAttribute("boardList",list);
		m.addAttribute("paging",paging);
		
		
		returnData = "board/freeBoard";
		
		return returnData;
    }
    
    // 내가 작성한 글 보러가기
    @RequestMapping("/myPageWrite.do")
    public String myPageWrite(BoardVO vo, Model m, PagingVO pagingVO, HttpSession session) {
		String returnData = "error";
		if(session.getAttribute("loginSession") != null) {
			CustomerVO loginSession = (CustomerVO) session.getAttribute("loginSession");
			
			PagingVO paging = new PagingVO();
			if(pagingVO != null) {
				paging.setPage(pagingVO.getPage());
			}
			String loginID = loginSession.getUserID();
			

			System.out.println("---------------------------");
			System.out.println(loginID);
			System.out.println("---------------------------");
			paging.setTotalCount(boardService.totalRowUser(loginID));
			paging.setUserID(loginID);
			System.out.println(paging.getPage());

			if(boardService.selectAllBoardUser(paging) != null) {
				List<BoardVO> list = boardService.selectAllBoardUser(paging);
				m.addAttribute("boardLength",list.size());
				m.addAttribute("boardList",list);
				m.addAttribute("paging",paging);
			}
			
			returnData = "mypage/myPageWrite";
		}
		

		
		return returnData;
    }

    // 글 등록
    @RequestMapping("/saveBoard.do") //단순 페이지 이동
    public String insertBoard(BoardVO vo, Model m) throws IOException {
          boardService.insertBoard(vo);
          m.addAttribute("boardList", boardService.getBoardList(vo));
          return "redirect:freeBoard.do"; 
          //  @RequestMapping("/getboardList.do") 이거를 찾아간다는 뜻이다 ->redirect:/getBoardList.do
    }

    // 글 수정
    @RequestMapping("/updateBoard.do")
    public String updateBoard(BoardVO vo,Model m) {
       boardService.updateBoard(vo);
       m.addAttribute("boardList", boardService.getBoardList(vo));
       return "redirect:freeBoard.do"; 
    }

    // 글 삭제
    @RequestMapping("/deleteBoard.do")
    public String deleteBoard(BoardVO vo,Model m) {
       boardService.deleteBoard(vo);
       m.addAttribute("boardList", boardService.getBoardList(vo));
       return "redirect:freeBoard.do"; 
    }

    // 글 상세 조회 & 조회수 증가
    @RequestMapping("/getBoard.do")
    public String getBoard(BoardVO vo, String boardID, Model m) throws Exception{
       m.addAttribute("boardView", boardService.getBoard(vo)); // Model 정보 저장
       m.addAttribute("boardView", boardService.updateCount(vo, boardID));
       return "board/getBoard";
    }
}
