package com.example.jpademo.repository.orderitem;

import com.example.jpademo.domain.orderitem.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {



}
