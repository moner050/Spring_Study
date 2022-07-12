package com.fastcampus.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fastcampus.auth.AuthenticateInterceptor;

@Configuration
public class BankWebMvcConfiguration implements WebMvcConfigurer{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 인터셉터를 등록한다.
		
		// 요청 url이 / 기 들어오면 무조건 인터셉터를 등록시켜라.
		registry.addInterceptor(new AuthenticateInterceptor()).addPathPatterns("/");
	}
	
}
