package com.spring.jpa.test.JpaTest.repository;


import com.spring.jpa.test.JpaTest.domain.Book;
import com.spring.jpa.test.JpaTest.domain.dto.BookStatus;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@DisplayName("BookRepository 관련 테스트")
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @Order(1)
    @Test
    void testBookPut()
    {
        Book book = new Book();
        book.setName("JPA 학습2");
        BookStatus bookStatus = new BookStatus(200);
        book.setStatus(bookStatus);

        bookRepository.save(book);

        System.out.println(bookRepository.findAll());
    }

    @Order(2)
    @Test
    void bookQueryTest()
    {
        Book book = bookRepository.findByName("JPA 학습2");
        System.out.println("book : " + book);
    }

    @DisplayName("category 컬럼 null체크")
    @Order(3)
    @Test
    void bookQueryFindByCategoryIsNull()
    {
        List<Book> bookList = bookRepository.findByCategoryIsNull();
        System.out.println("bookList : " + bookList);
    }

    @DisplayName("deleted 컬럼 false 쿼리")
    @Order(4)
    @Test
    void bookQueryFindAllByDeletedFalse()
    {
        List<Book> bookList = bookRepository.findAllByDeletedFalse();
        System.out.println("bookList : " + bookList);
    }




}
