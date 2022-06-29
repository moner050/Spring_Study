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

    // 생성자 주입을 통해 맴버 저장방식 지정
    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    // 나중에 Repository 를 바꿀 때 이 코드만 바꾸면 된다.(구성영역)
    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    // 생성자 주입을 통해 주문서비스의 저장방식과 할인정책 지정
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    // 할인정책을 바꿀 때 이 코드만 바꾸면 된다. (구성영역)
    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
//        return new FixDiscountPolicy();
    }

}
