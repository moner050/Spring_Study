package com.spring.jpa.test.JpaTest.repository;

import com.spring.jpa.test.JpaTest.domain.BookReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookReviewRepository extends JpaRepository<BookReview, Long> {
}
