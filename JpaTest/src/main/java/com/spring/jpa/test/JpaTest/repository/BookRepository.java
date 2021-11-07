package com.spring.jpa.test.JpaTest.repository;

import com.spring.jpa.test.JpaTest.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

    Book findByName(String name);



}
