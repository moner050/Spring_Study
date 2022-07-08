package com.rubypaper.jdbc.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "board.jdbc")
public class JDBCConnectionManagerProperties {

	private String driverClassName;
	private String url;
	private String username;
	private String password;
}
