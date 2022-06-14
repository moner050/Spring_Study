package com.my.web.controller.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.my.biz.board.BoardDAO;
import com.my.biz.board.BoardDAOJDBC;
import com.my.biz.board.BoardVO;

public class GetBoardListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 목록 검색 기능 처리");
		
		// 1. 사용자 입력정보 추출
		String searchCondition = request.getParameter("searchCondition");
		String searchKeyword = request.getParameter("searchKeyword");

		// Null Check
		if(searchCondition == null) searchCondition = "TITLE";
		if(searchKeyword == null) searchKeyword = "";
		
		request.setAttribute("condition", searchCondition);
		request.setAttribute("keyword", searchKeyword);

		// 2. DB 연동 처리
		BoardVO vo = new BoardVO();
		vo.setSearchCondition(searchCondition);
		vo.setSearchKeyword(searchKeyword);
		
		BoardDAO dao = new BoardDAOJDBC();
		List<BoardVO> boardList = dao.getBoardList(vo);
		
		// 3. 화면 이동
		// 검색 결과와 화면정보를 ModelAndView에 저장하여 리턴한다.
		// ModelAndView에 저장된 검색 결과는 자동으로 request에 등록된다.
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardList", boardList);				// Model정보
		mav.setViewName("/WEB-INF/board/getBoardList.jsp");	// View 정보
		return mav;	
		
	}

}
