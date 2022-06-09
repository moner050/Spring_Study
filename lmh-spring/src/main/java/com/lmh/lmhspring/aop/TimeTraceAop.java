package com.lmh.lmhspring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

// AOP 는 Aspect 를 적어줘야 한다.
@Aspect
@Component
public class TimeTraceAop {

  // 어디에 적용을 할 지 설정(패키지 하위에 전부 다 적용시켜줬음.)
  @Around("execution(* com.lmh.lmhspring..*(..))")
  public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{

    long start = System.currentTimeMillis();
    // 어떤 메서드를 콜하는지 알아보기 위해.
    System.out.println("START : " + joinPoint.toString());
    try {
      // 다음 메서드로 진행
      return joinPoint.proceed();
    }
    finally{
      long finish = System.currentTimeMillis();
      long timeMs = finish - start;
      System.out.println("END : " + joinPoint.toString() + " " + timeMs + "ms");
    }
  }
}
