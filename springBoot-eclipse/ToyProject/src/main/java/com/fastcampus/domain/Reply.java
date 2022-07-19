package com.fastcampus.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fastcampus.dto.ReplyDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder(builderMethodName = "ReplyBuilder")
public class Reply {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String comment;
	
	@ManyToOne
	@JoinColumn(name = "POST_ID")
	private Post post;
	
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;
	
    // 댓글 리스트
//    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
//    private List<Reply> replyList = new ArrayList<>();

	public static ReplyBuilder replyBuilder(ReplyDto replyDto) {
		return ReplyBuilder().comment(replyDto.getComment());
	}
	
}
