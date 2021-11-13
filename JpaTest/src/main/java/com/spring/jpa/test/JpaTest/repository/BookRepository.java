package com.spring.jpa.test.JpaTest.repository;

import com.spring.jpa.test.JpaTest.domain.Book;
import com.spring.jpa.test.JpaTest.domain.dto.BookNameAndCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    Book findByName(String name);
    List<Book> findByCategoryIsNull();
    List<Book> findAllByDeletedFalse();

    @Query(value = "select new com.spring.jpa.test.JpaTest.domain.dto.BookNameAndCategory(b.name, b.category) from Book b")
    List<BookNameAndCategory> findBookNameAndCategory();


    @Modifying
    @Query(value = "update book set category = 'none'", nativeQuery = true)
    void update();
}
