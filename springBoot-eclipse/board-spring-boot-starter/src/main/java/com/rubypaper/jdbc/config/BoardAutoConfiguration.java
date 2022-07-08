package com.rubypaper.jdbc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.rubypaper.jdbc.util.JDBCConnectionManager;

@Configurable
@EnableConfigurationProperties(JDBCConnectionManagerProperties.class)
public class BoardAutoConfiguration {
	
	@Autowired
	JDBCConnectionManagerProperties properties;
	
	public BoardAutoConfiguration() {
		System.out.println("===> BoardAutoConfiguration 생성");
	}
	
	@Bean
	@ConditionalOnMissingBean // JDBCConnectionManager타입의 객체가 메모리에 없다면 실행x
	public JDBCConnectionManager jdbcConnectionManager() {
		JDBCConnectionManager manager = new JDBCConnectionManager();
		manager.setDriverClass(properties.getDriverClassName());
		manager.setUrl(properties.getUrl());
		manager.setUsername(properties.getUsername());
		manager.setPassword(properties.getPassword());
		return manager;
	}

}
