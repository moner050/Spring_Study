package com.my.biz.user;

import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceClient {

	public static void main(String[] args) {
		// 1. 스프링 컨테이너 생성
		GenericXmlApplicationContext container = 
			new GenericXmlApplicationContext("business-layer.xml");
		
		// 2. 테스트 객체 Lookup
		UserService userService = (UserService) container.getBean("userService");

		// 3. Lookup한 객체의 메소드 테스트
		UserVO vo = new UserVO();
		vo.setId("aaa");
		vo.setPassword("aaa");
		UserVO user = userService.getUser(vo);
		if(user != null) {
			System.out.println(user.getName() + "님 환영합니다.");
		}
		
		// 4. 컨테이너 종료
		container.close();
	}

}
