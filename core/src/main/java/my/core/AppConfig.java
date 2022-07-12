package my.core;

import my.core.discount.DiscountPolicy;
import my.core.discount.RateDiscountPolicy;
import my.core.member.MemberService;
import my.core.member.MemberServiceImpl;
import my.core.member.MemoryMemberRepository;
import my.core.order.OrderService;
import my.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // 2개의 MemoryMemberRepository() 객체가 생성되어서 싱글톤이 깨지는 것 처럼 보이지만 아니다.
    // @Bean memberService -> new MemoryMemberRepository()
    // @Bean orderService  -> new MemoryMemberRepository()

    // @Configuration 어노테이션을 붙혔을 때.
    // call AppConfig.memberService
    // call AppConfig.memberRepository
    // call AppConfig.orderService

    // @Configuration 어노테이션 없이 돌렸을 때
//    call AppConfig.memberService
//    call AppConfig.memberRepository
//    call AppConfig.memberRepository
//    call AppConfig.orderService
//    call AppConfig.memberRepository
    // 싱글톤이 깨진다.


    // 생성자 주입을 통해 맴버 저장방식 지정
    @Bean
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    // 나중에 Repository 를 바꿀 때 이 코드만 바꾸면 된다.(구성영역)
    @Bean
    public MemoryMemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    // 생성자 주입을 통해 주문서비스의 저장방식과 할인정책 지정
    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    // 할인정책을 바꿀 때 이 코드만 바꾸면 된다. (구성영역)
    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
//        return new FixDiscountPolicy();
    }

}
