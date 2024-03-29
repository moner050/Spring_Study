package my.core.order;

import lombok.RequiredArgsConstructor;
import my.core.annotation.MainDiscountPolicy;
import my.core.discount.DiscountPolicy;
import my.core.member.Member;
import my.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

//    private final MemberRepository memberRepository;
//    private final DiscountPolicy rateDiscountPolicy;

    // 필드 주입방식
//    @Autowired
//    private final MemberRepository memberRepository;
//    @Autowired
//    private final DiscountPolicy discountPolicy;
//
//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
//
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        this.discountPolicy = discountPolicy;
//    }

    // memberRepository 가 Spring Bean에 등록이 안되있었을 수도 있으니깐
    // 주입할 대상이 없어도 동작하게 required = false 로 설정.
    // 선택적 의존관계를 주입하고 싶을 때 수정자 주입방식을 사용한다.
//    @Autowired(required = false)
//    public void setMemberRepository(MemberRepository memberRepository) {
//        System.out.println("setMemberRepository = " + memberRepository);
//        this.memberRepository = memberRepository;
//    }
//
//    @Autowired(required = false)
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        System.out.println("setDiscountPolicy = " + discountPolicy);
//        this.discountPolicy = discountPolicy;
//    }

    // 메서드 주입
//    @Autowired
//    public void init(MemberRepository memberRepository,
//                     DiscountPolicy discountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }

    // 생성자 주입 방식
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    // 만약 @Qualifier("mainDiscountPolicy") 를 못찾으면 mainDiscountPolicy 라는 이름의 스프링 빈을 추가로 찾는다.
    // 하지만 @Qualifier 는 @Qualifier 를 찾는 용도로 사용하는게 명확하고 좋다.
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository,
        @MainDiscountPolicy DiscountPolicy discountPolicy) {
        System.out.println("1. OrderServiceImpl");
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        // 일단 회원정보를 조회한다.
        Member member = memberRepository.findById(memberId);
        // 할인 정책을 받아온다.
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
