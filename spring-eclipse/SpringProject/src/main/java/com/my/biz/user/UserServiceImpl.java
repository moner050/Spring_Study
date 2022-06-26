package com.my.biz.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 4. Service 구현 클래스
@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	public void insertUser(UserVO vo) {
		userDAO.insertUser(vo);
	}

	public UserVO getUser(UserVO vo) {
		
		return userDAO.getUser(vo);
	
	}

	public List<UserVO> getUserList() {
		return userDAO.getUserList();
	}
}



