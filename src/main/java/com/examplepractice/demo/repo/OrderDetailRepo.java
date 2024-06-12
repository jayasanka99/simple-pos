package com.examplepractice.demo.repo;

import com.examplepractice.demo.entity.Order;
import com.examplepractice.demo.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories

public interface OrderDetailRepo extends JpaRepository<OrderDetails, Integer> {
}
