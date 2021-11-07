package com.spring.jpa.test.JpaTest.repository;

import com.spring.jpa.test.JpaTest.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
