package service;


import domain.Book;
import domain.dto.BookStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import repository.AuthorRepository;
import repository.BookRepository;

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
        Book book = new Book();
        book.setName("자바 jpa 공부");
        BookStatus bookStatus = new BookStatus(200);
        book.setStatus
    }
}
