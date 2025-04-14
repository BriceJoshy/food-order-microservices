package com.example.order_service.Repository;

import com.example.order_service.Entity.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderModel, Long> {
}
