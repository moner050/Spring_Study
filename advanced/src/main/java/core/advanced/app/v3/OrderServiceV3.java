package core.advanced.app.v3;

import core.advanced.trace.TraceStatus;
import core.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV3 {

    private final OrderRepositoryV3 orderRepository;
    private final LogTrace trace;

    public void orderItem(String itemId) {
        TraceStatus status = null;
        try{
            status = trace.begin("OrderService.request()");
            orderRepository.save(itemId);
            trace.end(status);
        }
        catch (Exception e) {
            trace.exception(status, e);
            // 예외를 꼭 다시 던져줘야 한다.
            throw e;
        }
    }
}
