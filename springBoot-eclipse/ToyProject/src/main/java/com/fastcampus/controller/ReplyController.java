package com.fastcampus.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fastcampus.domain.Post;
import com.fastcampus.domain.Reply;
import com.fastcampus.domain.User;
import com.fastcampus.security.jpa.UserDetailsImpl;
import com.fastcampus.service.PostService;
import com.fastcampus.service.ReplyService;
import com.fastcampus.service.UserService;

@Controller
public class ReplyController {

	@Autowired
	private ReplyService replyService;
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private UserService userService;
	
	// 댓글 등록
	@PostMapping("/post/insertReply")
	public String insertReply(@RequestBody Reply reply, HttpSession session, @AuthenticationPrincipal UserDetailsImpl userDetailsImpl) {
		Post myPost = (Post) session.getAttribute("post");
		
		reply.setPost(myPost);
		reply.setUser(userDetailsImpl.getUser());
		
		System.out.println(reply.toString());
		replyService.insertReply(reply);
		
		return "/post/" + reply.getPost().getId();
	}
	
	// 댓글 삭제
	@PostMapping("/post/{id}/deleteReply")
	public String delteReply() {
		return "";
	}
	
}
