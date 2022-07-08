package com.rubypaper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan
public class Chapter02Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter02Application.class, args);
//		SpringApplication application = new SpringApplication(Chapter02Application.class);
		// 이 어플리케이션을 WEB이 아닌 일반 JAVA Application으로 실행하겠다.
//		application.setWebApplicationType(WebApplicationType.NONE);
	}

}
