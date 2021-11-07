package com.spring.jpa.test.JpaTest.domain.listener;

import com.spring.jpa.test.JpaTest.domain.User;
import com.spring.jpa.test.JpaTest.domain.UserHistory;
import com.spring.jpa.test.JpaTest.repository.UserHistoryRepository;
import com.spring.jpa.test.JpaTest.support.BeanUtils;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;

public class UserEntityListener {
    @PostPersist
    @PostUpdate
    public void prePersistAndPreUpdate(Object o) {
        UserHistoryRepository userHistoryRepository = BeanUtils.getBean(UserHistoryRepository.class);

        User user = (User)o;

        UserHistory userHistory = new UserHistory();
        userHistory.setName(user.getName());
        userHistory.setEmail(user.getEmail());
        userHistory.setUser(user);
        userHistory.setHomeAddress(user.getHomeAddress());
        userHistory.setCompanyAddress(user.getCompanyAddress());

        userHistoryRepository.save(userHistory);
    }
}
