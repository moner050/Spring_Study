package com.spring.jpa.test.JpaTest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest(properties = "spring.config.location="
				+ "classpath:/application-test.yaml")
class JpaTestApplicationTests {

	@Test
	void contextLoads() {
	}

}
