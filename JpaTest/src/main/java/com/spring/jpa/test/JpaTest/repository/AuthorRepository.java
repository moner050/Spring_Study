package com.spring.jpa.test.JpaTest.repository;

import com.spring.jpa.test.JpaTest.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
