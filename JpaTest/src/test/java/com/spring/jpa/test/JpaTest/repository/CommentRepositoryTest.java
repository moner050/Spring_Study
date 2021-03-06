package com.spring.jpa.test.JpaTest.repository;


import com.spring.jpa.test.JpaTest.domain.Comment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;

@SpringBootTest
public class CommentRepositoryTest {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ReviewRepository repository;

    @Autowired
    private EntityManager em;

    @Test
    void commentTest()
    {
        Comment comment = commentRepository.findById(1L).get();
        System.out.println(comment);
    }
}
