package com.my.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;
							
@Service
@Aspect
public class AroundAdvice {

	@Around("BoardPointcut.allPointcut()")
	public Object aroudLog(ProceedingJoinPoint jp) throws Throwable {
		String method = jp.getSignature().getName();
		Object returnObj = null;
		
		StopWatch watch = new StopWatch();
		watch.start(); // 스탑워치 시작
		
		returnObj = jp.proceed();
		
		watch.stop(); // 스탑워치 종료
		
		System.out.println(method + "() 메소드 수행에 소요된 시간 : " + watch.getTotalTimeSeconds() + "(ms)초");
		
		return returnObj;
	}
}
