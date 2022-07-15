package com.fastcampus;

import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.fastcampus.domain.Member;
import com.fastcampus.persistence.MemberRepository;

@SpringBootTest
public class QueryMethodTest {

	@Autowired
	private MemberRepository memberRepository;
	
	@BeforeEach
	public void dataInsert() {
		for (int i = 1; i <= 200; i++) {
			Member member = new Member();
			member.setName("테스터 " + i);
			member.setCity("서울 " + i);;
			memberRepository.save(member);
		}
	}
	
	@Test
	void queryMethodTest1() {
		List<Member> memberList = memberRepository.getMemberList("09");

		
		System.out.println("[검색 회원 목록]");
		for (Member member : memberList) {
			System.out.println("---> " + member.toString());
		}

	}
	
	
	@Test
	void queryMethodTest() {
		Pageable pageable = PageRequest.of(0, 5); 
		
		Page<Member> pageInfo = memberRepository.findByNameContainingOrderByIdDesc("스터 10", pageable);
		for (Member member : pageInfo) {
			System.out.println("---> " + member.toString());
		}
		System.out.println("검색된 데이터의 수 : " + pageInfo.getTotalElements());
		System.out.println("현제 페이지의수 : " + pageInfo.getTotalPages());
		System.out.println("한 페이지에 출력되는 데이터의 수 : " + pageInfo.getSize());
		System.out.println("현제 페이지가 첫번째 페이지인가? : " + pageInfo.isFirst());
		System.out.println("현제 페이지가 첫번째 페이지인가? : " + pageInfo.isFirst());
		System.out.println("현제 페이지가 마지막 페이지인가? : " + pageInfo.isLast());
		
	}
	
}
