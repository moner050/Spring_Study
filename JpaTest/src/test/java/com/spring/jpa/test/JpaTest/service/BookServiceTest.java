package com.spring.jpa.test.JpaTest.service;


import com.spring.jpa.test.JpaTest.domain.Book;
import com.spring.jpa.test.JpaTest.domain.dto.BookStatus;
import com.spring.jpa.test.JpaTest.repository.AuthorRepository;
import com.spring.jpa.test.JpaTest.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
public class BookServiceTest {
    @Autowired
    private BookService bookService;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    @Test
    void transactionPropagationTest()
    {
        try
        {
            bookService.putBookAuthor();
        }
        catch (RuntimeException e)
        {
            System.out.println(">>> " + e.getMessage());
        }
        System.out.println("books : " + bookRepository.findAll());
        System.out.println("authors : " + authorRepository.findAll());
    }

    @Test
    @Transactional
    void isolationTest()
    {
        Book book = new Book();
        book.setName("isolation 공부");
        BookStatus bookStatus = new BookStatus(200);
        book.setStatus(bookStatus);

        bookRepository.save(book);

        bookService.get(50L);

        System.out.println("isolationTest : " + bookRepository.findAll());
    }


}
