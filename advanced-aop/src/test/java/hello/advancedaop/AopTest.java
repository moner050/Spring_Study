package hello.advancedaop;

import hello.advancedaop.order.OrderRepository;
import hello.advancedaop.order.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class AopTest {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderRepository orderRepository;

    @Test
    void aopInfo() {
        // AOP 프록시가 적용이 되었는지 조회해보기
        log.info("isAopProxy, OrderService={}", AopUtils.isAopProxy(orderService));
        log.info("isAopProxy, OrderRepository={}", AopUtils.isAopProxy(orderRepository));
    }

    @Test
    void success() {
        // 성공하는 로직
        orderService.orderItem("itemA");
    }

    @Test
    void exception() {
        // 실패(예외처리) 가 되는 로직
        Assertions.assertThatThrownBy(() -> orderService.orderItem("ex"))
                .isInstanceOf(IllegalStateException.class);
    }
}
