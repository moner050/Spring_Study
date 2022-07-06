package com.my.toyproject.persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.my.toyproject.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserDAOTest {

    @Autowired
    private UserDAO userDAO;

    @Test
    void userTest() {
        User user = new User();
        user.setId(6);
        user.setUsername("guest");
        user.setPassword("guest123");
        user.setEmail("guest@naver.com");

        int beforeSize = userDAO.getUserList().size();
        userDAO.insertUser(user);
        int afterSize = userDAO.getUserList().size();
        assertEquals(beforeSize + 1, afterSize);
    }

}
