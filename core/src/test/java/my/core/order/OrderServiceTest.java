package my.core.order;

import my.core.AppConfig;
import my.core.member.Grade;
import my.core.member.Member;
import my.core.member.MemberService;
import my.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    // 테스트가 실행되기 전에 무조건 실행이 되는 것
    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder(){
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        // 할인 금액이 천원인지 확인.
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}
