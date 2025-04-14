package com.example.order_service.Service;


import com.example.order_service.Entity.OrderModel;
import com.example.order_service.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderModel createOrder(OrderModel order){
        return orderRepository.save(order);
    }
}
