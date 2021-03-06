package com.spring.jpa.test.JpaTest.service;

import com.spring.jpa.test.JpaTest.domain.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.jpa.test.JpaTest.repository.CommentRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Transactional
    public void init()
    {
        for(int i = 0; i < 10; i++)
        {
            Comment comment = new Comment();
            comment.setComment("정말 대단하네요");

            commentRepository.save(comment);
        }
    }

    @Transactional(readOnly = true)
    public void updateSomething()
    {
        List<Comment> comments = commentRepository.findAll();

        for(Comment comment : comments)
        {
            comment.setComment("이야 이게뭐야");
            commentRepository.save(comment);
        }
    }
}
