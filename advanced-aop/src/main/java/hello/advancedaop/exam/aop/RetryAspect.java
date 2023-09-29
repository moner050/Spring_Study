package hello.advancedaop.exam.aop;

import hello.advancedaop.exam.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Slf4j
@Aspect
public class RetryAspect {

    /**
     * 재시도 할 때 언제 내가 JoinPoint 를 호출할지 결정해야 하기 때문에 @Around 를 써야 한다.
     */
    @Around("@annotation(retry)")
    public Object doRetry(ProceedingJoinPoint joinPoint, Retry retry) throws Throwable {
        log.info("[retry] {} retry={} ", joinPoint.getSignature(), retry);

        int maxRetry = retry.value();
        Exception exceptionHolder = null;

        // 실패했을 때 재시도하는 로직 (예외가 터졌는데도 계속 실패하면 마지막으로 터진 예외를 던저준다.)
        for (int retryCount = 1; retryCount <= maxRetry; retryCount++) {
            try {
                log.info("[retry] try count={}/{}", retryCount, maxRetry);
                // 해당 Throwable 예외는 자바 메모리가 없거나 어떻게 할 수 없는 예외이기 때문에 밖으로 던져줌.
                return joinPoint.proceed();
            }
            catch (Exception e) {
                exceptionHolder = e;
            }
        }
        throw exceptionHolder;
    }
}
