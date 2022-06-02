package com.my.biz.board;

import java.sql.Date;

import lombok.Data;

@Data
public class BoardVO {
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int cnt;
	
	// 검색 관련 멤버변수
	private String searchCondition;
	private String searchKeyword;
}
