package com.fastcampus.persistence;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fastcampus.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {

	List<Member> findByName(String name);
	List<Member> findByNameContaining(String name);
	List<Member> findByNameContainingOrCityContaining(String name, String city);
	List<Member> findByNameContainingAndCityContaining(String name, String city);
	// ID 를 오름차순으로 정렬
	Page<Member> findByNameContainingOrderByIdDesc(String name, Pageable pageable);
	
	@Query(value = "select member_id, city, name from member where city like '%'|%|:keyword||'%' order by member_id desc", nativeQuery = true)
	List<Member> getMemberList(@Param("keyword") String keyword);
}
