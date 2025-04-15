package com.example.restaurant_service.Controller;


import com.example.restaurant_service.Entity.MenuItem;
import com.example.restaurant_service.Service.MenuItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant/{restaurantId}/order/items")
public class MenuItemController {

    private final MenuItemService menuItemService;

    public MenuItemController(MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }


    @GetMapping()
    public ResponseEntity<List<MenuItem>> getOrderItems(
            @PathVariable Long restaurantId,
            @RequestBody List<Long> itemIds
    ) {
        List<MenuItem> items = menuItemService.getMenuItems(restaurantId, itemIds);
        return ResponseEntity.ok(items);
    }
}
