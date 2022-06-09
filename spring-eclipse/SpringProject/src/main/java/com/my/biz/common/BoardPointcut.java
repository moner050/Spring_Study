package com.my.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class BoardPointcut {
	
	@Pointcut("execution(* com.my.biz..*Impl.*(..))")
	public void allPointcut() {
		
	}
	@Pointcut("execution(* com.my.biz..*Impl.get*(..))")
	public void getPointcut() {
		
	}
	@Pointcut("execution(* com.my.biz.user.*Impl.get*(..))")
	public void userPointcut() {
		
	}
	@Pointcut("execution(* com.my.biz.board.*Impl.get*(..))")
	public void boardPointcut() {
		
	}

}
