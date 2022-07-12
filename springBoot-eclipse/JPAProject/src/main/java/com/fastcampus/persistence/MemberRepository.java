package com.fastcampus.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fastcampus.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {

}
