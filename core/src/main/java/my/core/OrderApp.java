package my.core;

import my.core.member.Grade;
import my.core.member.Member;
import my.core.member.MemberService;
import my.core.order.Order;
import my.core.order.OrderService;

public class OrderApp {

    public static void main(String[] args) {
        // 회원생성 후 주문할 때 할인정책이 잘 적용되나 테스트
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        // VIP 등급의 회원 생성
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        // 10000원 주문 생성 후 VIP 등급의 할인이 들어가나 테스트
        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order);
        System.out.println("order = " + order.calculatePrice());

    }

}
