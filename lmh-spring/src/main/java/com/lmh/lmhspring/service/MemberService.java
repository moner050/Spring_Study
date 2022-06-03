package com.lmh.lmhspring.service;

import com.lmh.lmhspring.domain.Member;
import com.lmh.lmhspring.repository.MemberRepository;
import com.lmh.lmhspring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public class MemberService {
    // 생성자 주입 (가장 권장)
    private final MemberRepository memberRepository;

    // 외부에서 memberRepository 를 넣어준다.(DI)
    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 필드 주입방법
//    @Autowired private MemberRepository memberRepository;

    // 세터 주입방법
//    private MemberRepository memberRepository;
//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

    // 회원가입
    public Long join(Member member){
        // 같은 이름이 있는 중복 회원 불가능 (중복회원 검증)
        validateDuplicateMember(member);

        // 회원가입 되면 아이디만 반환
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
        // 만약 값이 있으면 이미 존재하는 회원 출력(Optional 이여서 가능.)
            .ifPresent(M -> {
                throw new IllegalStateException("이미 존재하는 회원입니다.");
            });
    }

    // 전체회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    // 회원 조회
    public Optional<Member> findOne(Long member){
        return memberRepository.findById(member);
    }

}
