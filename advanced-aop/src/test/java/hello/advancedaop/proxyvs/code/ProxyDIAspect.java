package hello.advancedaop.proxyvs.code;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Slf4j
@Aspect
public class ProxyDIAspect {

    @Before("execution(* hello.advancedaop..*.*(..))")
    public void toTrace(JoinPoint joinPoint) {
        log.info("[proxyDIAspect] {}", joinPoint.getSignature());
    }
}
