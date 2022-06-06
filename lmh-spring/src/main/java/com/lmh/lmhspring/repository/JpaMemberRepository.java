package com.lmh.lmhspring.repository;

import com.lmh.lmhspring.domain.Member;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;

public class JpaMemberRepository implements MemberRepository{

  // jpa 는 EntityManager 로 모든 동작을 한다.
  // .properties 에 설정한 정보와 DB 커넥션 정보를 다 모아서 Spring Boot 가 EntityManager 를 만들어 준다.
  // DB 에서 통신하는 것들을 내부에서 다 처리해준다.
  private final EntityManager em;

  public JpaMemberRepository(EntityManager em) {
    this.em = em;
  }

  @Override
  public Member save(Member member) {
    // jpa 가 알아서 insert 쿼리문을 만들어 db 에 집어넣고
    // em 에 member 를 영구저장한다.
    em.persist(member);
    return member;
  }

  @Override
  public Optional<Member> findById(Long id) {
    // 조회할 타입과 식별자 값을 넣어주면 조회가 된다.
    Member member = em.find(Member.class, id);
    return Optional.ofNullable(member);
  }

  @Override
  public Optional<Member> findByName(String name) {
    // PK(primary key)기반이 아닌 나머지것들은 JPQL 을 이용해서 찾아줘야 한다.
    List<Member> result = em.createQuery("select m from Member m where m.name= :name", Member.class)
        .setParameter("name", name)
        .getResultList();

    return result.stream().findAny();
  }

  @Override
  public List<Member> findAll() {
    // Member 객체 자체를 select 해서 조회하면 끝난다.
    return em.createQuery("select m from Member m", Member.class)
        .getResultList();
  }
}
