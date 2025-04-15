package com.example.order_service.Service;


import com.example.order_service.Dto.MenuItemDto;
import com.example.order_service.Entity.OrderModel;
import com.example.order_service.FeignService.RestaurantService;
import com.example.order_service.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private final OrderRepository orderRepository;
    private final RestaurantService restaurantService;

    public OrderService(OrderRepository orderRepository, RestaurantService restaurantService) {
        this.orderRepository = orderRepository;
        this.restaurantService = restaurantService;
    }

    public OrderModel createOrder(OrderModel order){
        return orderRepository.save(order);
    }
    public List<MenuItemDto> getItemsForOrder(Long restaurantId, List<Long> itemIds) {
        return restaurantService.getMenuItemsForOrder(restaurantId, itemIds);
    }
}
