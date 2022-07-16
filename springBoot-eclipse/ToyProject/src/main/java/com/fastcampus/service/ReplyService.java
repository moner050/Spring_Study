package com.fastcampus.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fastcampus.domain.Reply;
import com.fastcampus.persistence.ReplyRepository;

@Service
@Transactional
public class ReplyService {

	@Autowired
	private ReplyRepository replyRepository;
	
	// 댓글 목록
	public List<Reply> getReplyList(Integer id){
		return replyRepository.findAllByPost_Id(id);
	}
	
	// 댓글 추가
	public void insertReply(Reply reply) {
		replyRepository.save(reply);
	}
	
	// 댓글 삭제
	public void deleteReply(Integer id) {
		replyRepository.deleteById(id);
	}
	
}
