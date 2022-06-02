package com.my.biz.user;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;


public class UserServiceClient {

	public static void main(String[] args) {

		// 1. 스프링 컨테이너 생성
		GenericXmlApplicationContext container = new GenericXmlApplicationContext("user-layer.xml");
		
		// 2. 테스트 객체 Lookup
		UserService userService = (UserService) container.getBean("userService");
		if(userService != null) System.out.println("Lookup 성공 : " + userService.toString());
		
		// 3. Lookup 한 객체의 메소드 테스트
		List<UserVO> userList = userService.getUserList();
		for(UserVO user : userList)
		{
			System.out.println("--->" + user.toString());
		}
		
		UserVO vo = new UserVO();
		vo.setId("test");
		vo.setPassword("test");
		UserVO user = userService.getUser(vo);
		if(user != null) System.out.println(user.getName() + " 님 환영합니다.");
		
		// 4. 컨테이너 종료
		container.close();
		
		
	}

}
