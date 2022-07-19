package com.fastcampus.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Table(name = "USERS")
@Entity
public class User {
	@Id // 식별자 변수(== Primary Key) 선언
	// 1부터 시작하여 자동으로 1씩 값이 증가하도록 설정한다. 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; // 회원 일련번호
	private String username; // 아이디
	private String password; // 비밀번호
	private String email; // 이메일
	private String role;
	@CreationTimestamp // 현재 시간 정보가 자동으로 설정된다.
	private Timestamp createDate;
	
//    @OneToMany(fetch = FetchType.EAGER ,mappedBy = "user", cascade = CascadeType.REMOVE)
//    private List<Reply> replyList = new ArrayList<>();
}








