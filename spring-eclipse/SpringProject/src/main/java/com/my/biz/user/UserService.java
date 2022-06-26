package com.my.biz.user;

import java.util.List;

// 3. Service 인터페이스
public interface UserService {

	// USER 테이블 관련 CRUD 메소드
	// 회원 가입
	void insertUser(UserVO vo);

	// 회원 상세 조회
	UserVO getUser(UserVO vo);

	// 회원 목록 조회
	List<UserVO> getUserList();

}