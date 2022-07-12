package com.my.JPAProject.persistance;

import com.my.JPAProject.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
