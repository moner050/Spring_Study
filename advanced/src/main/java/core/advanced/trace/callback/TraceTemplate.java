package core.advanced.trace.callback;

import core.advanced.trace.TraceStatus;
import core.advanced.trace.logtrace.LogTrace;

public class TraceTemplate {

    private final LogTrace trace;

    public TraceTemplate(LogTrace trace) {
        this.trace = trace;
    }

    public<T> T execute(String message, TraceCallback<T> callback){
        TraceStatus status = null;
        try{
            status = trace.begin(message);
            // 로직 호출
            T result = callback.call();
            trace.end(status);
            return result;
        }
        catch (Exception e) {
            trace.exception(status, e);
            // 예외를 꼭 다시 던져줘야 한다.
            throw e;
        }

    }
}
