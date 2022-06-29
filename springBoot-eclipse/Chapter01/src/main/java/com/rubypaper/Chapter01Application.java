package com.rubypaper;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.rubypaper", "com.test"})
public class Chapter01Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter01Application.class, args);
		
		// 일반 자바 어플리케이션으로 실행하기 = WebApplicationType.NONE
//		SpringApplication application = new SpringApplication(Chapter01Application.class);
//		application.setWebApplicationType(WebApplicationType.SERVLET);
//		
//		application.setBannerMode(Banner.Mode.OFF);
//		application.run(args);
//		
	}

}
