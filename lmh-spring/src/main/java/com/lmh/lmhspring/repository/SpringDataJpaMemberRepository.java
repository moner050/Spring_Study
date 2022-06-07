package com.lmh.lmhspring.repository;

import com.lmh.lmhspring.domain.Member;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

// 첫번째는 T, 두번째는 Entity 에서의 PK 값의 타입
// JpaRepository 를 받고 있으면 구현체를 자동으로 만들어 Spring Bean 에 자동으로 등록해 준다.
// 이것을 그냥 가져다가 쓰면 된다.
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

  // JPQL : SELECT m FROM Member m WHERE m.name = ?
  @Override
  Optional<Member> findByName(String name);
}
