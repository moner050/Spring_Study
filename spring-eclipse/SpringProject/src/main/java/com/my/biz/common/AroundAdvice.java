package com.my.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class AroundAdvice{

	@Around("BoardPointcut.allPointcut()")
	public Object AroundLog(ProceedingJoinPoint jp) throws Throwable{
		
		
		String method = jp.getSignature().getName();
		Object returnObj = null;
		
		StopWatch watch = new StopWatch();
		watch.start();
		
		System.out.println("---[Before Logic]---");
		
		returnObj = jp.proceed();
		watch.stop();
		
		System.out.println(method + "비즈니스 메소드 수행에 소요된 시간 : " + watch.getTotalTimeSeconds() + "(ms)초");
		System.out.println("---[After Logic]---");
		
		return returnObj;
	}
}
