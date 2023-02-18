package core.advanced.app.v2;

import core.advanced.trace.TraceId;
import core.advanced.trace.TraceStatus;
import core.advanced.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV2 {

    private final OrderRepositoryV2 orderRepository;
    private final HelloTraceV2 trace;

    public void orderItem(TraceId traceId, String itemId) {
        TraceStatus status = null;
        try{
            status = trace.beginSync(traceId, "OrderService.request()");
            orderRepository.save(status.getTraceId(), itemId);
            trace.end(status);
        }
        catch (Exception e) {
            trace.exception(status, e);
            // 예외를 꼭 다시 던져줘야 한다.
            throw e;
        }
    }
}
