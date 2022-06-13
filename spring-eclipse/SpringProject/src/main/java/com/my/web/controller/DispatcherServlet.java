package com.my.web.controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.my.biz.board.BoardDAO;
import com.my.biz.board.BoardDAOJDBC;
import com.my.biz.board.BoardVO;
import com.my.biz.user.UserDAO;
import com.my.biz.user.UserDAOJDBC;
import com.my.biz.user.UserVO;

//@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public DispatcherServlet() {
		System.out.println("===> DispatcherServlet 생성");
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		
		// 사용자 요청 path 정보를 추출한다. 
		String uri = request.getRequestURI();
		
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println("요청 path : " + path);
		
		// 추출한 path 정보에 따라서 요청을 분기처리한다. 
		if(path.equals("/login.do")) {
			System.out.println("로그인 기능 처리");
			
			// 1. 사용자 입력정보 추출
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			
			// 2. DB 연동 처리
			UserVO vo = new UserVO();
			vo.setId(id);
			
			UserDAO dao = new UserDAOJDBC();
			UserVO user = dao.getUser(vo);
			
			// 3. 화면 이동
			if(user != null) {
				if(user.getPassword().equals(password)) {
					// 상태 정보를 세션에 저장한다. 
					HttpSession session = request.getSession();
					session.setAttribute("user", user);
					
					// 글 목록 화면으로 이동한다.
					response.sendRedirect("/index.jsp");
				} else {
					response.sendRedirect("/index.jsp");
				}
			} else {
				response.sendRedirect("/index.jsp");
			}
			
		} else if(path.equals("/logout.do")) {
			System.out.println("로그아웃 기능 처리");
			
			HttpSession session = request.getSession();
			session.invalidate();

			response.sendRedirect("/");
			
		} else if(path.equals("/insertUser.do")) {
			System.out.println("회원 등록 기능 처리");
			
			// 1. 사용자 입력정보 추출
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			String name = request.getParameter("name");
			String role = request.getParameter("role");
				
			// 2. DB 연동 처리
			UserVO vo = new UserVO();
			vo.setId(id);
			vo.setPassword(password);
			vo.setName(name);
			vo.setRole(role);
			
			UserDAO dao = new UserDAOJDBC();
			dao.insertUser(vo);
			
			// 3. 화면 이동			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/");
			dispatcher.forward(request, response);			
			
		} else if(path.equals("/insertBoard.do")) {
			System.out.println("글 등록 기능 처리");
			
			// 1. 사용자 입력정보 추출
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
			
			// 2. DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);
			
			BoardDAO boardDAO = new BoardDAOJDBC();
			boardDAO.insertBoard(vo);
			
			// 3. 페이지 네비게이션
			RequestDispatcher dispatcher = request.getRequestDispatcher("getBoardList.do");
			dispatcher.forward(request, response);
			
		} else if(path.equals("/updateBoard.do")) {
			System.out.println("글 수정 기능 처리");
			
			// 1. 사용자 입력정보 추출
			String title = request.getParameter("title");
			String seq = request.getParameter("seq");
			String content = request.getParameter("content");
			
			// 2. DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setSeq(Integer.parseInt(seq));
			vo.setContent(content);
			
			BoardDAO boardDAO = new BoardDAOJDBC();
			boardDAO.updateBoard(vo);
			
			// 3. 페이지 네비게이션
			RequestDispatcher dispatcher = request.getRequestDispatcher("getBoardList.do");
			dispatcher.forward(request, response);
			
		} else if(path.equals("/deleteBoard.do")) {
			System.out.println("글 삭제 기능 처리");
			
			// 1. 사용자 입력정보 추출
			String seq = request.getParameter("seq");
			
			// 2. DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAO boardDAO = new BoardDAOJDBC();
			boardDAO.deleteBoard(vo);
			
			// 3. 페이지 네비게이션
			RequestDispatcher dispatcher = request.getRequestDispatcher("/getBoardList.do");
			dispatcher.forward(request, response);
			
		} else if(path.equals("/getBoard.do")) {
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
			request.setAttribute("board", board);
			RequestDispatcher dispatcher = request.getRequestDispatcher("getBoard.jsp");
			dispatcher.forward(request, response);
			
		} else if(path.equals("/getBoardList.do")) {
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
			// 검색 결과를 request 객체에 등록하고 글 목록 화면(getBoardList.jsp)으로 이동(forwarding)한다. 
			request.setAttribute("boardList", boardList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("getBoardList.jsp");
			dispatcher.forward(request, response);
			
		} else {
			System.out.println("요청 URL이 잘못되었습니다.");
		}
	}
}
