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
public class AspectV3 {

    // hello.advancedaop.order 패키지와 그 하위 패키지 포함
    @Pointcut("execution(* hello.advancedaop.order..*(..))")
    private void allOrder(){} //pointcut signature

    // 클래스 이름 패턴이 *Service 인것들 포함
    @Pointcut("execution(* *..*Service.*(..))")
    private void allService(){}

    @Around("allOrder()")
    public Object doLog(ProceedingJoinPoint joinPoint) throws Throwable {
        // join point 시그니처 (메서드의 정보가 찍힌다.)
        log.info("[Log] {}", joinPoint.getSignature());
        return joinPoint.proceed();
    }

    // hello.advancedaop.order 패키지와 하위 패키지 이면서 클래스 이름 패턴이 *Service 인 것들만
    @Around("allOrder() && allService()")
    public Object doTransaction(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            log.info("[트랜잭션 시작] {}", joinPoint.getSignature());
            Object result = joinPoint.proceed();
            log.info("[트랜잭션 커밋] {}", joinPoint.getSignature());
            return result;
        }
        catch (Exception e) {
            log.info("[트랜잭션 롤백] {}", joinPoint.getSignature());
            throw e;
        }
        finally {
            log.info("[리소스 릴리즈] {}", joinPoint.getSignature());
        }
    }
}
