package com.spring.jpa.test.JpaTest.repository;

import com.spring.jpa.test.JpaTest.domain.UserHistory;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserHistoryRepository extends JpaRepository<UserHistory, Long> {
    List<UserHistory> findByUserId(Long userId);
    @EntityGraph(attributePaths = "user")
    List<UserHistory> findAll();
}
