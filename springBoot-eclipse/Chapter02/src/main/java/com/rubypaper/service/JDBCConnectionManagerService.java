package com.rubypaper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import com.rubypaper.jdbc.util.JDBCConnectionManager;

public class JDBCConnectionManagerService implements ApplicationRunner{

	@Autowired
	private JDBCConnectionManager manager;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("생성된 커넥션 매니저 : " + manager.toString());
	}
	
}
