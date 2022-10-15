package my.core.discount;

import my.core.annotation.MainDiscountPolicy;
import my.core.member.Grade;
import my.core.member.Member;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        // 만약 맴버 등급이 VIP 이면 10% 할인을 적용해준다.
        if(member.getGrade() == Grade.VIP) return price * discountPercent / 100;
        else return 0;
    }
}
