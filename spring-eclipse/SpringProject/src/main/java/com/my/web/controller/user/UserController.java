package com.my.web.controller.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.my.biz.user.UserDAOJDBC;
import com.my.biz.user.UserVO;

@Controller
public class UserController {

	// 회원가입 화면으로 이동
	@RequestMapping("/insertUserView.do")
	public String insertUserView() {
		return "insertUser";
	}

	// 회원가입
	@RequestMapping("/insertUser.do")
	public String insertUser(UserVO vo, UserDAOJDBC userDAO) {
		userDAO.insertUser(vo);
		return "redirect:/";
	}

	// 로그인 화면으로 이동
	@RequestMapping("loginView.do")
	// 매개변수로 VO 객체를 받으면 자동으로 Model에 저장된다.
	public String loginView(@ModelAttribute("user") UserVO vo) {
		vo.setId("test");
		vo.setPassword("test");
		return "login";
	}
	
	// 로그인
	@RequestMapping("/login.do")
	public String login(UserVO vo, UserDAOJDBC userDAO, HttpSession session) {
		System.out.println("로그인 기능 처리");
		UserVO user = userDAO.getUser(vo);
		// 3. 화면 이동
		if(user != null) {
			if(user.getPassword().equals(vo.getPassword())) {
				// 상태 정보를 세션에 저장한다. 
				session.setAttribute("user", user);
			} 
		} 
		return "forward:/index.jsp";
	}
	
	// 로그아웃
	@RequestMapping("logout.do")
	public String logout(HttpSession session) {
		System.out.println("로그아웃 기능 처리");
		session.invalidate();
		
		return "redirect:/";
	}

}
