package com.my.web.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.my.biz.user.UserDAO;
import com.my.biz.user.UserDAOJDBC;
import com.my.biz.user.UserVO;

public class InsertUserController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
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
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/");
		return mav;
	}

}
