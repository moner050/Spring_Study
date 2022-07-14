package com.my.toyproject.service;

import com.my.toyproject.domain.Post;
import com.my.toyproject.persistence.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    // 게시글 등록
    @Transactional
    public void insertPost(Post post){
        postRepository.save(post);
    }

    // 게시글 목록
    @Transactional
    public Page<Post> getPostList(Pageable pageable){
        return postRepository.findAll(pageable);
    }

}
