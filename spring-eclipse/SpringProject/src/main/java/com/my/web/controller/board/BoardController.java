package com.my.web.controller.board;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.my.biz.board.BoardDAOJDBC;
import com.my.biz.board.BoardVO;

@Controller
public class BoardController {

	// 글 등록 화면으로 이동
	@RequestMapping("insertBoardView.do")
	public String insertBoardView() {
		return "insertBoard";
	}
	
	// 글 등록
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAOJDBC boardDAO) {
		boardDAO.insertBoard(vo);
		// 뷰이름을 리턴한다.
		return "forward:getBoardList.do";
	}
	
	// 글 수정
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAOJDBC boardDAO) {
		boardDAO.updateBoard(vo);
		return "forward:getBoardList.do";
	}
	
	// 글 삭제
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAOJDBC boardDAO) {
		System.out.println("글 삭제 기능 처리");
		boardDAO.deleteBoard(vo);
		return "forward:getBoardList.do";
	}
	
	// 글 상세 조회
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, BoardDAOJDBC boardDAO, Model model) {
		System.out.println("글 상세 조회 기능 처리");
		// 3. 화면 이동
		// 검색 결과를 request에 등록하고 getBoardList.jsp로 이동(forwarding)한다. 
		model.addAttribute("board", boardDAO.getBoard(vo));
		return "getBoard";
	}
	
	// 글 목록 검색
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, BoardDAOJDBC boardDAO, Model model) {
		System.out.println("글 목록 검색 기능 처리");
		// Null Check
		if(vo.getSearchCondition() == null) vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword() == null) vo.setSearchKeyword("");
		
		model.addAttribute("condition", vo.getSearchCondition());
		model.addAttribute("keyword", vo.getSearchKeyword());

		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		
		// 3. 화면 이동
		// 검색 결과와 화면정보를 ModelAndView에 저장하여 리턴한다.
		// ModelAndView에 저장된 검색 결과는 자동으로 request에 등록된다.
		model.addAttribute("boardList", boardList);				
		model.addAttribute("searchCount", boardList.size());		
		return "getBoardList";
		
	}
	
}
