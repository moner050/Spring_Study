package com.spring.jpa.test.JpaTest.repository;

import domain.Address;
import domain.Review;
import domain.User;
import domain.UserHistory;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import repository.UserHistoryRepository;
import repository.UserRepository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Set;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserHistoryRepository userHistoryRepository;

    @Autowired
    private EntityManager entityManager;

    @Order(1)
    @Test
    void testUserPut()
    {
        User user = new User("홍길동", "test1@naver.com");
        Address address = new Address("서울시","관악구","난향동","11111");
        user.setHomeAddress(address);

        user = userRepository.save(user);
        System.out.println("user : " + user);
    }

    @Order(2)
    @Test
    void testUserGet()
    {
        Set<User> setUser = userRepository.findByEmail("test1@naver.com");
        System.out.println("findByEmail : " + setUser);
    }


    @Order(3)
    @Test
    void testUserHistoryTest()
    {
        List<UserHistory> userHistoryList = userHistoryRepository.findAll();
        System.out.println("userHistoryList");
    }

    @Test
    @Transactional
    void testUserRelationTest()
    {
        List<UserHistory> userHistoryList = userRepository.findOneByEmail("aaaa1@abc.com").getUserHistoryList();
        userHistoryList.forEach(System.out::println);

        List<Review> reviewList = userRepository.findOneByEmail("aaaa1@abc.com").getReviewList();
        reviewList.forEach(System.out::println);
    }

}
