package com.my.biz.user;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

// 2. Data Access Object 클래스 
// @Repository
public class UserDAOMyBatis implements UserDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	// USER 테이블 관련 CRUD 메소드
	// 회원 가입
	public void insertUser(UserVO vo) {
		System.out.println("===> MyBatis 기반으로 insertUser() 기능 처리");
		mybatis.insert("UserDAO.insertUser", vo);
	}
	
	// 회원 상세 조회
	public UserVO getUser(UserVO vo) {
		System.out.println("===> MyBatis 기반으로 getUser() 기능 처리");
		return mybatis.selectOne("UserDAO.getUser", vo);
	}
	
	// 회원 목록 조회
	public List<UserVO> getUserList() {
		System.out.println("===> MyBatis 기반으로 getUserList() 기능 처리");
		return new ArrayList<UserVO>();
	}
}
