package com.lmh.lmhspring.service;

import com.lmh.lmhspring.domain.Member;
import com.lmh.lmhspring.repository.MemberRepository;
import com.lmh.lmhspring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    // 같은 MemoryMemberRepository 를 사용하기 위해
    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    // 테스트를 한개 끝날 때 마다 실행됨.
    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        // given
        // 맴버에 Lee 라는 이름의
        Member member = new Member();
        member.setName("Lee");

        // when
        Long saveId = memberService.join(member);

        // then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void 중복_회원_예외(){
        // given
        Member member1 = new Member();
        member1.setName("Lee");

        Member member2 = new Member();
        member2.setName("Lee");

        // when
        memberService.join(member1);
//        try
//        {
//            memberService.join(member2);
//            fail();
//        }
//        catch(IllegalStateException e)
//        {
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.1");
//        }

        // 이 로직을 실행하면 IllegalStateException 예외처리가 터져야 한다.
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        // then


    }


    @Test
    void 전체_회원_찾기() {
    }

    @Test
    void 회원_찾기() {
    }
}