package com.fastcampus.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fastcampus.domain.Post;
import com.fastcampus.persistence.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	@Transactional
	public void insertPost(Post post) {
		postRepository.save(post);	
	}
	

}
