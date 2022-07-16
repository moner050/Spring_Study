package com.fastcampus.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fastcampus.domain.Reply;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Integer> {

	@Query(name = "SELECT m FROM REPLY AS m WHERE m.POST_ID = :POST_ID")
	List<Reply> findAllByPost_Id(@Param("POST_ID") Integer id);

}
