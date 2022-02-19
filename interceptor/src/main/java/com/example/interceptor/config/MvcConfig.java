package com.example.interceptor.config;

import com.example.interceptor.interceptor.AuthInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor    // final 로 선언된 객체들을 생성자에서 주입받을수 있음.
public class MvcConfig implements WebMvcConfigurer {

    private final AuthInterceptor authInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 특정 url 을 빼고싶을때
       registry.addInterceptor(authInterceptor).addPathPatterns("/api/private/*");
    }
}
