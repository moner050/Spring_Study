package com.my.biz.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

// 2. Data Access Object 클래스 
// @Repository
public class UserDAOSpring implements UserDAO {

	@Autowired
	private JdbcTemplate spring;
	
	// STUDENT 테이블 관련 SQL 명령어
	private final String USER_INSERT = "insert into users(id, password, name, role) values(?, ?, ?, ?)";
	private final String USER_LIST   = "select * from users order by id desc";
	private final String USER_GET    = "select * from users where id = ?";

	// USER 테이블 관련 CRUD 메소드
	// 회원 가입
	public void insertUser(UserVO vo) {
		System.out.println("===> SPRING 기반으로 insertUser() 기능 처리");
	}
	
	// 회원 상세 조회
	public UserVO getUser(UserVO vo) {
		System.out.println("===> SPRING 기반으로 getUser() 기능 처리");
		return spring.queryForObject(USER_GET, new UserRowMapper(), vo.getId());
	}
	
	// 회원 목록 조회
	public List<UserVO> getUserList() {
		System.out.println("===> SPRING 기반으로 getUserList() 기능 처리");
		return spring.query(USER_LIST, new UserRowMapper());
	}
}
