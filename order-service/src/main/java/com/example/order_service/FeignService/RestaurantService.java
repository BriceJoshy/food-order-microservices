package com.example.order_service.FeignService;

import com.example.order_service.Dto.MenuItemDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "RESTAURANT-SERVICE", url = "http://localhost:8091") // or service name if using Eureka
public interface RestaurantService {

    @PostMapping("/restaurant/{restaurantId}/order/items")
    List<MenuItemDto> getMenuItemsForOrder(
            @PathVariable("restaurantId") Long restaurantId,
            @RequestBody List<Long> itemIds
    );
}