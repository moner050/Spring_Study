package com.fastcampus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.fastcampus.service.ReplyService;

@Controller
public class ReplyController {

	@Autowired
	private ReplyService replyService;
	
	// 댓글 등록
	@PostMapping("/post/{id}/insertReply")
	public String insertReply() {
		return "";
	}
	
	// 댓글 삭제
	@PostMapping("/post/{id}/deleteReply")
	public String delteReply() {
		return "";
	}
	
}
