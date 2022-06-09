package com.my.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service		// Bean 등록을 대체한다.
@Aspect			// Aspect = Pointcut + Advice
public class LogAdvice {
	
	@Before("BoardPointcut.allPointcut()")
	public void printLog(JoinPoint jp) {
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		
		if(args.length != 0) {
			System.out.println("<사전 처리> " + method + "() 메소드 Args 정보 : " + args[0].toString());
		}
		else {
			System.out.println("<사전 처리> " + method + "() 메소드");
		}
	}
}
