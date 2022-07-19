package com.fastcampus.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fastcampus.domain.Post;
import com.fastcampus.domain.Reply;
import com.fastcampus.persistence.PostRepository;
import com.fastcampus.persistence.ReplyRepository;

@Service
@Transactional
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private ReplyRepository replyRepository;
	
	// 게시글 등록
	public void insertPost(Post post) {
		postRepository.save(post);	
	}
	
	// 게시글 목록
	public Page<Post> getPostList(Pageable pageable){
		return postRepository.findAll(pageable);
	}

	// 게시글 상세 보기
	public Post getPost(int id){
		Optional<Post> findPost = postRepository.findById(id);
		
		if(findPost.isPresent()) return findPost.get();
		return new Post();
	}
	
	// 게시글 수정
	public void updatePost(Post post) {
		postRepository.save(post);
	}
	
	// 게시글 삭제
	public void deletePost(Integer id) {
		postRepository.deleteById(id);
	}

}
