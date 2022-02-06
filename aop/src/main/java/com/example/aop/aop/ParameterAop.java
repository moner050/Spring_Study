package com.example.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class ParameterAop {

    // 메소드의 이름은 꼭 Pointcut 이 아니여도 된다.
    // controller 하위에있는 모든 메소드를 aop 로 보겠다고 설정
    @Pointcut("execution(* com.example.aop.controller..*.*(..))")
    private void pointCut()
    {

    }

    // 메소드가 실행되기 전 넘어가는 argument 가 뭔지
    @Before("pointCut()")
    public void before(JoinPoint joinPoint)
    {
        // 메소드의 이름
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println(method.getName());

        // joinPoint 에 들어가있는 매개변수들의 배열
        Object[] args = joinPoint.getArgs();

        for(Object obj : args)
        {
            System.out.println("type : " + obj.getClass().getSimpleName());
            System.out.println("value : " + obj);
        }
    }

    // 반환값이 뭔지
    @AfterReturning(value = "pointCut()", returning = "returnObj")
    public void afterReturn(JoinPoint joinPoint, Object returnObj)
    {
        System.out.println("return obj");
        System.out.println(returnObj);
    }


}
