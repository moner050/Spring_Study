package hello.advancedaop.order.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/***
 * 스프링은 프록시 방식의 AOP 를 사용하므로,
 * 프록시를 통하는 메서드만 적용 대상이 된다.
 ***/
@Slf4j
@Aspect
public class AspectV2 {

    // hello.advancedaop.order 패키지와 그 하위 패키지 포함
    @Pointcut("execution(* hello.advancedaop.order..*(..))")
    private void allOrder(){} //pointcut signature

    @Around("allOrder()")
    public Object doLog(ProceedingJoinPoint joinPoint) throws Throwable {
        // join point 시그니처 (메서드의 정보가 찍힌다.)
        log.info("[Log] {}", joinPoint.getSignature());
        return joinPoint.proceed();
    }
}
