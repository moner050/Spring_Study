package com.my.biz.common;

import java.sql.SQLException;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterThrowingAdvice {

	@AfterThrowing(pointcut = "BoardPointcut.allPointcut()", throwing = "exceptObj")
	public void exceptionLog(JoinPoint jp, Exception exceptObj) {
		String method = jp.getSignature().getName();
		System.out.println("[예외 처리] " + method + "() 메소드 수행 중 예외 발생");
		
		// 발생된 예외 객체의 종류에 따른 로직 분기 처리
		if(exceptObj instanceof IllegalArgumentException) {
			System.out.println("0번 글을 등록할 수는 없어요.");
		} else if(exceptObj instanceof ArithmeticException) {
			System.out.println("0으로 숫자를 나눌 수는 없습니다.");
		} else if(exceptObj instanceof SQLException) {
			System.out.println("SQL 구문에 문법 오류가 있습니다.");
		} else {
			System.out.println("문제 발생.");
		}
	}
}
