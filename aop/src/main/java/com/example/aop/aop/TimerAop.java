package com.example.aop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class TimerAop {

    @Pointcut("execution(* com.example.aop.controller..*.*(..))")
    private void pointCut()
    {
    }

    @Pointcut("@annotation(com.example.aop.annotation.Timer)")
    private void enableTimer()
    {
    }

    @Around("pointCut() && enableTimer()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable
    {
        // 실행 전 시간측정
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object result = joinPoint.proceed();

        // 실행이 끝난 후 정지
        stopWatch.stop();

        System.out.println("total time : " + stopWatch.getTotalTimeSeconds());
    }
}
