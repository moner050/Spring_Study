package com.spring.jpa.test.JpaTest.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import repository.CommentRepository;
import service.CommentService;

@SpringBootTest
public class CommentServiceTest {
    @Autowired
    private CommentService commentService;

    @Autowired
    private CommentRepository commentRepository;

    @Test
    void commentTest()
    {
        commentService.updateSomething();
    }
}
