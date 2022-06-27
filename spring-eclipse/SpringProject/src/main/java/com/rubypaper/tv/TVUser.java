package com.rubypaper.tv;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		// 1. 스프링 컨테이너를 생성(구동)한다. 
		AnnotationConfigApplicationContext container = 
			new AnnotationConfigApplicationContext(TVConfiguration.class);
		
		// 2. 스프링 컨테이너로부터 id가 "tv"인 TV 타입의 객체를 획득(Lookup)한다.		
		TV tv = (TV) container.getBean("tv");
		tv.powerOn();
		tv.volumeDown();
		tv.volumeUp();
		tv.powerOff();
		
		// 3. 스프링 컨테이너를 종료한다. 
		container.close();
	}

}
