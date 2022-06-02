package polymorphism;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser{

	public static void main(String[] args){

		// 1. 스프링 컨테이너를 생성(구동)한다.
		
		GenericXmlApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. 컨테이너로부터 TV 타입의 객체를 획득(lookup)한다
		TV tv = (TV) container.getBean("tv");
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		// 3. 스프링 컨테이너를 종료한다.
		container.close();
		
	}

}
