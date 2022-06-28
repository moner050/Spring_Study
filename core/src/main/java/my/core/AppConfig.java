package my.core;

import my.core.discount.FixDiscountPolicy;
import my.core.member.MemberService;
import my.core.member.MemberServiceImpl;
import my.core.member.MemoryMemberRepository;
import my.core.order.OrderService;
import my.core.order.OrderServiceImpl;

public class AppConfig {

    // 생성자 주입을 통해 맴버 저장방식 지정
    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    // 생성자 주입을 통해 주문서비스의 저장방식과 할인정책 지정
    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }

}
