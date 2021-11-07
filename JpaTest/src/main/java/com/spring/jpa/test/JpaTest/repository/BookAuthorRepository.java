package com.spring.jpa.test.JpaTest.repository;

import com.spring.jpa.test.JpaTest.domain.BookAuthor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookAuthorRepository extends JpaRepository<BookAuthor, Long> {
}
