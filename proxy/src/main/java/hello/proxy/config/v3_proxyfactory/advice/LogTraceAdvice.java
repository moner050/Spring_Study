package hello.proxy.config.v3_proxyfactory.advice;

import hello.proxy.trace.TraceStatus;
import hello.proxy.trace.logtrace.LogTrace;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

public class LogTraceAdvice implements MethodInterceptor {

    private final LogTrace logTrace;

    public LogTraceAdvice(LogTrace logTrace) {
        this.logTrace = logTrace;
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        TraceStatus status = null;
        try{
            Method method = invocation.getMethod();
            // 메서드에서 선언하는 클래스명과 메서드의 이름을 가져올수 있다.
            String message = method.getDeclaringClass().getSimpleName() + "." +
                    method.getName() + "()";
            status = logTrace.begin(message);

            // 로직 호출
            Object result = invocation.proceed();
            logTrace.end(status);
            return result;
        }
        catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }
}
