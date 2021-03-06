package com.spring.jpa.test.JpaTest.service;


import com.spring.jpa.test.JpaTest.domain.Book;
import com.spring.jpa.test.JpaTest.domain.dto.BookStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.spring.jpa.test.JpaTest.repository.AuthorRepository;
import com.spring.jpa.test.JpaTest.repository.BookRepository;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final EntityManager entityManager;
    private final AuthorService authorService;

    public List<Book> getBookList()
    {
        return bookRepository.findAll();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void putBookAuthor()
    {
        // book 데이터 생성
        Book book = new Book();
        book.setName("자바 jpa 공부");
        BookStatus bookStatus = new BookStatus(200);
        book.setStatus(bookStatus);
        bookRepository.save(book);

        // author 데이터 생성
        try
        {
            authorService.putAuthor();
        }
        catch(RuntimeException e)
        {
            log.error("author 데이터 생성 에러 : " + e);
        }
    }


    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void get(Long id)
    {
        System.out.println(">>> findById1 : " + bookRepository.findById(id));
        System.out.println(">>> findAll2 : " + bookRepository.findAll());

        entityManager.clear();

        System.out.println(">>> findById2 : " + bookRepository.findById(id));
        System.out.println(">>> findAll2 : " + bookRepository.findAll());

        bookRepository.update();

        System.out.println(">>> findById3 : " + bookRepository.findById(id));

        entityManager.clear();

        Book book = bookRepository.findById(id).get();
        book.setName("테스트이름");
        bookRepository.save(book);
    }


}
