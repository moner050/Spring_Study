package hello.advancedaop.order.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Slf4j
@Aspect
public class AspectV6Advice {

    // 메서드의 실행의 주변에서 실행된다.
    // 메서드 실행 전 후에 작업을 수행한다.
    // @Around 는 무조건 ProceedingJoinPoint 를 호출해줘야 한다.
    // 다음 어드바이스나 타겟을 호출할 proceed 메서드가 필요하기 때문이다.
    // hello.advancedaop.order 패키지와 하위 패키지 이면서 클래스 이름 패턴이 *Service 인 것들만
    @Around("hello.advancedaop.order.aop.Pointcuts.orderAndService()")
    public Object doTransaction(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            //@Before
            log.info("[트랜잭션 시작] {}", joinPoint.getSignature());
            Object result = joinPoint.proceed();
            //@AfterReturning
            log.info("[트랜잭션 커밋] {}", joinPoint.getSignature());
            return result;
        }
        catch (Exception e) {
            //@AfterThrowing
            log.info("[트랜잭션 롤백] {}", joinPoint.getSignature());
            throw e;
        }
        finally {
            //@After
            log.info("[리소스 릴리즈] {}", joinPoint.getSignature());
        }
    }

    // JoinPoint 를 실행하기 전에 작업을 수행하고 싶으면 @Before 태그 사용하기
    @Before("hello.advancedaop.order.aop.Pointcuts.orderAndService()")
    public void doBefore(JoinPoint joinPoint) {
        log.info("[before] {}", joinPoint.getSignature());
    }

    // JoinPoint 가 실행된 후 작업을 수행하고 싶으면 @AfterReturning 태그 사용하기
    @AfterReturning(value = "hello.advancedaop.order.aop.Pointcuts.orderAndService()", returning = "result")
    public void doReturn(JoinPoint joinPoint, Object result) {
        log.info("[return] {} return ={}", joinPoint.getSignature(), result);
    }

    // JoinPoint 가 실행된 후 작업을 수행하고 싶으면 @AfterReturning 태그 사용하기
    @AfterReturning(value = "hello.advancedaop.order.aop.Pointcuts.allOrder()", returning = "result")
    public void doReturn2(JoinPoint joinPoint, String result) {
        log.info("[return2] {} return2 ={}", joinPoint.getSignature(), result);
    }

    // 메서드 실행이 예외를 던져서 종료될 때 실행
    @AfterThrowing(value = "hello.advancedaop.order.aop.Pointcuts.orderAndService()", throwing = "ex")
    public void doThrowing(JoinPoint joinPoint, Exception ex) {
        log.info("[ex] {} message={}", ex);
    }

    // 메서드 실행이 종료되면 실행
    @After(value = "hello.advancedaop.order.aop.Pointcuts.orderAndService()")
    public void doAfter(JoinPoint joinPoint) {
        log.info("[after] {}", joinPoint.getSignature());
    }
}
