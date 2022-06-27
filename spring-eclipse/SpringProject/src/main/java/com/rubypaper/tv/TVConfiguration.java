package com.rubypaper.tv;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.rubypaper", "com.test"})
public class TVConfiguration {

	@Bean
	public TV tv() {
//		SamsungTV tv = new SamsungTV();
//		tv.setSpeaker(speaker());
		return new SamsungTV();
	}
	
	@Bean
	public Speaker speaker() {
		return new SonySpeaker();
	}
}
