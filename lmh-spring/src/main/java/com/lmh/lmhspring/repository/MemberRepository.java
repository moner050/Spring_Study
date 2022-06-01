package com.lmh.lmhspring.repository;

import com.lmh.lmhspring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    // Optional 은 null 을 처리하는 방법으로
    // Optional 로 감싸서 반환하기 위해서 사용한다.
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();

}
