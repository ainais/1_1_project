package com.javassem.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javassem.domain.BoardVO;
import com.javassem.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/getBoardList.do")
	public void getBoardList(Model m) {
		m.addAttribute("boardList",boardService.getBoardList());
		//boardService.getBoardList();
	}
	
	@RequestMapping("/insertBoard.do")
	public void insertBoard() {
	}
	
	@RequestMapping("/saveBoard.do")
	public void saveBoard(BoardVO vo) {
		boardService.insertBoard(vo);
	}
	/*
	 
	@RequestMapping("/getBoard.do")
	public void getBoard(Model m, BoardVO vo, int seq) {
		System.out.println(vo.getSeq());
		System.out.println(seq);
	}
	 
	 */
	@RequestMapping("/getBoard.do")
	public void getBoard(Model m, BoardVO vo) {
		m.addAttribute("board",boardService.getBoard(vo));
	}
	
	@RequestMapping("/deleteBoard.do")
	public void deleteBoard(BoardVO vo) {
		boardService.deleteBoard(vo);
	}
	
	@RequestMapping("/updateBoard.do")
	public void updateBoard(BoardVO vo) {
		boardService.updateBoard(vo);
	}
}
