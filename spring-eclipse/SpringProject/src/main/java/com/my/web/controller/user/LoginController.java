package com.my.web.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.my.biz.user.UserDAO;
import com.my.biz.user.UserDAOJDBC;
import com.my.biz.user.UserVO;


public class LoginController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
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
		ModelAndView mav = new ModelAndView();
		if(user != null) {
			if(user.getPassword().equals(password)) {
				// 상태 정보를 세션에 저장한다. 
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				
				// 글 목록 화면으로 이동한다.
				mav.setViewName("/index.jsp");
			} 
			else mav.setViewName("/index.jsp");
		} 
		else mav.setViewName("/index.jsp");
		
		return mav;
	}
}
