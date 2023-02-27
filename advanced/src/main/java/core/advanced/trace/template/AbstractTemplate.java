package core.advanced.trace.template;

import core.advanced.trace.TraceStatus;
import core.advanced.trace.logtrace.LogTrace;

public abstract class AbstractTemplate<T> {

    private final LogTrace trace;

    public AbstractTemplate(LogTrace trace) {
        this.trace = trace;
    }

    public T execute(String message) {
        TraceStatus status = null;
        try{
            status = trace.begin(message);
            // 로직 호출
            T result = call();
            trace.end(status);
            return result;
        }
        catch (Exception e) {
            trace.exception(status, e);
            // 예외를 꼭 다시 던져줘야 한다.
            throw e;
        }
    }

    protected abstract T call();
}
