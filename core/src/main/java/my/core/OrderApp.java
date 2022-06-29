package my.core;

import my.core.member.Grade;
import my.core.member.Member;
import my.core.member.MemberService;
import my.core.order.Order;
import my.core.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {
        // 회원생성 후 주문할 때 할인정책이 잘 적용되나 테스트
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        // Spring 이 모든 객체들을 관리해 줄 수 있게 applicationContext 생성.
        // 어노테이션 기반으로 Config 를 관리해주고 있으니 AnnotationConfigApplicationContext
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        // AppConfig 에서 memberService 와 orderService 객체를 찾고 반환타입을 설정해준다.
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        // VIP 등급의 회원 생성
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        // 10000원 주문 생성 후 VIP 등급의 할인이 들어가나 테스트
        Order order = orderService.createOrder(memberId, "itemA", 20000);
        System.out.println("order = " + order);
        System.out.println("order = " + order.calculatePrice());

    }

}
