package com.example.restaurant_service.Service;


import com.example.restaurant_service.Entity.Menu;
import com.example.restaurant_service.Entity.MenuItem;
import com.example.restaurant_service.Entity.Restaurant;
import com.example.restaurant_service.Repository.MenuItemRepository;
import com.example.restaurant_service.Repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemService {

    private final RestaurantRepository restaurantRepository;
    private final MenuItemRepository menuItemRepository;

    public MenuItemService(RestaurantRepository restaurantRepository, MenuItemRepository menuItemRepository) {
        this.restaurantRepository = restaurantRepository;
        this.menuItemRepository = menuItemRepository;
    }

    public List<MenuItem> getMenuItems(Long restaurantId, List<Long> menuItemIds){
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("Restaurant noe found"));

        Menu menu = restaurant.getMenu();

        return menu.getMenuItemList().stream()
                .filter(item -> menuItemIds.contains(item.getMenuItemId()))
                .toList();
    }
}
