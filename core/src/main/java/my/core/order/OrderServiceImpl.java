package my.core.order;

import my.core.discount.DiscountPolicy;
import my.core.discount.FixDiscountPolicy;
import my.core.member.Member;
import my.core.member.MemberRepository;
import my.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        // 일단 회원정보를 조회한다.
        Member member = memberRepository.findById(memberId);
        // 할인 정책을 받아온다.
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
