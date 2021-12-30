package com.example.jpademo.repository.order;

import com.example.jpademo.domain.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {



}
