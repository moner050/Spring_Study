package com.my.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import com.my.biz.user.UserVO;


@Service
@Aspect
public class AfterReturningAdvice {

	@AfterReturning(pointcut = "BoardPointcut.getPointcut()", returning = "returnObj")
	public void afterLog(JoinPoint jp, Object returnObj) {
		String method = jp.getSignature().getName();
		System.out.println("<사후 처리> " + method +" 메소드가 리턴한 값 : " + returnObj.toString());
		
		// 비즈니스 메소드가 리턴한 데이터를 이용해서 관리자가 로그인했는지 여부를 확인한다.
		if(returnObj instanceof UserVO) {
			UserVO user = (UserVO) returnObj;
			
			if(user.getRole().equals("Admin")) {
				System.out.println(user.getName() + " 관리자님 환영합니다.");
			}
		}
	}
}
