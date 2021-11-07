package com.spring.jpa.test.JpaTest.service;

import com.spring.jpa.test.JpaTest.domain.Author;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.spring.jpa.test.JpaTest.repository.AuthorRepository;


@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    @Transactional(propagation = Propagation.NEVER)
    public void putAuthor()
    {
        Author author = new Author();
        author.setName("김민수");

        authorRepository.save(author);
    }

}
