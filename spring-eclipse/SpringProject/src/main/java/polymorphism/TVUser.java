package polymorphism;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {

		// 스프링 컨테이너를 생성(구동)한다.
		new GenericXmlApplicationContext("applicationContext.xml");
		
		// 컨테이너로부터 TV 타입의 객체를 받아온다.
//		TV tv = (TV) TVContainer.getBean(args[0]);
//		tv.powerOn();
//		tv.volumeUp();
//		tv.volumeDown();
//		tv.powerOff();
		
		
	}

}
