package com.spring.jpa.test.JpaTest.service;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.spring.jpa.test.JpaTest.repository.UserRepository;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    void test1()
    {
        userService.put();
    }

}
