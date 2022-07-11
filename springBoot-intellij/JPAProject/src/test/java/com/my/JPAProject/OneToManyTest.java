package com.my.JPAProject;

import com.my.JPAProject.domain.Member;
import com.my.JPAProject.domain.Order;
import com.my.JPAProject.persistance.MemberRepository;
import com.my.JPAProject.persistance.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class OneToManyTest {

    @Autowired
    private MemberRepository memberRepository;
    @Test
    void dataSelect() {
        Optional<Member> findOrder = memberRepository.findById(1);
        if(findOrder.isPresent()) {
            Member member = findOrder.get();
            System.out.println(member.getId() + "번 회원의 상세정보");
            System.out.println("회원 이름 : " + member.getName());
            System.out.println("거주 도시 : " + member.getCity());

            System.out.println("주문 목록");
//            for (Order order : member.getOrderList()){
//                System.out.println("---> " + order.getId() + " " + order.getStatus())   ;
//            }
        }
    }


}
