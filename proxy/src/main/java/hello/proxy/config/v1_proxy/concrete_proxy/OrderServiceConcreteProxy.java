package hello.proxy.config.v1_proxy.concrete_proxy;

import hello.proxy.app.v2.OrderServiceV2;
import hello.proxy.trace.TraceStatus;
import hello.proxy.trace.logtrace.LogTrace;

public class OrderServiceConcreteProxy extends OrderServiceV2 {

    private final OrderServiceV2 target;
    private final LogTrace logTrace;

    public OrderServiceConcreteProxy(OrderServiceV2 target, LogTrace logTrace) {
        // 부모 생성자를 강제로 호출해야 하지만 부모의 기능을 쓰지 않기 때문에 null 주입
        super(null);
        this.target = target;
        this.logTrace = logTrace;
    }

    @Override
    public void orderItem(String itemId) {
        TraceStatus status = null;
        try{
            status = logTrace.begin("OrderService.orderItem()");
            // target 호출
            target.orderItem(itemId);
            logTrace.end(status);
        }
        catch (Exception e) {
            logTrace.exception(status, e);
        }
    }
}
