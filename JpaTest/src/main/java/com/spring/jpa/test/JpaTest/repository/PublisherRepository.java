package com.spring.jpa.test.JpaTest.repository;

import com.spring.jpa.test.JpaTest.domain.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
