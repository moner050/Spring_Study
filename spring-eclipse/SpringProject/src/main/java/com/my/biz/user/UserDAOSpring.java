package com.my.biz.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDAOSpring implements UserDAO {

	@Autowired
	private JdbcTemplate spring;
	
	// STUDENT 테이블 관련 SQL 명령어
	private final String USER_INSERT = "insert into users(id, password, name, role) values(?, ?, ?, ?)";
	private final String USER_LIST   = "select * from users order by id desc";
	private final String USER_GET    = "select * from users where id = ?";
	
	public void insertUser(UserVO vo) {
		System.out.println("===> SPRING 기반으로 insertUser() 기능 처리");
		spring.update(USER_INSERT, vo.getId(), vo.getPassword(), vo.getName(), vo.getRole());
	}

	public UserVO getUser(UserVO vo) {
		System.out.println("===> SPRING 기반으로 getUser() 기능 처리");
		return spring.queryForObject(USER_GET, new UserRowMapper(), vo.getId());
	}

	public List<UserVO> getUserList() {
		System.out.println("===> SPRING 기반으로 getUserList() 기능 처리");
		return spring.query(USER_LIST, new UserRowMapper());
	}

}
