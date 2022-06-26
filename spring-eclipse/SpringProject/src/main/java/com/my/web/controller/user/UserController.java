package com.my.web.controller.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.my.biz.user.UserDAOJDBC;
import com.my.biz.user.UserService;
import com.my.biz.user.UserVO;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	// 회원 가입 화면으로 이동
	@RequestMapping("/insertUserView.do")
	public String insertUserView() {
		return "insertUser";
	}

	// 회원 가입
	@RequestMapping("/insertUser.do")
	public String insertUser(UserVO vo, UserDAOJDBC userDAO) {
		userDAO.insertUser(vo);
		return "forward:/";
	}
	
	// 로그인 화면으로 이동
	@RequestMapping("/loginView.do")
	// 매개변수로 VO 객체를 받으면 자동으로 Model에 등록된다.
	public String loginView(@ModelAttribute("user") UserVO vo) {
		vo.setId("test");
		vo.setPassword("test");
		return "login";
	}
	
	// 로그인 
	@RequestMapping("/login.do")
	public String login(UserVO vo, HttpSession session) {
		UserVO user = userService.getUser(vo);
		if(user != null) {
			if(user.getPassword().equals(vo.getPassword())) {
				session.setAttribute("user", user);				
			}
		}
		return "forward:/index.jsp";
	}

	// 로그아웃	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "forward:/";
	}
}
