package com.my.web.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.my.biz.board.BoardDAO;
import com.my.biz.board.BoardDAOJDBC;
import com.my.biz.board.BoardVO;

public class GetBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 상세 조회 기능 처리");
		
		// 1. 사용자 입력정보 추출
		String seq = request.getParameter("seq");
		
		// 2. DB 연동 처리
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		
		BoardDAO boardDAO = new BoardDAOJDBC();
		BoardVO board = boardDAO.getBoard(vo);
		
		
		// 3. 화면 이동
		// 검색 결과를 request에 등록하고 getBoardList.jsp로 이동(forwarding)한다. 
		ModelAndView mav = new ModelAndView();
		request.setAttribute("board", board);
		
		mav.setViewName("/WEB-INF/board/getBoard.jsp");
		return mav;
	}

}
