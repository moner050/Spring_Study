package com.my.web.controller.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.my.biz.board.BoardService;
import com.my.biz.board.BoardVO;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	// 글 등록 화면으로 이동
	@RequestMapping("/insertBoardView.do")
	public String insertBoardView() {
		return "insertBoard";
	}
	
	// 글 등록
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo) {
		boardService.insertBoard(vo);
		return "forward:getBoardList.do";
	}
	
	// 글 수정
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo) {
		boardService.updateBoard(vo);
		return "forward:getBoardList.do";
	}	
	
	// 글 삭제
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		boardService.deleteBoard(vo);
		return "forward:getBoardList.do";
	}	
	
	// 글 상세 조회
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
		model.addAttribute("board", boardService.getBoard(vo));  // Model 정보
		return "getBoard";  // View 이름 리턴
	}
	
	// 글 목록 검색
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) {
		if(vo.getSearchCondition() == null) vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword() == null) vo.setSearchKeyword("");
		
		model.addAttribute("condition", vo.getSearchCondition());
		model.addAttribute("keyword", vo.getSearchKeyword());

		List<BoardVO> boardList = boardService.getBoardList(vo);
		model.addAttribute("boardList", boardList);              // Model 정보1
		model.addAttribute("searchCount", boardList.size());     // Model 정보2
		return "getBoardList"; // View 이름 리턴
	}
}
