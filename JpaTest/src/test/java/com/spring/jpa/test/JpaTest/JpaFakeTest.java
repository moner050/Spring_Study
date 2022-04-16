package com.spring.jpa.test.JpaTest;


import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Locale;


@SpringBootTest
public class JpaFakeTest {
    private static final Logger log = LoggerFactory.getLogger(JpaFakeTest.class);

    @Test
    public void jpaFakeTest()
    {
        Faker faker = new Faker(new Locale("ko"));

        String name = faker.name().fullName();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();

        String streetAddress = faker.address().streetAddress();

        log.info("fake name : " + name);
        log.info("fake firstName : " + firstName);
        log.info("fake lastName : " + lastName);
        log.info("fake streetAddress : " + streetAddress);

    }

}
