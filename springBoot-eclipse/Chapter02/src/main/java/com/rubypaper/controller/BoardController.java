package com.rubypaper.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rubypaper.domain.BoardVO;

@RestController
public class BoardController {

	public BoardController(){
		System.out.println("==> BoardController 생성");
	}
	
	@RequestMapping("/hello.do")
	public String hello(String name) {
		System.out.println("---> hello() 실행");
		return "Hello : " + name;
	}
	
	@RequestMapping("/getBoard.do")
	public BoardVO getBoard() {
		BoardVO board = new BoardVO();
		board.setSeq(1);
		board.setTitle("테스트 제목");	
		board.setWriter("테스터");
		board.setContent("테스트 내용");
		board.setCreateDate(new Date());
		return board;
	}
	
	@RequestMapping("/getBoardList.do")
	public List<BoardVO> getBoardList() {
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		for(int i = 1; i <= 10; i++) {
			BoardVO board = new BoardVO();
			board.setSeq(i);
			board.setTitle("테스트 제목" + i);	
			board.setWriter("테스터");
			board.setContent("테스트 내용" + i);
			board.setCreateDate(new Date());
			boardList.add(board);
		}
		return boardList;

	}
}
